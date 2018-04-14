package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "lessons" )
public class Lesson {

	private static final Long DURATION = 1000 * 60 * 90L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "lesson_id")
	@JsonProperty
	private Integer id;
	
	@ManyToOne( targetEntity = Subject.class )
	@JsonProperty
	private Subject subject;
	
	@ManyToOne( targetEntity = Teacher.class )
	@JsonProperty
	private Teacher teacher;
	
	@ManyToOne( targetEntity = Group.class )
	@JsonProperty
	private Group group;
	
	@Column( name = "cabinet")
	@JsonProperty
	private String cabinet;
	
	@Column( name = "start_time")
	@JsonProperty
	private Long startTime;
	
}
