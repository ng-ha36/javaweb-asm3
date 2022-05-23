package controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/detail"})
public class ListDetailController  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		try {
			String id = req.getParameter("id");
			ListProductDAO dao = new ListProductDAO();
			Product myProduct  = dao.getProduct(id);
			req.setAttribute("product", myProduct);
			req.getRequestDispatcher("infoProduct.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.getWriter().println();
		}

	}
}
