package org.atheby.springhibernate;

import org.atheby.springhibernate.dao.HibernateDao;
import org.atheby.springhibernate.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDao dao = ctx.getBean("hibernateDao", HibernateDao.class);
		
		User user = ctx.getBean("user", User.class);
		user.setUsername("first user");
		user.setFirstname("John");
		dao.beginTransaction();
		dao.insert(user);
		dao.commit();
		dao.close();
		
		System.out.println(dao.getCountRows(new User()));
		
		for(Object usersList : dao.getAll(new User())) {
			System.out.println(((User) usersList).getUsername());
		}
		
		dao.getSessionFactory().close();
	}
}

