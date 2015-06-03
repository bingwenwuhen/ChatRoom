package cn.com.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.dao.IMessageDao;
import cn.com.dao.base.impl.BaseDaoImpl;
import cn.com.domain.Message;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements IMessageDao {

}
