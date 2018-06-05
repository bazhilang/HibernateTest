import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
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

public class StudentsTest {

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
	@Test	//把图片写入到数据库，图片不能太大，太大会报错
	public void testSaveStudents() throws Exception {
		//生成学生对象
//		Students stu = new Students(1, "张三丰", "男", new Date(), "武当山");
//		session.save(stu);
		Students s = new Students();
//		s.setSid(1);
		s.setSname("巴志浪");
		s.setGender("男");
		s.setBirthday(new Date());
		File f=new File("e:"+File.separator+"image.png");
		InputStream input =new FileInputStream(f);
		Blob image = Hibernate.getLobCreator(session).createBlob(input, input.available());
		s.setSpicture(image);
//		Address address=new Address("330046","07553638","九江市");
//		s.setAddress(address);
		
		session.save(s);
//		session.save(s);
	}
	@Test	//获取数据中主键为1的数据，获取图片字段并从新生成写入e盘生成image1.png文件
	public void testReadBlob() throws Exception {
		Students s = (Students) session.get(Students.class, 1);
		Blob image = s.getSpicture();
		InputStream input = image.getBinaryStream();
		
		File f = new File("e:"+File.separator+"image1.png");
		OutputStream out = new FileOutputStream(f);
		byte[] buff = new byte[input.available()];
		input.read(buff);
		out.write(buff);
		input.close();
		out.close();
	}
}
