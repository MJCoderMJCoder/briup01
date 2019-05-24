package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String username  = "liu";
			String password = "zhifeng";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			String sql = "select * from book";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				System.out.println(id+"\t"+name+"\t"+price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			rs.close();
			st.close();
			conn.close();
			System.out.println("πÿ±’¡¨Ω”");
		}
	}

}
