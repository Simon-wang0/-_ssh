<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table border="1">
		<tr>
			<td>
				商品
			</td>
			<td>
				库存
			</td>
			<td>
				入库时间
			</td>
		</tr>
		<c:forEach items="${storageList }" var="s">
			<tr>
				<td>
					${s.product.name }
				</td>
				<td>
					${s.amount }
				</td>
				<td>
					${s.inDate }
				</td>
			</tr>
		</c:forEach>

	</table>
</div>