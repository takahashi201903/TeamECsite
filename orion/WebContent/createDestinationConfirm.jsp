<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/confirm.css">
<link rel="stylesheet" href="./css/orion.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<title>宛先情報入力確認画面</title>
</head>
<body>
<script type="text/javascript" src="./js/createDestination.js"></script>
<jsp:include page="header.jsp"/>
<div class="main-container" id="contents">
	<div class="page-title"><h1>宛先情報入力確認画面</h1></div>
		<s:form id="createDestinationForm">
		<table class="vertical-list-table">

    <tr>

        <th scope="row"><s:label value="姓"/></th>

        <td>
        <s:property value="familyName"/>
        </td>

    </tr>

    <tr>

        <th scope="row"><s:label value="名"/></th>

        <td>
        <s:property value="firstName"/>
        </td>

    </tr>

    <tr>

        <th scope="row"><s:label value="姓ふりがな"/></th>

        <td>
        <s:property value="familyNameKana"/>
        </td>

    </tr>

    <tr>

        <th scope="row"><s:label value="名ふりがな"/></th>

        <td>
        <s:property value="firstNameKana"/>
        </td>
    </tr>

    <tr>

        <th scope="row"><s:label value="住所"/></th>

        <td>
        <s:property value="userAddress"/>
        </td>

    </tr>

    <tr>

        <th scope="row"><s:label value="電話番号"/></th>

        <td>
        <s:property value="telNumber"/>
        </td>

    </tr>

    <tr>

        <th scope="row"><s:label value="メールアドレス"/></th>

        <td>
        <s:property value="email"/>
        </td>

    </tr>
    </table>

    <div class="submit_btn_box">
		<s:submit value="登録" class="submit_btn btn-field" onclick="goCreateDestinationCompleteAction()"/>
	</div>
	<div class="submit_btn_box">
		<s:submit value="戻る" class="submit_btn btn-field" onclick="goCreateDestinationAction()"/>
	</div>

    <s:hidden id="backFlag" name="backFlag" value=""/>
</s:form>
</div>
</body>
</html>