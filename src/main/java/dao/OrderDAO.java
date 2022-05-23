package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.Cart;
import model.Orders;

public class OrderDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertOrder(Orders o, Cart c) {
		String query = "insert into Orders(user_mail, order_status, order_discount_code, order_address)"
				+ " values(?, ?, ?, ?)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, o.getUserMail());
			ps.setInt(2, o.getStatus());
			ps.setString(3, o.getDiscount());
			ps.setString(4, o.getAddress());
			
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
