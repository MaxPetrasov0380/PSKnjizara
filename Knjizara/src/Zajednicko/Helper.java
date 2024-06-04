package Zajednicko;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.MysqlDataSource;


public class Helper {

	private static String servername = "localhost";
	private static String username = "root";
	private static String dbname = "knjizara";
	private static Integer portNumber = 3306;
	private static String password;
	
	public static Connection getConnection() {
		Connection conn = null;
		
		MysqlDataSource datasource = new MysqlDataSource();
		
		datasource.setServerName(servername);
		datasource.setUser(username);
		datasource.setPassword(password);
		datasource.setDatabaseName(dbname);
		datasource.setPortNumber(portNumber);
		
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			Logger.getLogger("Get connection => " + Helper.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public Object CenterWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		return null;
	}
}
