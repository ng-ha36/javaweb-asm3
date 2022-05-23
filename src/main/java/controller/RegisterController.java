package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Account;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		String user = req.getParameter("email");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String co_password = req.getParameter("co-password");
		
		if(!password.equals(co_password)) {
			resp.sendRedirect("register.jsp");
		} else {
			ListProductDAO dao = new ListProductDAO();
			Account a = dao.checkAccountExit(user);
			if(a==null) {
				// register
				dao.register(user, password, 0, name, address, phone);
				resp.sendRedirect("home");
			} else {
				resp.sendRedirect("login.jsp");
			}
		}
	}
}
