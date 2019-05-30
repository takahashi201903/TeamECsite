<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/create_reset.css">
<link rel="stylesheet" href="./css/orion.css">
<link rel="stylesheet" href="./css/error.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">

<title>ユーザー情報入力</title>
</head>
<body>
<jsp:include page="header.jsp" />

<div id="contents" class="main-container">

    <div class="page-title">
		<h1>ユーザー情報入力画面</h1>
	</div>

	<s:if test="familyNameErrorMessageList != null && familyNameErrorMessageList.size() > 0">
	<div class="warning">

		<s:iterator value="familyNameErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="firstNameErrorMessageList != null && firstNameErrorMessageList.size() > 0">
	<div class="warning">

		<s:iterator value="firstNameErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="familyNameKanaErrorMessageList != null && familyNameKanaErrorMessageList.size() > 0">
	<div class="warning">

		<s:iterator value="familyNameKanaErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

		<s:if test="firstNameKanaErrorMessageList != null && firstNameKanaErrorMessageList.size() > 0">
	<div class="warning">

		<s:iterator value="firstNameKanaErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="emailErrorMessageList != null && emailErrorMessageList.size()> 0 ">
	<div class="warning">

		<s:iterator value="emailErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="userIdErrorMessageList != null && userIdErrorMessageList.size()> 0 ">
    <div class="warning">

		<s:iterator value="userIdErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="passwordErrorMessageList != null && passwordErrorMessageList.size() > 0">
	<div class="warning">

		<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:if test="checkUserIdInfoMessage != null && !checkUserIdInfoMessage.isEmpty()">
	<div class="warning">

		<s:iterator value="checkUserIdInfoMessage"><s:property /><br></s:iterator>

	</div>
	</s:if>

	<s:form action="CreateUserConfirmAction">

	<table class="v">
		<tr>
			<th scope="row">姓</th>
			<td><s:textfield name="familyName" value="%{#session.familyName}" placeholder="姓" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">名</th>
			<td><s:textfield name="firstName" value="%{#session.firstName}" placeholder="名" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">姓ふりがな</th>
			<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" placeholder="姓ふりがな" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">名ふりがな</th>
			<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" placeholder="名ふりがな" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">性別</th>
			<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" placeholder="性別"/></td>
		</tr>

		<tr>
			<th scope="row">メールアドレス</th>
			<td><s:textfield name="email" value="%{#session.email}" placeholder="メールアドレス" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">ユーザーID</th>
			<td><s:textfield name="userId" value="%{#session.userId}" placeholder="ユーザーID" size="35%"/></td>
		</tr>

		<tr>
			<th scope="row">パスワード</th>
			<td><s:password name="password" value="" placeholder="パスワード" size="35%"/></td>
		</tr>

	</table>

	<div class="submit_btn_box">
    <s:submit value="確認" class="submit_btn btn-field" />
    </div>

    </s:form>
</div>
</body>
</html>