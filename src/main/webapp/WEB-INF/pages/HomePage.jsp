<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/sources/homePageSources.jsp" %>
</head>
<body>
	<jsp:include page="addReimb.jsp"> </jsp:include>
  	<nav class="navbar navbar-inverse navbar-fixed-top">
		<jsp:include page="navbar.jsp"> </jsp:include>
	</nav>
	<div class="container-fluid">
		<div class="row">
	
		<%-- 	<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="sidebar.jsp"> </jsp:include>
			</div> --%>
			<c:if test="${userData.roleId == 1}">
					<jsp:include page="../../secure/allReimb.jsp"> 
						<jsp:param value="updateStatues" name="status"/>
					</jsp:include>
 			</c:if>
			
			<c:if test="${userData.roleId == 2}">
					<jsp:include page="userReimb.jsp"> 
						<jsp:param value="updateStatues" name="status"/>
					</jsp:include>
 			</c:if>
		</div>
	</div>
</body>
<script type="text/javascript" src="external.js"></script>
</html>