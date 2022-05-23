package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Account;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userMail = req.getParameter("user");
		String password = req.getParameter("pass");
		
		ListProductDAO dao = new ListProductDAO();
		Account a = dao.login(userMail, password);
		if(a==null) {
			req.setAttribute("mess", "wrong user or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else if(a.getRole() == 0){
			HttpSession session = req.getSession(true);
			session.setAttribute("infoCustommer", a);
			resp.sendRedirect("home");
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", a.getName());
			resp.sendRedirect("admin/index.jsp");
		}
	}
}
