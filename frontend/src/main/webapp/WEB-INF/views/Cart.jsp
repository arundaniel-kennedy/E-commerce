<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Header.jsp"%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<style>
.edit{
  background: none;
  border: none;
  outline: none;
  color:#4169E1	;
}
</style>

</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="container-fluid">
	   <table class="table table-bordered">

 <h4><center> Your Cart</center></h4>


<tr>
  <td>ProductImage</td>
  <td>Quantity</td>
  <td>Subtotal</td>
  <td>Operation</td>
</tr>

<c:forEach items="${cartList}" var="cartItem">

 <form action="<c:url value="/updateCartItem/${cartItem.cartItemId }"/>" method="get">
 <tr> 
 <td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width="100" height="100"/></td>

 <td><input type="text" name="qty" value="${cartItem.quantity }"/></td>

 <td>${cartItem.subtotal}</td>
 <td>
    <button type="submit"class="edit">
          <span class="glyphicon glyphicon-edit"></span>
    </button>
    <a href="<c:url value= "/deleteCartItem/${cartItem.cartItemId }"/>" >
    <span class="glyphicon glyphicon-trash"/>
    </a>
 </td>
</tr>
</form>
</c:forEach>


<tr>
  
  <td colspan ="2">Grand Total</td>
  <td colspan= "2">Rs.${grandTotal}/-</td>

</tr>

<tr>
 
  <td colspan="4"><center><a href= "<c:url value="/ConfirmOrder"/>">ConfirmOrder</a></center></td>
</tr>  
</table>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>