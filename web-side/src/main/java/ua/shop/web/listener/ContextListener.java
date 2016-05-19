package ua.shop.web.listener; /**
 * @author Oleg Dashkevych.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ua.shop.captcha.CaptchaManager;
import ua.shop.captcha.provider.CaptchaProvider;
import ua.shop.captcha.provider.ContextCaptchaProvider;
import ua.shop.captcha.util.CaptchaCleaner;
import ua.shop.web.HttpAttributeNames;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.security.ProviderException;

/**
 * @author Oleg Dashkevych.
 */
@WebListener()
public class ContextListener implements ServletContextListener {

	private static final Logger LOGGER = Logger.getLogger(ContextListener.class);

	private CaptchaManager captchaManager;

	/**
	 * Default constructor
	 */
	public ContextListener() {
	}

	/**
	 * sets logger params and adds constants to servlet context
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LOGGER.debug(this.getClass().getName() + " started");
		ServletContext servletContext = servletContextEvent.getServletContext();
		PropertyConfigurator.configure(servletContext.getRealPath("WEB-INF/log4j.properties"));
		setProvider(servletContext);
	}

	private void setProvider(ServletContext servletContext) {
		String providerClass = servletContext.getInitParameter("provider");
		String timeInterval = servletContext.getInitParameter("interval");
		try {
			CaptchaProvider provider = (CaptchaProvider) Class.forName(providerClass).newInstance();
			captchaManager = new CaptchaManager(provider);
			if (captchaManager.isContextManager()) {
				setThreadCleaner(provider, Long.valueOf(timeInterval), servletContext);
			}
			servletContext.setAttribute(HttpAttributeNames.CAPTCHA_MANAGER, captchaManager);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ProviderException(e);
		}
	}

	private void setThreadCleaner(CaptchaProvider provider, long timeInterval, ServletContext context) {
		Thread mapCleaner = new Thread(new CaptchaCleaner(timeInterval, ((ContextCaptchaProvider) provider).getCaptchaConcurrentHashMap()));
		mapCleaner.start();
		context.setAttribute(HttpAttributeNames.CAPTCHA_MAP_CLEANER, mapCleaner);
	}

	/**
	 * Destroys listener
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		if (captchaManager.isContextManager()) {
			CaptchaCleaner cleaner = (CaptchaCleaner) sce.getServletContext().getAttribute(HttpAttributeNames.CAPTCHA_MAP_CLEANER);
			cleaner.stop();
		}
		LOGGER.debug(this.getClass().getName() + " ended");
	}
}
