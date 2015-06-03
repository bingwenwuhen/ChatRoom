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
			throw new RuntimeException("您要访问的服务名不能为空");
		}
		//如果spring容器中中包含beanName
		if(sc.context.containsBean(beanName)){
			bean=sc.context.getBean(beanName);
		}
		//如果spring容器中不包含beanName
		if(bean==null){
			throw new RuntimeException("您要访问的服务名称["+beanName+"]不不存在");
		}
		return bean;
	}
}
