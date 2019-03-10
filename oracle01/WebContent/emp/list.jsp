<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.Date" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "emp.EmpDTO" %>
<%@ page import = "emp.EmpDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method = "post">
	직급 : <input type="text" name="job">
			<input type="submit" value="확인">
	</form>
	<table border ="1">
	<tr>
		<th>사번</td>
		<th>이름</td>
		<th>직급</td>
		<th>입사일자</td>
		<th>급여</td>
	</tr>
	<%
	EmpDAO dao = new EmpDAO();	// dao 인스턴스 생성
	ArrayList<EmpDTO> items = dao.listEmp();	// 사원 목록을 리스트로 받음. dao listEmp 메소드 실행
	for(int i = 0; i<items.size();i++){	// 리스트 갯수만큼 반복 처리
		EmpDTO dto = items.get(i);	// i번째 레코드를 dto에 저장
	%>
	<tr>
		<td><%= dto.getEmpno() %></td>
		<td><%= dto.getEname() %></td>
		<td><%= dto.getJob() %></td>
		<td><%= dto.getHiredate() %></td>
		<td><%= dto.getSal() %></td>
	</tr>
	<%
	}
	%>
	</table>
</body>
</html>