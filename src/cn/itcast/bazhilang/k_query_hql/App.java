package cn.itcast.bazhilang.k_query_hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class App {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		//创建配置对象
		Configuration config = new Configuration();
		//创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
//		sessionFactory = config.buildSessionFactory(serviceRegistry);	//Hibernate5使用这个方法
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	//Hibernate4中buildSessionFactory方法废弃问题,所以Hibernate4使用这个方法
		//会话对象
		session = sessionFactory.openSession();
//		session=sessionFactory.getCurrentSession();
		//开启事务
		transaction = session.beginTransaction();
		
	}
	@After
	public void destory() {
		transaction.commit();//提交事务
		session.close();//关闭会话
		sessionFactory.close();//关闭会话工厂
	}

	@	Test
	public void testSave() {
		for(int i=1;i<=10;i++) {
			Department department = new Department();
			department.setName("开发部_"+i);
			session.save(department);
		}
		
		for(int i=1;i<=20;i++) {
			Emplyee emplyee = new Emplyee();
			emplyee.setName("张xx_"+i);
			session.save(emplyee);
		}
	}
}
