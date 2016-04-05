package org.atheby.springhibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDao {

	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Object getForId(Object obj, int id) {
		return getSession().get(obj.getClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getAll(Object obj) {
		return getSession().createCriteria(obj.getClass()).list();
	}
	
	public int getCountRows(Object obj) {
		return ((Long) getSession().createCriteria(obj.getClass()).setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}
	
	public void insert(Object obj) {
		getSession().save(obj);
	}
	
	public void update(Object obj) {
		getSession().saveOrUpdate(obj);
	}
	
	public void delete(Object obj) {
		getSession().delete(obj);
	}
	
	public void close() {
		getSession().close();
	}
	
	public void beginTransaction() {
		getSession().beginTransaction();
	}
	
	public void commit() {
		getSession().getTransaction().commit();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		if(session == null || !session.isOpen())
			setSession(getSessionFactory());
		return session;
	}
	
	private void setSession(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}
}
