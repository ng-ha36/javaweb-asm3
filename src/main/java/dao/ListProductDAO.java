package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Product;

public class ListProductDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//load products into home page
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products ";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	//search
	public List<Product> search(String txtSearch) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products\r\n"
				+ "Where product_name like ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+ txtSearch +"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4), 
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	public Product getProduct(String id) {
		String query = "select * from dbo.Products where product_id = ?";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));
			}
		} catch (Exception e) {
			  System.out.println(e.toString());
		}
		return null;
	}
	
	
	// login
	public Account login(String user, String pass) {
		String query = "select * from Account\r\n"
				+ "where user_mail = ?\r\n"
				+ "and password = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getString(1),
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// check account 
	public Account checkAccountExit(String user) {
		String query = "select * from Account\r\n"
				+ "where user_mail = ?\r\n"
				+ "and password = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getString(1),
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// register
	public void register(String user, String pass, int role, String name, String address, String phone) {
		String query = "insert into Account\r\n"
				+ "values (?,?,?,?,?,?)";
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setInt(3, role);
			ps.setString(4, name);
			ps.setString(5, address);
			ps.setString(6, phone);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ListProductDAO dao = new ListProductDAO();
		List<Product> list = dao.getAllProduct();
		for (Product o : list) {
			System.out.println(o);
		}
	}
}


