$().ready(function(){
	//清除聊天记录
	$("#deleteAll").click(function(){
		$("ul li").remove();
	});
	//ajax从后台获取数据
	setInterval(function(){
		$(".custom dd").remove();
		var $custom=$(".custom");
		 $.ajax({
             type: "POST",
             url: "/ChatRoom/user/getOnLineUser.do",
             async:false,
             data: null,
             dataType: "json",
             success: function(data){
            	 $(".custom dd").remove();
            	 for(var i=0;i<data.length;i++){
            	 var $dd=$("<dd class='menu_chioce' style='display: none;'></dd>");
 				 var $a=$("<a></a>");
 				 $a.text(data[i].username);
 				 $dd.html($a);
 				 $custom.append($dd);
            	 }
            	 $(".custom").each(function(){
            		$(this).hide(); 
            	 });
              }
         });
		 $(".custom").each(function(){
			 $(this).show();
		 });
			//获取其他人的聊天信息
		 	var id=0;
			$.post("/ChatRoom/message/getOthersMessage.do",null,function(data2){
				if(data2!=null&&data2!=""&&id!=data2.id&&data2.id!=null){
					id=data2.id;
					var $li=$("<li></li>");
					var $div=$("<div class='userPic'></div>");
					var $img=$("<img src='../img/face.gif' />");
					$div.append($img);
					$li.append($div);
					var $div2=$("<div class='content'></div>");
					var $div3=$("<div class='userName'></div>");
					var $a=$("<a href='javascript:;'></a>");
					$a.text(data2.username);
					$div3.append($a);
					$div2.append($div3);
					var $div5=$("<div class='msgInfo'></div>");
					$div5.html(data2.message);
					$div2.append($div5);
					var $div4=$("<div class='times'></div>");
					var $span=$("<span></span>");
					$span.text(data2.createTime);
					$div4.append($span);
					var $a2=$("<a class='del' href='javascript:;'>删除</a>");
					$div4.append($a2);
					$div2.append($div4);
					$li.append($div2);
					$li.appendTo($("#ulmessage"));
				}
				data2=null;
			});
			
			//获取其他人对你的私聊信息
		 	var id2=0;
			$.post("/ChatRoom/message/getOtherToYouPrivilegeMessage.do",null,function(data3){
				if(data3!=null&&data3!=""&&id2!=data3.id&&data3.id!=null){
					id2=data3.id;
					var $li=$("<li></li>");
					var $div=$("<div class='userPic'></div>");
					var $img=$("<img src='../img/face.gif' />");
					$div.append($img);
					$li.append($div);
					var $div2=$("<div class='content'></div>");
					var $div3=$("<div class='userName'></div>");
					var $a=$("<a href='javascript:;'></a>");
					$a.text(data3.username+$("#hidenToYou").val());
					$div3.append($a);
					$div2.append($div3);
					var $div5=$("<div class='msgInfo'></div>");
					$div5.html(data3.message);
					$div2.append($div5);
					var $div4=$("<div class='times'></div>");
					var $span=$("<span></span>");
					$span.text(data3.createTime);
					$div4.append($span);
					var $a2=$("<a class='del' href='javascript:;'>删除</a>");
					$div4.append($a2);
					$div2.append($div4);
					$li.append($div2);
					$li.appendTo($("#ulmessage"));
				}
				data3=null;
			});
	}, 5000);
	//将留言内容发送给后台
	$("#sendBtn").click(function(){
		var check=$("input[name='privilege']:checked");
		if((check!=null||check!=undefined)&&$(check).attr("checked")){
			var checkbox=$(check).attr("id");
			var username=checkbox.substring(5);
			var parameter={
				username:username,
				type:'私聊',
				message:CKEDITOR.instances.conBox.getData()
			};
			$.post("/ChatRoom/message/savePrivilegeChatMessage.do",parameter,function(data){
				
			});
		}else{
			var parameter={
				message:CKEDITOR.instances.conBox.getData(),
				type:$("#hiddenChat").attr("checked")
			};
			$.post("/ChatRoom/message/saveMessage.do",parameter,function(){
			
		});
		}
	});
	setInterval(function(){
		debugger;
		$(".channel dd").remove();
		var $custom=$(".channel");
		 $.ajax({
             type: "POST",
             url: "/ChatRoom/user/getOnLineUser.do",
             async:false,
             data: null,
             dataType: "json",
             success: function(data){
            	 debugger;
            	 $(".channel dd").remove();
            	 for(var i=0;i<data.length;i++){
            	 var $dd=$("<dd class='menu_chioce' style='display: none;'></dd>");
            	 var $checkbox=$("<input type='checkbox' name='privilege' id='check"+data[i].username+"'/>");
 				 var $a=$("<a></a>");
 				 $a.text(data[i].username);
 				 $dd.html($checkbox);
 				 $dd.append($a);
 				 $custom.append($dd);
            	 }
            	 $("input[name='privilege']").click(function(){
            		var id=$(this).attr("id"); 	
            		$("input[name='privilege']").each(function(){
            			if($(this).attr("id")!=id){
            				$(this).attr("checked",null);
            			}
            		});
            	});
              }
         });
	}, 30000);
});