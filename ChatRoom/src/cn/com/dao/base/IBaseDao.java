package cn.com.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * �����淢�Ķ���һЩ���з�����
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * �������ʵ��
	 * @return	�������е�ʵ�����
	 */
	public Collection<T> getAllEntry();
	
	/**
	 * ͨ��id����ȡʵ�����
	 * @param id	ʵ��id
	 * @return		����ʵ��
	 */
	public T getEntryById(Serializable id);
	
	/**
	 * ����ʵ��
	 * @param t	����ӵ�ʵ��
	 */
	public void saveEntry(T t);
	
	/**
	 * ����ʵ�����
	 * @param t	��Ҫ���µ�ʵ��
	 */
	public void updateEntry(T t);
	
	/**
	 * ɾ��ʵ�����
	 * @param ids	ʵ�����id
	 */
	public void deleteByIds(Serializable... ids);
	
	/**
	 * ������������ʵ�弯��
	 * @param whereHql			hql���
	 * @param params			����
	 * @param orderBy			��Ӧ����ʽ
	 * @return					ʵ�弯��
	 */
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			Object[] params, LinkedHashMap<String, String> orderBy);
}
