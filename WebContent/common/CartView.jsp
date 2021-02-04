<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table border="1">
		<tr>
			<td>
				商品名
			</td>
			<td>
				价格
			</td>
			<td>
				数量
			</td>
			<td>
				操作
			</td>
		</tr>
		<c:forEach items="${shopcart.items}" var="c">
			<tr>
				<td>
					${c.value.product.name }
				</td>
				<td>
					${c.value.product.price }
				</td>
				<td>
					${c.value.amount }
				</td>
				<td>
					<a href="common/removeItem.action?itemId=${c.key }">移出购物车</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="common/productBalance.action">进入结算中心>></a>
</div>