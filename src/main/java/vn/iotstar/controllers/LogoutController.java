package vn.iotstar.controllers;

import java.io.IOException;
import java.net.HttpCookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 7475196146756545038L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.invalidate();
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req.getRequestDispatcher("/views/logout.jsp").forward(req, resp);
	}
}