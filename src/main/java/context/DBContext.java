package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://"+serverName+" : " + portNumber + "\\" + instance + ";databaseName="+dbName;
		if(instance==null || instance.trim().isEmpty())
			url="jdbc:sqlserver://"+serverName+":"+portNumber + ";databaseName=" + dbName;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, userID, password);
	}
	
	private final String serverName = "DESKTOP-7N0EAFQ";
	private final String dbName = "ShoppingDB";
	private final String portNumber="1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password="123456@";
	
	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
