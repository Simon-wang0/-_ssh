<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu">
	<div style="padding: 5px;">
		<c:if test="${not empty currentUser}">
      欢迎您，${currentUser.name }
     </c:if>
	</div>
	<ul>
		<c:if test="${empty currentUser}">
			<li>
				<a href="reg.jsp">注册</a>
			</li>
			<li>
				<a href="login.jsp">登录</a>
			</li>
		</c:if>
		<c:if test="${not empty currentUser}">
			<li>
				<a href="common/userEdit.jsp">个人信息</a>
			</li>
			<li>
				<a href="common/passwd.jsp">更改密码</a>
			</li>
			<li>
				<a href="logout.action">安全退出</a>
			</li>
		</c:if>
		<c:if test="${not empty currentUser and currentUser.admin}">
			<li>
				<a href="admin/productList.action">查看商品</a>
			</li>
			<li>
				<a href="admin/productAdd.jsp">添加商品</a>
			</li>
			<li>
				<a href="admin/storageList.action">查看库存</a>
			</li>
			<li>
				<a href="admin/storageAdd.action">商品入库</a>
			</li>
		</c:if>
		<c:if test="${not empty currentUser and not currentUser.admin}">
			<li>
				<a href="common/productList.action">浏览商品</a>
			</li>
			<li>
				<a href="common/cartView.action">查看购物车</a>
			</li>
			<li>
				<a href="common/orderList.action">我的订单</a>
			</li>
		</c:if>
	</ul>
</div>