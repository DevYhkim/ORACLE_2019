package common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	// getConn�޼���� ����Ŭ Connection�� �������� ���Ѱ�
	public static Connection getConn() {
		DataSource ds = null;
		Connection conn = null;	// Connection > Ư�� �����ͺ��̽����� ������ ��Ÿ���� ��ü
		
		try {
			// Context.xml ������ ���� �м�. DB������ Server > Context�� ������
			Context context = new InitialContext();	// �̸����� Context���� ã�´�.
			// ���Ⱑ java:comp/env/a�� Server > Context ���ҽ� �̸��� a
			ds=(DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			/*
			 DriverManager > JDBC ����̹��� �����ϱ� ���� �⺻���� Ŭ����.
			 �����ͺ��̽� ����̹��� �����ϰ� ���ο� �����ͺ��̽� ������ �����ϴ� ���.
			 1) ORACLE ����̹� - oracle.jdbc.driver.OracleDriver
			    URL���� - jdbc:oracle:thin:@�����ּ�:��Ʈ��ȣ:SID
			    
			 2) MySQL����̹� - com.mysql.jdbc.Driver, MariaDB - org.mariadb.jdbc.Driver
			    URL���� - jdbc:mysql://�����ּ�:��Ʈ��ȣ/�����ͺ��̽���
			              jdbc:mariadb://�����ּ�:��Ʈ��ȣ/�����ͺ��̽���
			 */
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
