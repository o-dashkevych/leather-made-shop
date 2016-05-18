package ua.shop.web.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Encoding filter.
 *
 * @author O.Dashkevych
 */
@WebFilter(
		filterName = "EncodingFilters",
		urlPatterns = {"/*"},
		initParams = {@WebInitParam(name = "encoding", value = "UTF-8")}
)
public class EncodingFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(EncodingFilter.class);

	private String encoding;

	/**
	 * destroys filter
	 */
	public void destroy() {
		LOG.debug("Filter destruction starts");
		// no op
		LOG.debug("Filter destruction finished");
	}

	/**
	 * Checks and changes encoding
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		LOG.debug("Filter starts");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		LOG.trace("Request uri --> " + httpRequest.getRequestURI());
		setEncoding(httpRequest, httpResponse);
		LOG.debug("Filter finished");
		chain.doFilter(httpRequest, httpResponse);
	}

	/**
	 * setCaptcha ups encoding
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");
		encoding = fConfig.getInitParameter("encoding");
		LOG.trace("Encoding from web.xml --> " + encoding);
		LOG.debug("Filter initialization finished");
	}

	private void setEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String requestEncoding = request.getCharacterEncoding();
		if (requestEncoding == null) {
			LOG.trace("Request encoding = null, setCaptcha encoding --> " + encoding);
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
	}
}

