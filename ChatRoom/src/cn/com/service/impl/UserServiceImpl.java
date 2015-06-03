package cn.com.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.dao.IUserDao;
import cn.com.domain.User;
import cn.com.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name="userDao")
	private IUserDao userDao;
	
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		this.userDao.saveEntry(user);
	}

	@Transactional(readOnly=false)
	public void updateUser(User user) {
		this.userDao.updateEntry(user);
	}

	@Transactional(readOnly=false)
	public void deleteUser(Serializable id) {
		this.userDao.deleteByIds(id);
	}

	public User findUserById(Serializable id) {
		return this.userDao.getEntryById(id);
	}

	public User checkUser(User user) {
		String whereHql=" and o.username=? and o.password=?";
		Object[] params={user.getUsername(),user.getPassword()};
		LinkedHashMap<String, String> orderBy=new LinkedHashMap<String, String>();
		orderBy.put("o.id", "asc");
		List<User> list=this.userDao.findObjectsByConditionWithNoPage(whereHql, params, orderBy);
		if(list.size()>0&&list.get(0)!=null){
			User User=list.get(0);
			User.setStatus("1");
			this.userDao.updateEntry(User);
			return User;
		}
		return null;
	}

	@Transactional(readOnly=false)
	public void loginout(User user) {
		if(user!=null){
			user.setStatus("0");
			this.userDao.updateEntry(user);
		}
	}

	public List<User> getAllOnLineUser() {
		String whereHql="and o.status='1'";
		List<User> list=this.userDao.findObjectsByConditionWithNoPage(whereHql, null, null);
		return list;
	}

}
