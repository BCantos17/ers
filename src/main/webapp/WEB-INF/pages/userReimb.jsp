<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <form action="reimbursement.do" method="post">
<jsp:param value="${reimbData}" name="addReimb"/>
</form> --%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="row placeholders">  </div>

	<h2 class="sub-header">Reimbursement Requests</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Amount</th>
						<th>Submitted</th>
						<th>Resolved</th>
						<th>Description</th>
						<th>Author</th>
						<th>Resolver</th>
						<th>Status</th>
						<th>Type</th>
					</tr>
				</thead>
			<c:choose>
				<c:when test="${reimbData.isEmpty()}">
					<tbody>
					<c:forEach var="temp" items="${reimbData}">
						<c:if test="${temp.author.id == userData.id}">
							<tr>
								<td> <c:out value="${temp.id}" /> </td>
				                <td> <fmt:formatNumber type="currency" value="${temp.amount}" /> </td>
				                <td> <fmt:formatDate type="date" value="${temp.submitted}" /> </td>
				                <td> <fmt:formatDate type="date"  value="${temp.resolved}" /> </td>
				                <td> <c:out value="${temp.descript}" /> </td>
				                <td> <c:out value="${temp.author.fullName}" /> </td>
				                <td> 
					                <c:choose>
					                	<c:when test="${temp.resolver.id == 0}"> Empty </c:when>
					                	<c:otherwise> <c:out value="${temp.resolver.fullName}" /> </c:otherwise>
					                </c:choose>
				                </td>
				                <td>
				                <c:choose>
								    <c:when test="${temp.statusId == 1}"> Pending </c:when>
								    <c:when test="${temp.statusId == 2}"> Approved </c:when>
								    <c:otherwise> Denied </c:otherwise>
								</c:choose>
								</td>
								<td>
								<c:choose>
								    <c:when test="${temp.typeId == 1}"> Lodging </c:when>
								    <c:when test="${temp.typeId == 2}"> Travel </c:when>
								    <c:when test="${temp.typeId == 3}"> Food </c:when>
								    <c:otherwise> Other </c:otherwise>
								</c:choose>
								</td>
							</tr>
						</c:if>
					</c:forEach>
					</tbody>
				</c:when>
				<c:otherwise>
					<tr>
						<td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
				        <td> Empty </td>
						<td> Empty </td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>