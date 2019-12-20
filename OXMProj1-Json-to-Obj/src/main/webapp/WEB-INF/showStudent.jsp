<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15-Nov-19
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<center>
	<h1 style="color: red; text-align: center">All Student Details</h1>
	<table width="40%" border="1" cellspacing="0">
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Standard</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${studentList.students}" var="student">
			<tr>
				<td><c:out value="${student.name}" /></td>
				<td><c:out value="${student.age}" /></td>

				<td><c:out value="${student.standard}" /></td>

				<td><c:out value="${student.address}" /></td>

			</tr>
		</c:forEach>
	</table>
</center>