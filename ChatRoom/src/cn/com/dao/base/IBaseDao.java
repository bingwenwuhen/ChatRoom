package cn.com.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 这里面发的都是一些共有方法类
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 获得所有实体
	 * @return	返回所有的实体对象
	 */
	public Collection<T> getAllEntry();
	
	/**
	 * 通过id来获取实体对象
	 * @param id	实体id
	 * @return		返回实体
	 */
	public T getEntryById(Serializable id);
	
	/**
	 * 保存实体
	 * @param t	先添加的实体
	 */
	public void saveEntry(T t);
	
	/**
	 * 更新实体对象
	 * @param t	需要更新的实体
	 */
	public void updateEntry(T t);
	
	/**
	 * 删除实体对象
	 * @param ids	实体对象id
	 */
	public void deleteByIds(Serializable... ids);
	
	/**
	 * 根据条件返回实体集合
	 * @param whereHql			hql语句
	 * @param params			参数
	 * @param orderBy			对应排序方式
	 * @return					实体集合
	 */
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			Object[] params, LinkedHashMap<String, String> orderBy);
}
