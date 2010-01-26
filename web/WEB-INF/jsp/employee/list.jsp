<%@include file="/WEB-INF/jsp/include.jsp" %>

<html>
<body>
	<h3>Employees</h3>
	<c:forEach items="${employees}" var="employee">
		<a href="/kbase/employee/edit.do?id=<c:out value="${employee.id}"/>"><c:out value="${employee.id}"/></a><c:out value="${employee.name}"/><br/>
	</c:forEach>
</body>
</html>