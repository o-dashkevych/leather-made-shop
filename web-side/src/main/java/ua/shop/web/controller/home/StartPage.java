package ua.shop.web.controller.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Oleh_Dashkevych.
 */
@WebServlet(urlPatterns = {"/home"}, name = "start-page")
public class StartPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		synchronized (req.getSession()) {
			req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
		}
	}
}
