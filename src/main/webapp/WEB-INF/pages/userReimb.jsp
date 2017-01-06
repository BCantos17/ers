<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="main">
	<div class="row placeholders">  </div>
	<h2 class="sub-header">Reimbursement Requests</h2>
		<div class="table-responsive">
		<select class="btn-primary btn-lg" id="filter" onchange="doUserFilter()">
			<option selected="selected" value="0"> Filter By All</option>
			<option>Pending</option>
			<option>Approved</option>
			<option>Denied</option>
		</select>
			<table id="user-reimb-table" class="table table-bordered table-hover reimbTable">
				<thead class="thead-inverse">
					<tr>
						<th>Status</th>
						<th>Author</th>
						<th>Amount</th>
						<th>Description</th>
						<th>Type</th>
						<th>Submitted</th>
						<th>Resolved</th>
						<th>Resolver</th>
					</tr>
				</thead>
				<tbody id="reimb-body">
				<c:forEach var="temp" items="${reimbData}">
					<c:if test="${temp.author.id == userData.id}">
						<tr>
							<td>
							<div id="status" >
								<c:choose>
									<c:when test="${temp.statusId == 1}"> 	<p>Pending</p> </c:when>
									<c:when test="${temp.statusId == 2}"> 	<p>Approved</p> </c:when>
									<c:otherwise> 							<p>Denied</p> </c:otherwise>
								</c:choose>
							</div>
							</td>
							<td> <c:out value="${temp.author.fullName}" /> </td>
							<td> <fmt:formatNumber type="currency" value="${temp.amount}" /> </td>
							<td> <c:out value="${temp.descript}" /> </td>
							<td>
							<c:choose>
								<c:when test="${temp.typeId == 1}"> Lodging </c:when>
								<c:when test="${temp.typeId == 2}"> Travel </c:when>
								<c:when test="${temp.typeId == 3}"> Food </c:when>
								<c:otherwise> Other </c:otherwise>
							</c:choose>
							</td>
							<td> <fmt:formatDate type="date" value="${temp.submitted}" /> </td>
							<td> <fmt:formatDate type="date"  value="${temp.resolved}" /> </td>
							<td> 
							<c:choose>
								<c:when test="${temp.resolver.id == 0}"> </c:when>
								<c:otherwise> <c:out value="${temp.resolver.fullName}" /> </c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:if>
				</c:forEach>
				</tbody>
		</table>
	</div>
</div>