<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="shortcut icon" href="<url value='/images/favicon.ico'/>" />
<link href="<c:url value='/css/style2.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.i18n.properties-1.0.9.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.10.3.custom.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/md5.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/page_regist.js?lang=zh'/>"></script>

</head>
<body class="loginbody">
<div class="dataEye">
	<div class="loginbox registbox">
		<div class="login-content reg-content">
			<div class="loginbox-title">
				<h3>注册</h3>
			</div>
			<form id="signupForm" action="<c:url value='/user/register.do'/>" method="post" enctype="multipart/form-data">
			<div class="login-error"></div>
			<div class="row">
				<!-- <label  for="email">注册用户名</label> -->
				<input type="text" value="" placeholder="用户名" class="input-text-user noPic input-click" name="username" id="username">
			</div>
			<div class="row">
				<!-- <label class="field" for="password">密码</label> -->
				<input type="password" placeholder="密码" value="" class="input-text-password noPic input-click" name="password" id="password">
			</div>
			<div class="row">
				<!-- <label class="field" for="passwordAgain">确认密码</label> -->
				<input type="password" placeholder="确认密码" value="" class="input-text-password noPic input-click" name="passwordAgain" id="passwordAgain">
			</div>
			<div class="row">
				<label  for="contact">性别</label>
				<!-- <input type="text" value="" class="input-text-user noPic input-click" name="contact" id="contact"> -->
				<input type="radio" name="sex" value="男"/>男<input type="radio" name="sex" value="女"/>女
			</div>
			<div class="row">
				<label>选择头像:
				<input type="file" value="" placeholder="选择头像" class="input-text-user noPic input-click" name="imageUrl">
				</label>
			</div><br/>
			<div class="row tips">
				<input type="checkbox" id="checkBox">
				<label>
				我已阅读并同意
				<a href="#" target="_blank">隐私政策、服务条款</a>
				</label>
			</div>
			<div class="row btnArea">
				<a class="login-btn"><button type="submit">注册</button></a>
			</div>
			</form>
		</div>
		<div class="go-regist">
			已有帐号,请<a href="<c:url value='/index.jsp'/>" class="link">登录</a>
		</div>
	</div>
	
<div id="footer">
	<div class="dblock">
		<div class="inline-block copyright">
			
		</div>
	</div>
</div>
</div>
<div class="loading">
	<div class="mask">
		<div class="loading-img">
		<img src="<c:url value='/images/loading.gif'/>" width="31" height="31">
		</div>
	</div>
</div>
</body>
</html>


