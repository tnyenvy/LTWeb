package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/forget" })
public class ForgetController extends HttpServlet {

	private static final long serialVersionUID = 123L;
	
	IUserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		
		String alertMsg = "";

		if (service.checkExistEmail(email) == false) {
			alertMsg = "Email không đúng!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
			return;
		}
		else {
			req.getRequestDispatcher("/views/newpass.jsp").forward(req, resp);
			return;
		}
		
	}
}