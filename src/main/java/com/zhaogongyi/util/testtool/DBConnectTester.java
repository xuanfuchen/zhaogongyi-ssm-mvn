package com.zhaogongyi.util.testtool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectTester {
	public static void main(String[] args) {
		String url = "jdbc:jtds:sqlserver://PC-201303031236;databaseName=zhaogongyi_db";
		String driver = "net.sourceforge.jtds.jdbc.Driver";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, "sa", "123456");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
