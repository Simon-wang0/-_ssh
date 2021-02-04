<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<table width="100%">
		<tr align="center">
			<th width="11%">
				订单编号
			</th>
			<th width="18%">
				下单日期
			</th>
			<th width="11%">
				购买商品总数
			</th>
			<th width="15%">
				总金额
			</th>
			<th width="20%">
				订单状态
			</th>
			<th width="25%">
				操纵
			</th>
		</tr>
		<c:forEach items="${orderList}" var="order">
			<tr align="center">
				<td>
					${order.id }
				</td>
				<td>
					${order.onDate }
				</td>
				<td>
					${order.amount }
				</td>
				<td>
					${order.total }
				</td>
				<td align="left">
					${order.state eq 1? "初始":"已提交"}
					<c:if test="${order.state eq 1}">
						<a href="common/orderConfirm.action?id=${order.id}">提交订单</a>
					</c:if>
				</td>
				<td align="left">
					<a href="common/orderView.action?id=${order.id}">详细信息</a>&nbsp;&nbsp;
					<c:if test="${order.state eq 1}">
						<a href="common/orderView.action?id=${order.id}&isupdate=yes"
							onclick="return isModify();">修改</a>&nbsp;&nbsp;
					<a href="common/orderDelete.action?id=${order.id}"
							onclick="return isDelete();">删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<script type="text/javascript">
    function isDelete(){
          if(confirm("您确认要删除吗？"))
              {return true;}
          else
              {return false;}
        }
    function isModify(){
          if(confirm("您确认要修改吗？"))
              return true;
          else
              return false;
        }   
</script>