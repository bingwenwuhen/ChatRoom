package cn.com.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * �������ҪĿ���Ǽ���spring�����ļ�
 * @author Administrator
 *
 */
public class ServiceProvinderCore {
	protected ApplicationContext context;
	
	public void load(String filename){
		context=new ClassPathXmlApplicationContext(filename);
	}
}
