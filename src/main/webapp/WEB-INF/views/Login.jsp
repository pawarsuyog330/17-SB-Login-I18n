<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<br>
<br>
<c:if test="${message ne null }">

	<font color='red'> Reason : <c:out value="${message}" />
	</font>

</c:if>
<hr>

<h3>
	Select Your Preferred Language : <a href="login?param=en">English</a>
	|| <a href="login?param=hi">Hindi</a> || <a href="login?param=mr">Marathi</a>
</h3>

<form:form action="signin" method="post" modelAttribute="loginRequest">
	<table>
		<tr>
			<td><spring:message code="label.username" /></td>
			<td><form:input path="username" /></td>
			<td><font color='red'> <form:errors path="username">
						<spring:message code="NotEmpty.loginRequest.username" />
					</form:errors>
			</font></td>
		</tr>
		<tr>
			<td><spring:message code="label.password" /></td>
			<td><form:password path="password" /></td>
			<td><font color='red'> <form:errors path="password">
						<spring:message code="NotEmpty.loginRequest.password" />
						<spring:message code="Pattern.loginRequest.password" />
					</form:errors>
			</font></td>
		</tr>
	</table>
	<input type="submit" value='<spring:message code="label.submit"/>'>
	<input type="reset" value='<spring:message code="label.reset"/>'>
</form:form>