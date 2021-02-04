<%@ page language="java" pageEncoding="UTF-8"%>
<div>
	<form class="cmxform" method="post" action="admin/productAdd.action">
		<fieldset>
			<legend>
				添加商品
			</legend>


			<p>
				<label for="id-name">
					商品名
				</label>
				<input type="text" id="id-name" name="name" />
			</p>
			<p>
				<label for="id-prokind">
					商品种类
				</label>
				<input type="text" id="id-prokind" name="prokind" />
			</p>
			<p>
				<label for="id-exhost">
					所属人
				</label>
				<input type="text" id="id-exhost" name="exhost" />
			</p>
			<p>
				<label for="id-price">
					价格
				</label>
				<input type="text" id="id-price" name="price" />
			</p>
			<input type="submit" class="submit" value="保存">
		</fieldset>
	</form>
</div>