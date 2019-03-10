package emp;
// 백그라운드에서 비즈니스 로직을 담당

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common_Re.DB2;

public class EmpDAO {
	public ArrayList<EmpDTO> listEmp(){
		ArrayList<EmpDTO> items = new ArrayList<EmpDTO>();
		// insert, update, delete 할때는 두개만 있어도 된다.
		Connection conn = null;
		// select 목록 가져오기 위한 것
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;	// 레코드를 담는 그릇. 커서가 존재해 while(rs.next)로 이동한다.
		
		try {
			conn = DB2.getConn(); //  DB접속(DB클래스) context.xml maxTotal 50개중 한개가 넘어옴
			String sql = "select * from emp order by hiredate, sal desc";
			pstmt = conn.prepareStatement(sql);	// sql 실행 객체 생성
			rs=pstmt.executeQuery();	// sql 실행, 결과셋이 rs에 리턴함
			while(rs.next()) {	// 다음 레코드가 존재할 동안 반복 실행
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setJob(rs.getString("job"));
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// finally 가 없으면 누수 현상이 일어남. 실행 역순으로 닫기
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
}
