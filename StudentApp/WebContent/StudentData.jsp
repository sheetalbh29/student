<%@page import="java.sql.ResultSet"%>
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
<%	HttpSession session2=request.getSession(false);
if(session2!=null){
String name=(String)session.getAttribute("name");
DaoClass dao=new DaoClass();
ResultSet rs=dao.showData(name);
while(rs.next()){
	%>
	<tr>
	<td><h5>Id: <%=rs.getInt(1)%></h1></td>
	<td><h5>Name : <%=rs.getString(2)%></h1></td>
	<td><h5>Age: <%=rs.getInt(3)%></h1></td>
	<td><h5>Subject: <%=rs.getString(4)%></h1></td>
	</tr>
	<% 
	}
}
else 
{
response.sendRedirect("Home.jsp");
}
%>
<a href="Logout">LOGOUT</a>
</body>
</html>