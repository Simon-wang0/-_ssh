<%@ page language="java" pageEncoding="UTF-8"%>
<div>
  <%@ include file="../inc/msg.jsp"%>
  <form class="cmxform" method="post" action="common/userUpdate.action">
    <fieldset>
      <legend>
        用户注册
      </legend>
      <input type="hidden" name="id" value="${currentUser.id }">
      <p>
        <label for="id-name">
        xiu  用户名：
        </label>
        <input type="text" id="id-name" name="name" value='${currentUser.name}' readonly />
      </p>
      <p>
        <label>
          性别：
        </label>
        <label>
          <input type="radio" name="sex" value="m" <c:if test="${currentUser.sex eq 'm'}">checked</c:if> />
          男
        </label>
        <label>
          <input type="radio" name="sex" value="f" <c:if test="${currentUser.sex eq 'f'}">checked</c:if> />
          女
        </label>
      </p>
      <p>
        <label for="id-age">
          年龄：
        </label>
        <input type="text" id="id-age" name="age" value='${currentUser.age }' />
      </p>
      <p>
        <label for="id-address">
          地址：
        </label>
        <input type="text" id="id-address" name="address" value='${currentUser.address }' />
      </p>
      <p>
        <label for="id-postcode">
          邮编:
        </label>
        <input type="text" id="id-postcode" name="postcode" value='${currentUser.postcode }' />
      </p>
      <p>
        <label for="id-phone">
          电话：
        </label>
        <input type="text" id="id-phone" name="phone" value='${currentUser.phone }' />
      </p>
      <input type="submit" value="保存">
    </fieldset>
  </form>
</div>
