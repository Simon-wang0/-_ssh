<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>

	<table border="1">
		<tr>
			<td>
				商品名
			</td>
			<td>
				所属人
			</td>
			<td>
				商品类型
			</td>
			<td>
				价格
			</td>
			<td>
				编辑
			</td>
		</tr>
		<c:forEach items="${productList}" var="b">
			<tr>
				<td>
					${b.name }
				</td>
				<td>
					${b.prokind }
				</td>
				<td>
					${b.exhost }
				</td>
				<td>
					${b.price }
				</td>
				<td>
					<a href="admin/productView.action?id=${b.id }">修改</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</div>