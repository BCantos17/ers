<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/sources/loginPageSources.jsp" %>
</head>
<body>
	<div>
		<form class="loginPage" action="login.do" method="post">

			<h2 class="loginPage-heading">Please Sign In</h2>
			<label for="inputUsername" class="sr-only">Username</label> 
			<input type="text" id="inputUsername" name="username" class="form-control" placeholder="Username" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="Password" name="password" class="form-control" placeholder="Password" required>
			<font color="red"><c:out value="${invalid}"/></font>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me" name="remember"> Remember me </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login in</button>
		</form>
	</div>
</body>
</html>