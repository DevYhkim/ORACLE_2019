package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB2 {
	// getConn메서드는 오라클 Connection를 가져오기 위한것
	public static Connection getConn() {
		Connection conn = null;	// Connection > 특정 데이터베이스와의 연결을 나타내는 객체
		
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";
		
		try {
			/* JDBC란? 자바에서 데이터베이스에 일관된 방식으로 접근할 수 있도록 제공하는 API */
			Class.forName("oracle.jdbc.driver.OracleDriver");	// JDBC 드라이버
			/*
			 DriverManager > JDBC 드라이버를 관리하기 위한 기본적인 클래스.
			 데이터베이스 드라이버를 선택하고 새로운 데이터베이스 연결을 생성하는 기능.
			 1) ORACLE 드라이버 - oracle.jdbc.driver.OracleDriver
			    URL형식 - jdbc:oracle:thin:@서버주소:포트번호:SID
			    
			 2) MySQL드라이버 - com.mysql.jdbc.Driver, MariaDB - org.mariadb.jdbc.Driver
			    URL형식 - jdbc:mysql://서버주소:포트번호/데이터베이스명
			              jdbc:mariadb://서버주소:포트번호/데이터베이스명
			 */
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
