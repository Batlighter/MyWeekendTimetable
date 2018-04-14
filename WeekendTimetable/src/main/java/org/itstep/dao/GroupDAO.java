package org.itstep.dao;

import java.util.List;

import org.itstep.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group, String>{

	List<Group> findAllByCourse(String course);
}
