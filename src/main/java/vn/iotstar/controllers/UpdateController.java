package vn.iotstar.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = { "/update" })
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 3732844546597075369L;

	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String images = req.getParameter("images");

		service.updateProfile("Vy", fullname, phone, images);

		req.getRequestDispatcher("/views/myaccount.jsp").forward(req, resp);
	}
}