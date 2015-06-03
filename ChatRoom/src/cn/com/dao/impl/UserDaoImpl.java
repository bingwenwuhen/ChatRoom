package cn.com.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.dao.IUserDao;
import cn.com.dao.base.impl.BaseDaoImpl;
import cn.com.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

}
