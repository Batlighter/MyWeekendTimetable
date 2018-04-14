package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.LessonDAO;
import org.itstep.model.Lesson;
import org.itstep.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService{

	@Autowired
	LessonDAO lessonDao;
	
	public Lesson save(Lesson lesson) {
		return lessonDao.save(lesson);
	}

	public Lesson update(Lesson lesson) {
		return lessonDao.update(lesson);
	}

	public Lesson get(Integer id) {
		return lessonDao.get(id);
	}

	public List<Lesson> findAllByStartTime(Long startPeriod, Long endPeriod) {
		return lessonDao.findAllByStartTime(startPeriod, endPeriod);
	}

	public void delete(Lesson lesson) {
		lessonDao.delete(lesson);
	}

}
