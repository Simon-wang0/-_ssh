<%@ page language="java" pageEncoding="UTF-8"%>
<div>
  <form class="cmxform" method="get" action="login.action">
    <fieldset>
      <legend>
        登录
      </legend>
      <p>
        <label for='name'>
          登录名：
        </label>
        <input type='text' value='' name='name' id='name' />
      </p>
      <p>
        <label for="id-passwd">
          登录密码：
        </label>
        <input type="password" id="id-passwd" name="passwd" />
      </p>
      <p>
        <label>
          作为管理员
        </label>
        <label>
          <input type="checkbox" name="role" value="admin" />
        </label>
      </p>
      <input type="submit" class="submit" value="登录">
    </fieldset>
  </form>
</div>
