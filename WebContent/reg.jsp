<%@ page language="java" pageEncoding="UTF-8"%>
<div>
	<form class="cmxform" method="post" action="reg.action" name="f1">
		<fieldset>
			<legend>
				用户注册
			</legend>
			<p>
				<label for="id-name">
					用户名：
				</label>
				<input type="text" id="id-name" name="name" value='${user.name}' />
			</p>
			<p>
				<label for="id-passwd">
					密码：
				</label>
				<input type="password" id="id-passwd" name="passwd" />
			</p>
			<p>
				<label for="id-conifrm">
					确认密码：
				</label>
				<input type="password" id="id-conifrm" name="conifrm" />
			</p>
			<p>
				<label>
					性别：
				</label>
				<label>
					<input type="radio" name="sex" value="m" checked />
					男
				</label>
				<label>
					<input type="radio" name="sex" value="f" />
					女
				</label>
			</p>
			<p>
				<label for="id-age">
					年龄：
				</label>
				<input type="text" id="id-age" name="age" value='${user.age }' />
			</p>
			<p>
				<label for="id-address">
					地址：
				</label>
				<input type="text" id="id-address" name="address"
					value='${user.address }' />
			</p>
			<p>
				<label for="id-postcode">
					邮编:
				</label>
				<input type="text" id="id-postcode" name="postcode"
					value='${user.postcode }' />
			</p>
			<p>
				<label for="id-phone">
					电话：
				</label>
				<input type="text" id="id-phone" name="phone" value='${user.phone }' />
			</p>
			<input type="submit" value="注册" onclick="return checkData();">
		</fieldset>
	</form>
</div>
<script type="text/javascript">
 function checkData(){
   var f1=document.f1;
   if(f1.name.value==""){
   alert("用户名不能为空");
   f1.name.focus();
   return false;
   }
   if(f1.passwd.value==""){
   alert("密码不能为空");
   f1.passwd.focus();
   return false;
   }
   if(f1.passwd.value!=f1.conifrm.value){
   alert("密码不一致");
   f1.conifrm.focus();
   f1.conifrm.value="";
   return false;
   }
   if(isNaN(f1.age.value)){
   alert("年龄应该为数值");
   f1.age.focus();
   return false;
   }
   if(isNaN(f1.phone.value)){
   alert("电话应该为数值");
   f1.phone.focus();
   return false;
   }
   return true;
    }
</script>
