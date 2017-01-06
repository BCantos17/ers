<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Welcome <c:out value="${userData.fullName }"/>!</a>
		<c:if test="${userData.roleId == 1}">
			<button id="update" class="btn btn-danger navbar-btn">Update Statues</button>
		</c:if>
		<c:if test="${userData.roleId == 2}">
			<button id="create-reimbursement" class="btn btn-danger navbar-btn" >Request Reimbursement</button>
		</c:if>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">
		<li>
			<form action="logout.do" method="post">
				<button class="btn btn-default navbar-btn">Log Out</button>
			</form>
		</li>
		</ul>
	</div>
</div>
