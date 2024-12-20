
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Product</title>
</head>
<body>
	
	<h1>Our Store Product</h1>
	<table border="1px solid black">
		<tr>
			<th>Product Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		
		<c:forEach items="${pageA}" var="productDetails">
			<tr>
				<td>${productDetails.productId}</td>
				<td>${productDetails.name}</td>
				<td>${productDetails.price}</td>
				<td>${productDetails.description}</td>
			
			</tr>
		
		</c:forEach>
	
	</table>
	<c:forEach begin="1" end="${maxP}" var="pageNumber">
		<a href="ListProductServlet?page=${pageNumber}">${pageNumber} </a>
	</c:forEach> 
	
	
	<!--  <table border="1px solid black">
		<tr>
			<th>Product Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		
		<c:forEach begin="1" end="4">
			<tr>
				<td>1</td>
				<td>Carrot</td>
				<td>12</td>
				<td>Carrots are a good source of several vitamins and minerals, especially biotin, potassium, and vitamins A (from beta carotene), K1 (phylloquinone)</td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	
	<c:forEach begin="1" end="5" var="i">
		<a href="#">${i} </a>
	</c:forEach>  -->
	
	

	

</body>
</html>