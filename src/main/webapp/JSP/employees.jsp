<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.caseytoews.webapp.employee.domain.Employee"%>

<div class="section-box">
	<h3 class="header">Employee List</h3>
	<table class="left-table">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>DOB</th>
		</tr>

		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.ID}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>			
			<td><fmt:formatDate value="${emp.dob}" pattern="yyyy/MM/dd" /></td>
			</tr>
		</c:forEach>
	</table>
</div>