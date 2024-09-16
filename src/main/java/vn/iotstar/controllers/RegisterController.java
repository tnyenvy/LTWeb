package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1122L;

	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
//		HttpSession session = req.getSession(false);
//		if (session != null && session.getAttribute("username") != null) {
//			resp.sendRedirect(req.getContextPath() + "/admin");
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");

		String alertMsg = "";

		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		boolean isSuccess = service.register(username, password, fullname, email, phone);
		if (isSuccess) {
			//SendMail sm = new SendMail();
			//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		}

	}	
}