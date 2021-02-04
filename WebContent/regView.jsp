<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	 
	<table border="1">
		<tr>
			<td>
				用户名：
			</td>
			<td>
				${user.name }
			</td>
		</tr>
		<tr>
			<td>
				年龄：
			</td>
			<td>
				${user.age }
			</td>
		</tr>
		<tr>
			<td>
				性别：
			</td>
			<td>
				<c:if test="${user.sex eq 'm'}">男</c:if>
				<c:if test="${user.sex eq 'f'}">女</c:if>
			</td>
		</tr>
		<tr>
			<td>
				地址
			</td>
			<td>
				${user.address }
			</td>
		</tr>
		<tr>
			<td>
				邮编
			</td>
			<td>
				${user.postcode }
			</td>
		</tr>
		<tr>
			<td>
				电话
			</td>
			<td>
				${user.phone }
			</td>
		</tr>

	</table>
	<a href="login.jsp">点击登录</a>
</div>