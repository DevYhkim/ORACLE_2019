package emp_Re;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common_Re.DB2;

public class EmpDAO {
	/*
	 1. DB�� ��ȸ�ϱ� ���� �޼��� ���� ���� Ÿ���� ArrayList.
	 2. [������List] �����͸� �޾ƿ� ���� ArrayList�� �����Ѵ�. ������ ���� EmpVO ����.
	 3. [DB������ ���� Connection] DB ������ ���� Connection �� �߰��Ѵ�.
	 4. [�������� ������ PreparedStatement] �������� �����ϱ� ���� PreparedStatement ����
	 5. [��ȸ���� ���� ResultSet] ResultSet�� ���� �������� ������ ���ƿ��� ��ȸ���� ��� �׸��� �غ�
	 6. �غ�. ���� �������� �ڵ�. try catch
	 7. DB2�� getConn �޼���� conn�� ���´�.
	 8. String ���� ������ ���� �غ�
	 9. pstmt ������ �������� conn.prepareStatement�� �������� �����ϵ��� ���
	 10. ResultSet�� pstmt.executeQuery �޼���� �غ��� �������� ������ ��´�.
	 11. while(rs.Next)�� ResultSet�� ����� ������ �ݺ��Ѵ�.
	 12. EmpVO�� vo �ν��Ͻ� ��ü�� ����
	 13. vo�� �����͸� ��´�(set). rs���� getInt("empno")�� �����´�.
	 14. ��� ������� iteams�� vo�� add�Ѵ�.
	 */
	public ArrayList<EmpVO> listEmp(){
		ArrayList<EmpVO> items = new ArrayList<EmpVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;	// �������� �����ϱ� ���� Ŭ����
		ResultSet rs = null;	// SELECT ���� ��ȸ �������� ������ �� ���ƿ��� ��ȸ ���� ��� �׸�

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
