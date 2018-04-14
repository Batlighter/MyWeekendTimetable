package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "subjects")
public class Subject {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "subject_id")
	@JsonProperty
	private Integer Id;
	 
	@Column( name = "subject_name")
	@JsonProperty
	private String name;

}
