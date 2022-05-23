package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		// get data from listProductDAO
		ListProductDAO dao = new ListProductDAO();
		List<Product> list = dao.getAllProduct();
		
		//set data to jsp
		req.setAttribute("listP", list);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
