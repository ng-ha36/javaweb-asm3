package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

@WebServlet(urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		try {
			HttpSession session = req.getSession(true);
			String idd = req.getParameter("id");
			String action = req.getParameter("action");
			
			if(session.getAttribute("cart") == null) {
				session.setAttribute("cart", new Cart());
			}
			Cart c = (Cart) session.getAttribute("cart");
			
			if(action != null && action.equalsIgnoreCase("add")) {
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProduct("" + id);
				c.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getSrc(), p.getType(), p.getBrand(), 1));
			} else if (action != null && action.equalsIgnoreCase("delete")){
				int id = Integer.parseInt(idd);
				c.remove(id);
			}
			session.setAttribute("cart", c);
			resp.sendRedirect("cart.jsp");
		} catch (Exception e) {
			resp.getWriter().println(e);
		}
	}
}
