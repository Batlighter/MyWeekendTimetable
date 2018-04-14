package org.itstep.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Subject;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDAO {
	
	@Autowired
	HibernateUtil hiber;
	
	Subject save(Subject subject) {
		
		if(get(subject.getId()) == null )
		{
			Session session = hiber.getSessionFactory().openSession();
			
			Transaction transaction = session.beginTransaction();
					
			session.saveOrUpdate(subject);
			
			transaction.commit();
			
			session.close();
			
			return subject;
		}
		return null;
	}
	Subject update(Subject subject) {
		
		if(get(subject.getId()) != null )
		{
			Session session = hiber.getSessionFactory().openSession();
			
			Transaction transaction = session.beginTransaction();
					
			session.saveOrUpdate(subject);
			
			transaction.commit();
			
			session.close();
			
			return subject;
		}
		return null;
	}
	
	Subject get(Integer id) {
	
	Session session = hiber.getSessionFactory().openSession();
	
	Transaction transaction = session.beginTransaction();
			
	Subject subjectFromDB = session.get(Subject.class, id);
	
	transaction.commit();
	
	session.close();
	
	return subjectFromDB;
	}
	
	void delete(Subject id) {
		
		Session session = hiber.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
				
		session.delete(id);
		
		transaction.commit();
		
		session.close();
	} 
}
