<%@include file="/WEB-INF/jsp/include.jsp" %>

<html>
<body>
	<form:form modelAttribute="employee">
		<%--form:hidden path="id"/--%>
		<form:hidden path="name"/>
		
		<h3>Edit Employee (<c:out value="${employee.name}"/>)</h3>

		Pick companies: <br/>		
		<c:forEach items="${companies}" var="company">
			<input type="checkbox" name="companyIds" value="<c:out value="${company.id}"/>"
				<c:forEach items="${employee.companies}" var="row">
					<c:if test="${row.id == company.id}">
						checked
					</c:if>
				</c:forEach>
			/> <c:out value="${company.name}"/><br/>
		</c:forEach>
		
		<br/>
		
		Pick skills: <br/>		
		<c:forEach items="${skills}" var="skill">
			<input type="checkbox" name="skillIds" value="<c:out value="${skill.id}"/>"
				<c:forEach items="${employee.skills}" var="row">
					<c:if test="${row.id == skill.id}">
						checked
					</c:if>
				</c:forEach>
			/> <c:out value="${skill.description}"/><br/>
		</c:forEach>
		
		<hr/>
		
		<%-- Have to use a custom PropertyEditor with this!
		<c:forEach items="${companies}" var="company">
			<input type="checkbox" name="companies"
				<c:forEach items="${employee.companies}" var="row">
					<c:if test="${row.id == company.id}">
						checked
					</c:if>
				</c:forEach>
			/> <c:out value="${company.name}"/>
		</c:forEach>
		--%>
		<input type="submit" value="Update >>"/>		
	</form:form>
</body>
</html>