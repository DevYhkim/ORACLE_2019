package common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	// getConn메서드는 오라클 Connection를 가져오기 위한것
	public static Connection getConn() {
		DataSource ds = null;
		Connection conn = null;	// Connection > 특정 데이터베이스와의 연결을 나타내는 객체
		
		try {
			
			/* Context DB정보
		     <Resource auth="Container" 
	          name="jdbc/OracleDB" 
	          driverClassName="oracle.jdbc.driver.OracleDriver" 
	          type="javax.sql.DataSource" 
	          url="jdbc:oracle:thin:@localhost:1521:ORCL" 
	          username="scott"
	          password="tiger" 
	          maxTotal = "50" 
	          loginTimeout="10" 
	          maxActive="50" 
	          maxIdle="20"
	          maxWait="5000" 
	          testOnBorrow="true" />
			 */
			
			// Context.xml 파일의 정보 분석. DB정보는 Server > Context에 선언함
			// InitialContext는 웹어플리케이션이 처음으로 배치될 때 설정되고 모든 설정된 엔트리와
			// 자원은 JNDI namespace의 java:comp/env 부분에 놓임.
			Context context = new InitialContext();	// 이름으로 Context에서 찾는다.
			// 여기가 java:comp/env/a면 Server > Context 리소스 이름도 a
			ds=(DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			/*
			 DriverManager > JDBC 드라이버를 관리하기 위한 기본적인 클래스.
			 데이터베이스 드라이버를 선택하고 새로운 데이터베이스 연결을 생성하는 기능.
			 1) ORACLE 드라이버 - oracle.jdbc.driver.OracleDriver
			    URL형식 - jdbc:oracle:thin:@서버주소:포트번호:SID
			    
			 2) MySQL드라이버 - com.mysql.jdbc.Driver, MariaDB - org.mariadb.jdbc.Driver
			    URL형식 - jdbc:mysql://서버주소:포트번호/데이터베이스명
			              jdbc:mariadb://서버주소:포트번호/데이터베이스명
			 */
			conn = ds.getConnection();
			// 이곳에선 conn을 close()  하면 안된다. 그럼 리턴이 안됨. 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
