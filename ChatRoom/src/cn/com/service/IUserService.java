package cn.com.service;

import java.io.Serializable;
import java.util.List;

import cn.com.domain.User;

public interface IUserService {
	
	/**
	 * 增加新用户
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id	用户id
	 */
	public void deleteUser(Serializable id);
	
	/**
	 * 查询用户
	 * @param id	用户id
	 * @return
	 */
	public User findUserById(Serializable id);

	/**
	 * 检查用户是否存在
	 * @param user	用户信息
	 * @return		如果存在返回true，不存在返回false
	 */
	public User checkUser(User user);

	/**
	 * 用户退出，修改用户状态为0
	 * @param user	用户信息
	 */
	public void loginout(User user);
	
	/**
	 * 获得所有在线用户
	 * @return
	 */
	public List<User> getAllOnLineUser();
}
