<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<form class="cmxform" method="post" action="common/orderUpdate.action">
		<fieldset>
			<legend>
				订单详细信息
			</legend>
			<input type="hidden" name="id" value="${orderView.id}"/>
			<input type="hidden" name="userid" value="${orderView.userid}"/>
			<p>
				<label for="onDate">
					下单日期
				</label>
				<input type="text" id="onDate" name="onDate" readonly value="${orderView.onDate }" />
			</p>
			<p>
				<label for="amount">
					购买商品总数
				</label>
				<input type="text" id="amount" name="amount" readonly value="${orderView.amount}" />
			</p>
			<p>
				<label for="total">
					总金额
				</label>
				<input type="text" id="total" name="total" readonly value="${orderView.total}" />
			</p>
			<p>
				<label for="postAddress">
					邮寄地址
				</label>
				<input type="text" id="postAddress" name="postAddress" value="${orderView.postAddress}" /><font color="red"/>${ isupdate eq 'yes'?"* 此属性可编辑":""}</font>
			</p>
			<p>
				<label for="postcard">
					邮编
				</label>
				<input type="text" id="postcard" name="postcard" value="${orderView.postcard}" /><font color="red"/>${ isupdate eq 'yes'?"* 此属性可编辑":""}</font>
			</p>
			<p>
				<label for="telephone">
					联系电话
				</label>
				<input type="text" id="telephone" name="telephone" value="${orderView.telephone}" /><font color="red"/>${ isupdate eq 'yes'?"* 此属性可编辑":""}</font>
			</p>
			<p>
				<label for="contact">
					联系人
				</label>
				<input type="text" id="contact" name="contact" value="${orderView.contact}" /><font color="red"/>${ isupdate eq 'yes'?"* 此属性可编辑":""}</font>
			</p>
			<p>
				<label for="state">
					订单状态
				</label>
				<input type="text" id="stateview" name="stateview" readonly value="${orderView.state eq 1? '初始':'已提交'}" />
				<input type="hidden" id="state" name="state" readonly value="${orderView.state}" />
			</p>	
			<c:if test="${ isupdate eq 'yes'}">
				<input type="submit" value="修改订单"/>	
			</c:if>	
			
		</fieldset>
	</form>
	
	<p>详细列表</p>
	
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
		<c:forEach items="${orderProducts}" var="o">
			<tr>
				<td>
					${o.product.name }
				</td>
				<td>
					${o.price }
				</td>
				<td>
					${o.amount }
				</td>
			</tr>
		</c:forEach >
	</table>
	
</div>