package common_Re;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	/*
	1. ������ ���� Conn�� ��� ���� Connection �� �����ϴ� getConn�� ����
	2. Server > Context�� �߰��� Resource�� �������� ���� DataSource �� ����
	3. 
	*/
	public static Connection getConn() {
		Connection conn = null;
		DataSource ds = null;
		
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
