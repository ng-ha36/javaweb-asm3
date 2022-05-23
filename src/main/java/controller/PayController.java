package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Cart;
import model.Orders;

@WebServlet(urlPatterns = {"/PayController"})
public class PayController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		
		try {
			HttpSession session = req.getSession(true);
			
			if(session.getAttribute("cart") == null) {
				resp.sendRedirect("home");
				return;
			}
			
			OrderDAO dao = new OrderDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String username = req.getParameter("name");
			String discount = req.getParameter("discount");
			String address = req.getParameter("address");
			Orders d = new Orders(username, 0, discount, address, "", null);
			dao.insertOrder(d,c);
			resp.sendRedirect("home");
		} catch (Exception e) {
			resp.getWriter().println(e);
			e.printStackTrace();
		}
	}
}
