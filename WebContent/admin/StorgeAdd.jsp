<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>

	<form class="cmxform" method="post" action="admin/storageSave.action">
		<fieldset>
			<legend>
				商品上架
			</legend>
			<p>
				<label for="id-productId">
					选择商品
				</label>

				<select name="productId" id="id-productId">
					<c:forEach items="${productList}" var="b">
						<option value="${b.id }">
							${b.name }
						</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label for="id-mount">
					数量：
				</label>
				<input type="text" id="id-mount" name="amount" />
			</p>
			<p>
				<label for="id-inDate">
					上架日期
				</label>
				<input type="text" id="id-inDate" name="inDate"
					onclick="new Calendar(0).show(this)" readOnly />
			</p>
			<input type="submit" class="submit" value="保存">
		</fieldset>
	</form>
</div>