<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/create_reset.css">
<link rel="stylesheet" href="./css/orion.css">
<link rel="stylesheet" href="./css/error.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">

<title>宛先情報入力</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="contents" class="main-container">

  <div class="page-title">
  <h1>宛先情報入力画面</h1>
  </div>

  <s:if test="familyNameErrorList != null && familyNameErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="familyNameErrorList"><s:property /><br></s:iterator>

  </div>
  </s:if>

  <s:if test="firstNameErrorList != null && firstNameErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="firstNameErrorList"><s:property /><br></s:iterator>

  </div>
  </s:if>

  <s:if test="familyNameKanaErrorList != null && familyNameKanaErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="familyNameKanaErrorList"><s:property/><br></s:iterator>

  </div>
  </s:if>

  <s:if test="firstNameKanaErrorList != null && firstNameKanaErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="firstNameKanaErrorList"><s:property/><br></s:iterator>

  </div>
  </s:if>

  <s:if test="userAddressErrorList != null && userAddressErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="userAddressErrorList"><s:property/><br></s:iterator>

  </div>
  </s:if>

  <s:if test="telNumberErrorList != null && telNumberErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="telNumberErrorList"><s:property/><br></s:iterator>

  </div>
  </s:if>

  <s:if test="emailErrorList != null && emailErrorList.size() > 0">
  <div class="warning">

    <s:iterator value="emailErrorList"><s:property/><br></s:iterator>

  </div>
  </s:if>

<s:form action="CreateDestinationConfirmAction">

<table class="v">

<tr>
    <th scope="row"><s:label value="姓"/></th>
    <td><s:textfield name="familyName" value="%{#session.familyName}" placeholder="姓" size="35%"/></td>
</tr>

<tr>
    <th scope="row"><s:label value="名"/></th>
    <td><s:textfield name="firstName" value="%{#session.firstName}" placeholder="名" size="35%"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="姓ふりがな"/></th>
	<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがな" size="35%"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="名ふりがな"/></th>
	<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな" size="35%"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="住所"/></th>
	<td><s:textfield name="userAddress" value="%{#session.userAddress}" placeholder="住所" size="35%"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="電話番号"/></th>
	<td><s:textfield name="telNumber" value="%{#session.telNumber}" placeholder="電話番号" size="35%"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="メールアドレス"/></th>
	<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" size="35%"/></td>
</tr>

</table>

<div class="submit_btn_box">
<s:submit value="確認" class="submit_btn btn-field" />
</div>

</s:form>

</div>
</body>
</html>