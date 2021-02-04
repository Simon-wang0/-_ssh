<%@ page language="java" pageEncoding="UTF-8"%>
<div>
  <%@ include file="../inc/msg.jsp"%>
  <form class="cmxform" method="post" action="common/changePasswd">
    <fieldset>
      <legend>
   更改密码
      </legend>
     <p>
        <label for="id-oldPasswd">
          原密码：
        </label>
        <input type="password" id="id-oldPasswd" name="oldPasswd" />
      </p>
      <p>
        <label for="id-passwd">
          密码：
        </label>
        <input type="password" id="id-passwd" name="passwd" />
      </p>
      <p>
        <label for="id-confirm">
          确认密码：
        </label>
        <input type="password" id="id-confirm" name="confirm" />
      </p>
       
      <input type="submit" value="更改密码">
    </fieldset>
  </form>
</div>
