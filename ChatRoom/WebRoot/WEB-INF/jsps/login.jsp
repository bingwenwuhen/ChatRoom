<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Login</title>
        <!-- CSS -->   
        <link  href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css">
        <link  href="${pageContext.request.contextPath}/css/supersized.css" rel="stylesheet" type="text/css">
        <link  href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body oncontextmenu="return false">

        <div class="page-container">
            <h1>Login</h1>
            <form action="<c:url value='/user/login.do'/>" method="post">
				<div>
					<input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
				</div>
                <div>
					<input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
                </div>
                <button id="submit" type="submit">Sign in</button>
                <a href="<c:url value='/user/toRegister.do'/>"><button id="submit" type="button">Register</button></a>
            </form>
            <div class="connect">
                <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
				<p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
            </div>
        </div>
		<div class="alert" style="display:none">
			<h2>消息</h2>
			<div class="alert_con">
				<p id="ts"></p>
				<p style="line-height:70px"><a class="btn">确定</a></p>
			</div>
		</div>
        <script src="<c:url value='/js/supersized.3.2.7.min.js'/>"></script>
		<script>
		$(".btn").click(function(){
			is_hide();
		});
		var u = $("input[name=username]");
		var p = $("input[name=password]");
		$("#submit").live('click',function(){
			if(u.val() == '' || p.val() =='')
			{
				$("#ts").html("用户名或密码不能为空~");
				is_show();
				return false;
			}
			else{
				var reg = /^[0-9A-Za-z]+$/;
				if(!reg.exec(u.val()))
				{
					$("#ts").html("用户名错误");
					is_show();
					return false;
				}
			}
		});
		window.onload = function()
		{
			$(".connect p").eq(0).animate({"left":"0%"}, 600);
			$(".connect p").eq(1).animate({"left":"0%"}, 400);
		};
		function is_hide(){ $(".alert").animate({"top":"-40%"}, 300); }
		function is_show(){ $(".alert").show().animate({"top":"45%"}, 300); }
		
		
		
		
		
		
		jQuery(function($){

		    $.supersized({

		        // Functionality
		        slide_interval     : 6000,    // Length between transitions
		        transition         : 1,    // 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
		        transition_speed   : 3000,    // Speed of transition
		        performance        : 1,    // 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)

		        // Size & Position
		        min_width          : 0,    // Min width allowed (in pixels)
		        min_height         : 0,    // Min height allowed (in pixels)
		        vertical_center    : 1,    // Vertically center background
		        horizontal_center  : 1,    // Horizontally center background
		        fit_always         : 0,    // Image will never exceed browser width or height (Ignores min. dimensions)
		        fit_portrait       : 1,    // Portrait images will not exceed browser height
		        fit_landscape      : 0,    // Landscape images will not exceed browser width

		        // Components
		        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
		        slides             : [    // Slideshow Images
		                                 {image : '${pageContext.request.contextPath}/images/1.jpg'},
		                                 {image : '${pageContext.request.contextPath}/images/2.jpg'},
		                                 {image : '${pageContext.request.contextPath}/images/3.jpg'}
		                             ]

		    });

		});
		</script>
    </body>

</html>

