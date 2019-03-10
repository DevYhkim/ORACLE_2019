package emp_Re;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common_Re.DB2;

public class EmpDAO {
	/*
	 1. DB를 조회하기 위한 메서드 생성 리턴 타입은 ArrayList.
	 2. [가져올List] 데이터를 받아와 담을 ArrayList를 생성한다. 생성해 놓은 EmpVO 구조.
	 3. [DB연결을 위한 Connection] DB 연결을 위해 Connection 을 추가한다.
	 4. [쿼리문을 실행할 PreparedStatement] 쿼리문을 실행하기 위한 PreparedStatement 생성
	 5. [조회값을 담을 ResultSet] ResultSet을 통해 쿼리문을 실행해 돌아오는 조회값을 담는 그릇을 준비
	 6. 준비끝. 이제 본격적인 코딩. try catch
	 7. DB2에 getConn 메서드로 conn을 얻어온다.
	 8. String 으로 실행할 쿼리 준비
	 9. pstmt 실행할 쿼리문을 conn.prepareStatement로 쿼리문을 실행하도록 담기
	 10. ResultSet에 pstmt.executeQuery 메서드로 준비한 쿼리문을 실행해 담는다.
	 11. while(rs.Next)로 ResultSet에 담겨진 내용을 반복한다.
	 12. EmpVO로 vo 인스턴스 객체를 생성
	 13. vo에 데이터를 담는다(set). rs에서 getInt("empno")로 가져온다.
	 14. 모두 담았으면 iteams에 vo를 add한다.
	 */
	public ArrayList<EmpVO> listEmp(){
		ArrayList<EmpVO> items = new ArrayList<EmpVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;	// 쿼리문을 실행하기 위한 클래스
		ResultSet rs = null;	// SELECT 등의 조회 쿼리문을 실행한 후 돌아오는 조회 값을 담는 그릇

		try {
			conn = DB2.getConn();
			String sql = "select * from emp order by hiredate, sal desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				items.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
