package cn.com.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.dao.IMessageDao;
import cn.com.domain.Message;
import cn.com.service.IMessageService;

@Service("messageService")
public class MessageServiceImpl implements IMessageService{

	@Resource(name="messageDao")
	private IMessageDao messageDao;

	@Transactional(readOnly=false)
	public void saveMessage(Message message) {
		this.messageDao.saveEntry(message);
	}

	@Transactional(readOnly=false)
	public void updateMessage(Message message) {
		this.messageDao.updateEntry(message);
	}

	public Message getMessageByUserId(Integer UserId) {
		String whereHql="and o.UserId !=? and o.type='х╨ад'";
		Object[] params={UserId};
		LinkedHashMap<String, String> orderBy=new LinkedHashMap<String, String>();
		orderBy.put("o.id", "desc");
		List<Message> list=this.messageDao.findObjectsByConditionWithNoPage(whereHql, params, orderBy);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public Message getOtherToYouPrivilegeMessage(String username) {
		String whereHql=" and o.toPerson like ? and o.type='к╫ад'";
		Object[] params={"%"+username+"%"};
		LinkedHashMap<String, String> orderBy=new LinkedHashMap<String, String>();
		orderBy.put("o.id", "desc");
		List<Message> list=this.messageDao.findObjectsByConditionWithNoPage(whereHql, params, orderBy);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
