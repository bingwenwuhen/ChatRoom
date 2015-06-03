package cn.com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dao.IUserDao;
import cn.com.domain.User;

public class UserDaoImplTest extends BaseSpring {

	@Test
	public void testGetEntryById() {
		
	}

	@Test
	public void testSaveEntry() {
		User user=new User();
		user.setUsername("xiaxuan");
		user.setPassword("123456");
		user.setSex("ÄÐ");
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		userDao.saveEntry(user);
	}

	@Test
	public void testUpdateEntry() {
		IUserDao userDao=(IUserDao) context.getBean("userDao"); 
		User user=userDao.getEntryById(1);
		user.setUsername("bingwen");
		userDao.updateEntry(user);
	}

}
