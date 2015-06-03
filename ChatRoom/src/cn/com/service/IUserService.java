package cn.com.service;

import java.io.Serializable;
import java.util.List;

import cn.com.domain.User;

public interface IUserService {
	
	/**
	 * �������û�
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * �����û�
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * ɾ���û�
	 * @param id	�û�id
	 */
	public void deleteUser(Serializable id);
	
	/**
	 * ��ѯ�û�
	 * @param id	�û�id
	 * @return
	 */
	public User findUserById(Serializable id);

	/**
	 * ����û��Ƿ����
	 * @param user	�û���Ϣ
	 * @return		������ڷ���true�������ڷ���false
	 */
	public User checkUser(User user);

	/**
	 * �û��˳����޸��û�״̬Ϊ0
	 * @param user	�û���Ϣ
	 */
	public void loginout(User user);
	
	/**
	 * ������������û�
	 * @return
	 */
	public List<User> getAllOnLineUser();
}
