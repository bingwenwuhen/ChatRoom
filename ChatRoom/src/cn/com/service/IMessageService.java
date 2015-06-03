package cn.com.service;

import cn.com.domain.Message;
import cn.com.domain.User;


public interface IMessageService {
	
	public void saveMessage(Message message);
	
	public void updateMessage(Message message);
	
	/**
	 * ��ȡ�����˵�������Ϣ
	 * @param integer
	 * @return
	 */
	public Message getMessageByUserId(Integer UserId);

	/**
	 * ��������˸����˽��
	 * @param username	�û���
	 * @return
	 */
	public Message getOtherToYouPrivilegeMessage(String username);
}
