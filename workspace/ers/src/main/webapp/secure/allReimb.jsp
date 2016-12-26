<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="main">
	<div class="row placeholders">  </div>
	
	<h2 class="sub-header">Reimbursement Requests</h2>
		<div class="table-responsive">
		<select class="btn-primary btn-lg " id="filter" onchange="doAdminFilter()">
			<option selected="selected" value="0" > Filter By All</option>
			<option value="1" > Pending </option>
			<option value="2" > Approve </option>
			<option value="3" > Deny </option>
		</select>
		<table class="table table-bordered table-hover reimbTable" id="reimb-table">
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
					<th>#</th>
				</tr>
			</thead>
			<tbody id="reimb-body">
			<c:forEach var="temp" items="${reimbData}" varStatus="loop">
				<tr id="reimb-row">
					<td >
					<div class="dropdown parent">
						<c:choose>
						<c:when test="${temp.statusId == 1}">
							<select class="btn btn-warning status" id="status" name="${temp.id}" >
								<option value="1"> Pending </option>
								<option value="2"> Approve </option>
								<option value="3"> Deny </option>
							</select>
						</c:when>
						<c:otherwise>
						<button class="btn btn-success" disabled id="status" value="${temp.statusId}">
								<c:if test="${temp.statusId == 2}"> Approved</c:if>
								<c:if test="${temp.statusId == 3}"> Denied  </c:if>
						</button>
						</c:otherwise>
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
					<td id="resolved"> <fmt:formatDate type="date"  value="${temp.resolved}" /> </td>
					<td id="resolver"> 
					<c:choose>
						<c:when test="${temp.resolver.id == 0}"> </c:when>
						<c:otherwise> <c:out value="${temp.resolver.fullName}" /> </c:otherwise>
					</c:choose>
					</td>
					<td id="id"> <c:out value="${temp.id}" /> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>