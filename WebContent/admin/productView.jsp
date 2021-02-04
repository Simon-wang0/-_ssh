<%@ page language="java" pageEncoding="UTF-8"%>
<div>
	<form class="cmxform" method="post" action="admin/productUpdate.action">
		<fieldset>
			<legend>
				修改商品信息
			</legend>
			<input type="hidden" name="id" value="${product.id }">

			<p>
				<label for="id-name">
					商品名
				</label>
				<input type="text" id="id-name" name="name" readonly
					value="${product.name }" />
			</p>
			<p>
				<label for="id-prokind">
					商品种类
				</label>
				<input type="text" id="id-prokind" name="prokind"
					value="${product.prokind }" />
			</p>
			<p>
				<label for="id-exhost">
					所属人
				</label>
				<input type="text" id="id-exhost" name="exhost"
					value="${product.exhost }" />
			</p>
			<p>
				<label for="id-price">
					价格
				</label>
				<input type="text" id="id-price" name="price" value="${product.price }" />
			</p>
			<input type="submit" class="submit" value="更新">
		</fieldset>
	</form>
</div>