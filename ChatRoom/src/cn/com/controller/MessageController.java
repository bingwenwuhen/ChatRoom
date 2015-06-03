package cn.com.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.domain.Message;
import cn.com.domain.User;
import cn.com.service.IMessageService;
import cn.com.utils.SessionUtils;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	private int id=0;
	
	private int id2=0;
	
	@Resource(name="messageService")
	private IMessageService messageService;
	
	@RequestMapping("/saveMessage.do")
	public @ResponseBody void saveMessage(HttpServletRequest request){
		User user=SessionUtils.getSysUserFromSession(request);
		String Personmessage=request.getParameter("message");
		String type=request.getParameter("type");
		Message message=new Message();
		if(type!=null){
			message.setUsername("匿名用户");
		}else{
			message.setUsername(user.getUsername());
		}
		message.setType("群聊");
		message.setCreateTime((new Date()).toString());
		message.setUserId(user.getId());
		message.setToPerson("所有");
		message.setMessage(Personmessage);
		this.messageService.saveMessage(message);
	}
	
	@RequestMapping("/getOthersMessage.do")
	public @ResponseBody Message getOthersMessage(HttpServletRequest request){
		User user=SessionUtils.getSysUserFromSession(request);
		Message message=this.messageService.getMessageByUserId(user.getId());
		if(message!=null&&message.getId()>id){
			id=message.getId();
			return message;
		}
		return null;
	}
	
	@RequestMapping("/savePrivilegeChatMessage.do")
	public @ResponseBody void savePrivilegeChatMessage(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		User user=SessionUtils.getSysUserFromSession(request);
		Message message=new Message();
		String type=request.getParameter("type");
		String username=request.getParameter("username");
		String privilegeMessage=request.getParameter("message");
		message.setMessage(privilegeMessage);
		message.setToPerson(username);
		message.setUserId(user.getId());
		message.setType("私聊");
		message.setUsername(user.getUsername());
		message.setCreateTime((new Date()).toString());
		this.messageService.saveMessage(message);
	}
	
	@RequestMapping("/getOtherToYouPrivilegeMessage.do")
	public @ResponseBody Message getOtherToYouPrivilegeMessage(HttpServletRequest request){
		User user=SessionUtils.getSysUserFromSession(request);
		Message message=this.messageService.getOtherToYouPrivilegeMessage(user.getUsername());
		if(message!=null&&message.getId()>id2){
			id2=message.getId();
			return message;
		}
		return null;
	}
}
