<%@page import="bean.DaoClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="student" class="bean.Student" scope="session" />
	<jsp:setProperty property="id" name="student" />
	<jsp:setProperty property="name" name="student" />
	<jsp:setProperty property="age" name="student" />
	<jsp:setProperty property="subject" name="student" />
	
<%	int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
String subject=request.getParameter("subject");
if(student.isValidAge()){
	DaoClass dao=new DaoClass();
	dao.registerStudent(id, name, age, subject);
	response.sendRedirect("StudentData.jsp");
}
	%>
</body>
</html>