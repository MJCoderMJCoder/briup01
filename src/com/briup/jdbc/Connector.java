package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//��ݼ�"alt+/"������ʾ
//�����޸�Ctrl+1
//���������ƶ�alt+�����
//����ɾ��Ctrl+d
//���и���Ctrl+Alt+�����

public class Connector {
	public static void main(String[] args) {
		//1.ע������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("ע��ɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ע��ʧ��");
		}
		//2.��������
		Connection conn = null;
		String username = "liu";
		String password = "zhifeng";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
			//Э�����ͣ����ݿ����ͣ��������ͣ�ip��ַ���˿ںţ����ݿ���
		try {
			 conn = DriverManager.getConnection(url, username, password);
			System.out.println("���ӳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		//3.��ȡstatement
		Statement st = null;
		try {
			st = conn.createStatement();
			int id = 11;
			String name = "oracle";
			double price = 23.88;
			String sql = "insert into book values("+id+",'"+name+"', '"+price+"')";
			//st.execute(sql);
			//st.executeQuery(sql);//ִ��select
			st.executeUpdate(sql);//���¼���
			System.out.println("sql���ִ�гɹ�");
			conn.commit();
		} catch (Exception e) {
				try {
					conn.rollback();
					System.out.println("-----rollback�ɹ�");
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("-----rollback�쳣");
				}
			e.printStackTrace();
			System.out.println("sql���ִ���쳣");
		} finally {
			try {
				st.close();
				System.out.println("�Ѿ��ر�ִ�����");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�ִ�����ʧ��");
			}
			try {
				conn.close();
				System.out.println("�Ѿ��ر�����");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�����ʧ��");
			}
		}
		
	}

}
