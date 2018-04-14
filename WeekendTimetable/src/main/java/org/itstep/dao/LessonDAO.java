package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LessonDAO {

	@Autowired
	HibernateUtil hiber;

	public Lesson save(Lesson lesson) {

		if (get(lesson.getId()) == null) {

			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(lesson);

			transaction.commit();

			session.close();

			return lesson;
		}
		return null;
	}

	public Lesson update(Lesson lesson) {

		if (get(lesson.getId()) != null) {

			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(lesson);

			transaction.commit();

			session.close();

			return lesson;
		}
		return null;
	}

	public Lesson get(Integer id) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Lesson lessonFromDB = session.get(Lesson.class, id);

		transaction.commit();

		session.close();

		return lessonFromDB;
	}

	public void delete(Lesson lesson) {
		
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.delete(lesson);

			transaction.commit();

			session.close();

		
	}

	public List<Lesson> findAllByStartTime(Long startPeriod, Long endPeriod) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM LESSONS WHERE START_TIME> :st_time AND START_TIME< :end_time",
				Lesson.class);

		query.setParameter("st_time", startPeriod);

		query.setParameter("end_time", endPeriod);
		
		List<Lesson> lessonsFromDB = (List<Lesson>) session.beginTransaction();
		
		transaction.commit();

		session.close();

		return lessonsFromDB;
	}

	public List<Lesson> findAllBySubject(Subject subject) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM LESSONS WHERE SUBJECT_SUBJECT_ID = :sub_id",
				Lesson.class);

		query.setParameter("sub_id", subject.getId());

		List<Lesson> lessonsFromDB = (List<Lesson>) session.beginTransaction();
		
		transaction.commit();

		session.close();

		return lessonsFromDB;
	}
}
