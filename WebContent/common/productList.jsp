<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="overflow: auto; height: 100%; position: relative;">
	<c:forEach items="${storages}" var="s">
		<div class="products-list">
			<table>
				<tr>
					<td>
						商品名
					</td>
					<td>
						${s.product.name }
					</td>
				</tr>
				<tr>
					<td>
						商品种类
					</td>
					<td>
						${s.product.prokind }
					</td>
				</tr>
				<tr>
					<td>
						所属人
					</td>
					<td>
						${s.product.exhost }
					</td>
				</tr>
				<tr>
					<td>
						价格
					</td>
					<td>
						${s.product.price }
					</td>
				</tr>
				<tr>
					<td>
						数量
					</td>

					<td>
						${s.amount }
					</td>
				</tr>
				<tr>
					<td>
						上架日期
					</td>
					<td>
						${s.inDate }
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="common/productView.action?id=${s.product.id }"
							style="text-decoration: none;"> 详细信息</a>
						<form action="common/productToCart.action" method="post">
							数量：
							<input type="text" style="width: 30px;" name="amount" value="1">
							<input type="submit" value="放到购物车">

							<input type="hidden" name="productName" value="${ s.product.name}">
							<input type="hidden" name="productId" value="${ s.product.id}">
						</form>
					</td>

				</tr>
			</table>
			<br />
		</div>
	</c:forEach>

</div>