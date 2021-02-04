<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty messages}">
	<div class="message">
		<ul>
			<c:forEach items="${messages}" var="m">
				<li>
					${m       }
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
<c:if test="${not empty errors}">
	<div class="errors">
		<ul>
			<c:forEach items="${requestScope.errors}" var="m">
				<li>
					${m }
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
