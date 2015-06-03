package cn.com.dao.base.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.StringUtils;

import cn.com.dao.base.IBaseDao;
import cn.com.utils.GenericClass;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	private Class clazz=GenericClass.getGenericClass(this.getClass());
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	public Collection<T> getAllEntry() {
		String whereHql="from "+clazz.getName();
		List<T> list=this.hibernateTemplate.find(whereHql);
		return list;
	}

	public T getEntryById(Serializable id) {
		if(id==null){
			throw new RuntimeException("您要查找的["+id+"]不能为空");
		}
		T t=(T) this.hibernateTemplate.get(clazz, id);
		return t;
	}

	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	public void deleteByIds(Serializable... ids) {
		if(ids!=null&&ids.length>0){
			for(Serializable id:ids){
				Object obj=this.hibernateTemplate.get(clazz, id);
				if(obj==null){
					throw new RuntimeException("您要查找的["+id+"]不存在");
				}
				this.hibernateTemplate.delete(obj);
			}
		}
	}

	@Override
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			final Object[] params, LinkedHashMap<String, String> orderBy) {
		//组织hql语句
		String hql="from "+clazz.getSimpleName()+" o where 1=1 ";
		if(StringUtils.hasText(whereHql)){
			hql=hql+whereHql;
		}
		//处理排序
		String orderbystr=buildOrderBy(orderBy);
		hql=hql+orderbystr;
		final String fhql=hql;
		List<T> list=(List<T>) this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				Query query=session.createQuery(fhql);
				setParam(query,params);
				return  query.list();
				}

			});
		return list;
	}

	private void setParam(Query query, Object[] params) {
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
		}
	}
	
	private String buildOrderBy(LinkedHashMap<String, String> orderBy) {
		StringBuffer buf=new StringBuffer();
		if(orderBy!=null&&!orderBy.isEmpty()){
			buf.append(" order by ");
			for(Map.Entry<String, String> em:orderBy.entrySet()){
				buf.append(em.getKey()+" "+em.getValue()+",");
			}
			//去掉最后一个逗号
			buf.deleteCharAt(buf.length()-1);
		}
		return buf.toString();
	}
	
}
