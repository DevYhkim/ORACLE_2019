package emp;
// ��׶��忡�� ����Ͻ� ������ ���

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common_Re.DB2;

public class EmpDAO {
	public ArrayList<EmpDTO> listEmp(){
		ArrayList<EmpDTO> items = new ArrayList<EmpDTO>();
		// insert, update, delete �Ҷ��� �ΰ��� �־ �ȴ�.
		Connection conn = null;
		// select ��� �������� ���� ��
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;	// ���ڵ带 ��� �׸�. Ŀ���� ������ while(rs.next)�� �̵��Ѵ�.
		
		try {
			conn = DB2.getConn(); //  DB����(DBŬ����) context.xml maxTotal 50���� �Ѱ��� �Ѿ��
			String sql = "select * from emp order by hiredate, sal desc";
			pstmt = conn.prepareStatement(sql);	// sql ���� ��ü ����
			rs=pstmt.executeQuery();	// sql ����, ������� rs�� ������
			while(rs.next()) {	// ���� ���ڵ尡 ������ ���� �ݺ� ����
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setJob(rs.getString("job"));
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// finally �� ������ ���� ������ �Ͼ. ���� �������� �ݱ�
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
