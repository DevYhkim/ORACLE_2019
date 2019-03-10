package common_Re;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	/*
	1. 연결을 위한 Conn을 얻기 위해 Connection 을 리턴하는 getConn을 생성
	2. Server > Context에 추가한 Resource를 가져오기 위한 DataSource 를 생성
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
