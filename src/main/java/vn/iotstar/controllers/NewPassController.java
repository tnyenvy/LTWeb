package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/newpass" })
public class NewPassController extends HttpServlet {

	private static final long serialVersionUID = 7237164366037429729L;
	
	IUserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/newpass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String newpass = req.getParameter("newpass");
		String passagain = req.getParameter("passagain");
		
		String alertMsg = "";

		if (service.checkExistEmail(email) == false) {
			alertMsg = "Email không đúng!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/newpass.jsp").forward(req, resp);
			return;
		}
		
		if (newpass.isEmpty() || passagain.isEmpty())
		{
			alertMsg = "Mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/newpass.jsp").forward(req, resp);
			return;
		}
		
		if (newpass.equals(passagain))
		{
			service.update(passagain, email);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		else {
			alertMsg = "Xác nhận mật khẩu chưa đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/newpass.jsp").forward(req, resp);
			return;
		}
	}
}