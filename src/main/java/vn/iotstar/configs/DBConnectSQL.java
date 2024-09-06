package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
	public static final String serverName = "MAY\\VYTRAN";
	public static String dbName = "LTWeb";
	public static String portNumber = "1433";
	public static String instance = "";
	public static String userID = "MAY";
	public static String password = "122003vy";
	
	//Kết nối SQL Server với SQL Authentication
		public Connection getConnection() throws Exception {
			String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
			if (instance == null || instance.trim().isEmpty())
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, userID, password);
		}


			 
			public static void main(String[] args) {
				try {
				System.out.println(new DBConnectSQL().getConnection());
				} catch (Exception e) { e.printStackTrace(); }
			
	    }
}

