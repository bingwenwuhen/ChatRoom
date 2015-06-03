package cn.com.service;

import cn.com.domain.Message;
import cn.com.domain.User;


public interface IMessageService {
	
	public void saveMessage(Message message);
	
	public void updateMessage(Message message);
	
	/**
	 * 获取其他人的聊天信息
	 * @param integer
	 * @return
	 */
	public Message getMessageByUserId(Integer UserId);

	/**
	 * 获得其他人给你的私信
	 * @param username	用户名
	 * @return
	 */
	public Message getOtherToYouPrivilegeMessage(String username);
}
