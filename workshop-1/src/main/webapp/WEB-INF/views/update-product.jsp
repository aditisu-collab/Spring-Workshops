<%@page import = "org.hibernate.internal.build.AllowSysOut" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import = "com.example.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Product p = (Product)request.getAttribute("product");
	out.print(p);%>
	
	<form method="get" action="/update">
		Product ID: <input type="number" name="id" value=<%=p.getId() %>/><br>
		Product Name: <input type="text" name="name" value=<%=p.getName() %>/>
		<button type="submit">Add</button>
	</form>
	
</body>
</html>