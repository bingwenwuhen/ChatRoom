package cn.com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.com.dao.IUserDao;
import cn.com.domain.User;

public class UserServiceImplTest extends BaseSpring {

	@Test
	public void testSaveUser() {
		User user=new User();
		user.setUsername("dongfangchangming");
		user.setSex("ÄÐ");
		user.setPassword("dongfang");
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		userDao.saveEntry(user);
	}

	@Test
	public void testUpdateUser() {
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		User user=userDao.getEntryById(5);
		user.setPassword("123456");
		userDao.updateEntry(user);
	}

	@Test
	public void testDeleteUser() {
		IUserDao userDao=(IUserDao) context.getBean("userDao");
		userDao.deleteByIds(3);
	}

	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}

}
