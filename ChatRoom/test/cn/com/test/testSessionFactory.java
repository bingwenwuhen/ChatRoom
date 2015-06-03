package cn.com.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class testSessionFactory extends BaseSpring{
	
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
}
