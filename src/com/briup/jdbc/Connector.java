package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//快捷键"alt+/"代码提示
//快速修复Ctrl+1
//整行上下移动alt+方向键
//整行删除Ctrl+d
//整行复制Ctrl+Alt+方向键

public class Connector {
	public static void main(String[] args) {
		//1.注册驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("注册成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("注册失败");
		}
		//2.建立连接
		Connection conn = null;
		String username = "liu";
		String password = "zhifeng";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
			//协议类型：数据库类型：驱动类型：ip地址：端口号：数据库名
		try {
			 conn = DriverManager.getConnection(url, username, password);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
		//3.获取statement
		Statement st = null;
		try {
			st = conn.createStatement();
			int id = 11;
			String name = "oracle";
			double price = 23.88;
			String sql = "insert into book values("+id+",'"+name+"', '"+price+"')";
			//st.execute(sql);
			//st.executeQuery(sql);//执行select
			st.executeUpdate(sql);//更新计数
			System.out.println("sql语句执行成功");
			conn.commit();
		} catch (Exception e) {
				try {
					conn.rollback();
					System.out.println("-----rollback成功");
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("-----rollback异常");
				}
			e.printStackTrace();
			System.out.println("sql语句执行异常");
		} finally {
			try {
				st.close();
				System.out.println("已经关闭执行语句");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭执行语句失败");
			}
			try {
				conn.close();
				System.out.println("已经关闭连接");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭连接失败");
			}
		}
		
	}

}
