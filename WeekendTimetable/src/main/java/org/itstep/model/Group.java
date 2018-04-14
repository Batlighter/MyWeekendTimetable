package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "groups" )
public class Group {

	@Id
	@Column( name = "group_name")
	@JsonProperty
	private String name;
	
	@Column( name = "course")
	@JsonProperty
	private String course;
	
	@Column( name = "specialization")
	@JsonProperty
	private String specialization;
	
}
