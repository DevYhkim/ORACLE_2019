package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB2 {
	// getConn�޼���� ����Ŭ Connection�� �������� ���Ѱ�
	public static Connection getConn() {
		Connection conn = null;	// Connection > Ư�� �����ͺ��̽����� ������ ��Ÿ���� ��ü
		
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			/* JDBC��? �ڹٿ��� �����ͺ��̽��� �ϰ��� ������� ������ �� �ֵ��� �����ϴ� API */
			Class.forName("oracle.jdbc.driver.OracleDriver");	// JDBC ����̹�
			/*
			 DriverManager > JDBC ����̹��� �����ϱ� ���� �⺻���� Ŭ����.
			 �����ͺ��̽� ����̹��� �����ϰ� ���ο� �����ͺ��̽� ������ �����ϴ� ���.
			 1) ORACLE ����̹� - oracle.jdbc.driver.OracleDriver
			    URL���� - jdbc:oracle:thin:@�����ּ�:��Ʈ��ȣ:SID
			    
			 2) MySQL����̹� - com.mysql.jdbc.Driver, MariaDB - org.mariadb.jdbc.Driver
			    URL���� - jdbc:mysql://�����ּ�:��Ʈ��ȣ/�����ͺ��̽���
			              jdbc:mariadb://�����ּ�:��Ʈ��ȣ/�����ͺ��̽���
			 */
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
