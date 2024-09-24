package vn.iotstar.utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static vn.iotstar.utils.Constant.UPLOAD_DIRECTORY;

@WebServlet(name = "MultipartServlet", urlPatterns = { "/MultipartServlet" })

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class MultipartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/result.jsp").forward(req, resp);
	}
	
	private String getFileName(Part part) {

		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return Constant.DEFAULT_FILENAME;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadPath = File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();
		try {
			String fileName = "";
			for (Part part : request.getParts()) {
				fileName = getFileName(part);
				part.write(uploadPath + File.separator + fileName);

			}
			request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
		} catch (FileNotFoundException fne) {
			request.setAttribute("message", "There was an error: " + fne.getMessage());

		}
		getServletContext().getRequestDispatcher("/views/result.jsp").forward(request, response);
	}
}