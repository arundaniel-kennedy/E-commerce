<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>Register</title>
<style type="text/css">
.formAlign
{
   width: 50%;
   position: relative;
   top: 20%;
   left:25%;
}

.background
{
   height: 800px;
   background-image: url("resources/images/book11.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
</style>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="background">
<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h3 class="title">Registration</h3>
	               		<hr />
	               	</div>
	            </div> 
	            <div class="formAlign">
				<div class="main-login main-center">
				<form:form id="registerForm" class="form-horizontal" method="post" action="success" >	
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="Name" placeholder="Enter your Name"/>
								</div>
							</div>
						</div>
						<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="EmailId"  placeholder="Enter your Email" onchange="email_validate(this.value);">
								</div>
								<div class="status" id="status"></div>
							</div>
						</div>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('email')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username" required >
								</div>
							</div>
						</div>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('username')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="Password" placeholder="Enter your Password" required data-toggle="popover" title="Password Strength" data-content="Enter Password....">
								</div>
							</div>
						</div>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Phone Number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-phone" aria-hidden="true"></i></span>
									<input id="phone" class="form-control" type="text" name="phone" placeholder="Phone Number" required maxlength="15" onkeyup="validatephone(this);"> 
								</div>
							</div>
						</div>
<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('phone')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach>
						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						
					</form:form>
				</div>
			</div>
			</div>
	</div>
	</div>
  			
<%@ include file="Footer.jsp" %>

</body>
</html>