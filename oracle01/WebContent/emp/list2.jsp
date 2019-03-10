<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "emp_Re.EmpVO" %>
<%@ page import = "emp_Re.EmpDAO" %>
<%@ page import = "java.util.ArrayList" %>
<!-- 
	1. page import를 통해 EmpVO를 불러온다. 패키지명.클래스명
	2. page import를 통해 EmpDAO를 불러온다. 패키지명.클래스명
	3. page import를 통해 ArrayList도 불러온다.
	4. 스크립틀릿에 EmpDAO 인스턴스 객체를 생성
	5. ArrayList<EmpVO> items에 dao.listEmp() 메서드를 실행해 결과값을 담는다.
	6. EmpVO 인스턴스 객체를 생성한다 (vo)
	7. for문으로 items size만큼 반복
	8. vo에 items i번째 데이터를 넣는다.
	9. td에 vo에 담긴 데이터를 한줄씩 넣는다. vo.getEmpno();
	10. for문을 종료한다.
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직급</th>
		</tr>
		<%
			EmpDAO dao = new EmpDAO();
			ArrayList<EmpVO> items = dao.listEmp();
			EmpVO vo = new EmpVO();
			for(int i=0;i<items.size();i++){
				vo = items.get(i);
		%>
		<tr>
			<td><%= vo.getEmpno() %></td>
			<td><%= vo.getEname() %></td>
			<td><%= vo.getJob() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>