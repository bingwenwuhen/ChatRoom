package cn.com.container;

import org.springframework.util.StringUtils;

public class ServiceProvinder {
	private static ServiceProvinderCore sc;
	
	static{
		sc=new ServiceProvinderCore();
		sc.load("spring/applicationContext.xml");
	}
	
	public static Object getService(String beanName){
		Object bean=null;
		if(!StringUtils.hasText(beanName)){
			throw new RuntimeException("��Ҫ���ʵķ���������Ϊ��");
		}
		//���spring�������а���beanName
		if(sc.context.containsBean(beanName)){
			bean=sc.context.getBean(beanName);
		}
		//���spring�����в�����beanName
		if(bean==null){
			throw new RuntimeException("��Ҫ���ʵķ�������["+beanName+"]��������");
		}
		return bean;
	}
}
