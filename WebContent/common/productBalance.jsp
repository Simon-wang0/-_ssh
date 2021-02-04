<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<div style="color: red">
		购买商品总量：${totAmount} 总金额：${totTotal}
	</div>
	<br />
	订单详细列表：
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

			</tr>
		</c:forEach>
	</table>
	<br />
	<form class="cmxform" method="post" action="common/orderGenerate.action">
		<fieldset>
			<legend>
				订单信息
			</legend>
			<p>
				<label for='postAddress'>
					邮寄地址：
				</label>
				<input type='text' value='' name='postAddress' id='postAddress' />
			</p>
			<p>
				<label for="postcard">
					邮编：
				</label>
				<input type="text" id="postcard" name="postcard" />
			</p>
			<p>
				<label for='telephone'>
					联系电话：
				</label>
				<input type='text' value='' name='telephone' id='telephone' />
			</p>
			<p>
				<label for="contact">
					联系人：
				</label>
				<input type="text" id="contact" name="contact" />
			</p>
			<input type="hidden" name="amount" value="${totAmount}">
			<input type="hidden" name="total" value="${totTotal}">
			<input type="submit" class="submit" value="生成订单">
		</fieldset>
	</form>
</div>