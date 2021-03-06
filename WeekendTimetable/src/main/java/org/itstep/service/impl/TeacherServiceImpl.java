package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.TeacherDAO;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherDAO TeacherDao;
	
	public Teacher save(Teacher teacher)
	{
		if(TeacherDao.get(teacher.getLogin()) == null) {
			return TeacherDao.save(teacher);
		}
		return null;
	}
	
	public Teacher get(String login)
	{
		return TeacherDao.get(login);
	}
	
	public List<Teacher> findAllBySubject(Subject subject){
		return TeacherDao.findAllBySubject(subject);
	}
	
	public void delete(Teacher teacher) {
		TeacherDao.delete(teacher);
	}

	public Teacher update(Teacher teacher) {
		if(TeacherDao.get(teacher.getLogin()) == null) {
			return TeacherDao.save(teacher);
		}
		return null;
	}
}
