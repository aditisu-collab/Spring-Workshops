<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.List" %>
    <%@page import = "com.example.Product" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<a href=" <%=request.getContextPath() %>/viewAdd">Add Product !</a>
	<table>
		<tr>
			<th>Serial No. : </th><br>
			<th>Product Name : </th>
			<th>Function : </th>
			<th>Function : </th>
		</tr>
		
		<% if(request.getAttribute("products")!=null){
			List<Product> product =
			(List<Product>)request.getAttribute("products");
			for(Product p: product){
				out.print("<tr>");
				out.print("<td>"+p.getId()+"</td>");
				out.print("<td>"+p.getName()+"</td>");
				out.print("<td><a href = '/delete/"+p.getId()+"'>Delete</a></td>");
				out.print("<td><a href = '/viewUpdate/"+p.getId()+"'>Update</a></td>");
				out.print("<tr>");
			}
		}
		%>
	</table>
</body>
</html>