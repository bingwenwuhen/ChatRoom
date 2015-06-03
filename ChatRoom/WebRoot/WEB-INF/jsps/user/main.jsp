<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天界面</title>
<style type="text/css">
body{margin:0;padding:0;overflow-x:hidden;}
html, body{height:100%;}
img{border:none;}
*{font-family:'微软雅黑';font-size:12px;color:#626262;}
dl,dt,dd{display:block;margin:0;}
a{text-decoration:none;}

#bg{background-image:url(${pageContext.request.contextPath}/images/left/dotted.png);}
.container{width:100%;height:100%;margin:auto;}

/*left*/
.leftsidebar_box{width:160px;height:auto !important;overflow:visible !important;position:fixed;height:100% !important;background-color:#3992d0;}
.line{height:2px;width:100%;background-image:url(${pageContext.request.contextPath}/images/left/line_bg.png);background-repeat:repeat-x;}
.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
.leftsidebar_box dd{background-color:#317eb4;padding-left:40px;}
.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
.system_log dt{background-image:url(${pageContext.request.contextPath}/images/left/system.png)}
.custom dt{background-image:url(${pageContext.request.contextPath}/images/left/custom.png)}
.channel dt{background-image:url(${pageContext.request.contextPath}/images/left/channel.png)}
.app dt{background-image:url(${pageContext.request.contextPath}/images/left/app.png)}
.cloud dt{background-image:url(${pageContext.request.contextPath}/images/left/cloud.png)}
.syetem_management dt{background-image:url(${pageContext.request.contextPath}/images/left/syetem_management.png)}
.source dt{background-image:url(${pageContext.request.contextPath}/images/left/source.png)}
.statistics dt{background-image:url(${pageContext.request.contextPath}/images/left/statistics.png)}
.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
</style>
<style type="text/css">object,embed{-webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;                -o-animation-duration:.001s;-o-animation-name:playerInserted;                animation-duration:.001s;animation-name:playerInserted;}                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}</style></head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/chat2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery_chatroom.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/chat2.css" type="text/css">
<body id="bg">
<div class="container">
	<div class="leftsidebar_box">
		<div class="line"></div>
		<dl class="custom">
			<dt onclick="changeImage()" style="background-color: rgb(57, 146, 208);">所有在线用户<img src="${pageContext.request.contextPath}/images/select_xl01.png"></dt>
			<c:forEach items="${OnlineUsers}" var="user">
				<dd class="menu_chioce" style="display: none;"><a>${user.username}</a></dd>
			</c:forEach>
		</dl>
		 <dl class="system_log">
			<dt onclick="changeImage()" style="background-color: rgb(57, 146, 208);">选择操作<img src="<c:url value='/images/select_xl01.png'/>"></dt>
			<dd class="first_dd" style="display: none;"><a href="<c:url value='/user/logout.do'/>">退出登录</a></dd>
			<dd style="display: none;"><a href="<c:url value='/user/logout.do'/>">更换用户</a></dd>
			<dd style="display: none;" id="deleteAll"><a>清除所有聊天记录</a></dd>
			<dd style="display: none;"><input id="hiddenChat" type="checkbox"/><a>匿名聊天</a></dd>
		</dl>
		<br/>
		<br/>
		<br/>
		<br/>
			<dl class="channel">
			<dt onclick="changeImage()" style="background-color: rgb(57, 146, 208);">私聊对象<img src="select_xl01.png"></dt>
			</dl>
	</div>
	<center>
	<div id="msgBox" style="width:1000px;">
    <div class="list"  style="overflow-y:scroll; width: 1000px; height: 400px;">
        <h3><span>大家在说</span></h3>
        <ul id="ulmessage">
            <li>
                <div class="userPic"><img src="${pageContext.request.contextPath}/img/face.gif" /></div>
                <div class="content">
                    <div class="userName"><a href="javascript:;">永不上线</a>:</div>
                    <div class="msgInfo">新增删除广播功能。</div>
                    <div class="times"><span>07月05日 15:14</span><a class="del" href="javascript:;">删除</a></div>
                </div>

            </li>
            <li>
                <div class="userPic"><img src="${pageContext.request.contextPath}/img/face.gif" /></div>
                <div class="content">
                    <div class="userName"><a href="javascript:;">永不上线</a>:</div>
                    <div class="msgInfo">新增Ctrl+Enter快捷键发送广播。</div>
                    <div class="times"><span>07月05日 12:20</span><a class="del" href="javascript:;">删除</a></div>

                </div>
            </li>
        </ul>
    </div>
    <form>
        <h2>来 , 说说你在做什么 , 想什么</h2>
		<input type="hidden" id="imageurl" value="${User.imageUrl}"/>
		<input type="hidden" id="hidenToYou" value="对你说"/>
        <div>
            <input id="userName" type="hidden" class="f-text" value="你说"/>
           <%--  <p id="face"><img src="${pageContext.request.contextPath}/img/face1.gif" class="current" /><img src="${pageContext.request.contextPath}/img/face2.gif" /><img src="${pageContext.request.contextPath}/img/face3.gif" /><img src="${pageContext.request.contextPath}/img/face4.gif" /><img src="${pageContext.request.contextPath}/img/face5.gif" /><img src="${pageContext.request.contextPath}/img/face6.gif" /><img src="${pageContext.request.contextPath}/img/face7.gif" /><img src="${pageContext.request.contextPath}/img/face8.gif" /></p> --%>
        </div>
        <div><textarea id="conBox" name="conBox" class="f-text"></textarea></div>
        <script type="text/javascript">
    //<![CDATA[
        // Replace the <textarea id="editor1"> with an CKEditor instance.
       	 var editor = CKEDITOR.replace("conBox");
        //]]>
        </script>
        <div class="tr">
            <p>
                <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span>

                <input id="sendBtn" type="button" value="" title="快捷键 Ctrl+Enter" />
            </p>
        </div>
    </form>
	</div>
	</center>
</div>
</body>
<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
$(".leftsidebar_box dt img").attr("src","${pageContext.request.contextPath}/images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","${pageContext.request.contextPath}/images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","${pageContext.request.contextPath}/images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
});
</script>
</html>
