package com.hackathon.entities;

import com.hackathon.constants.ProjectStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectCode;
	
	private String projectName;
	
	private String client;
	
	private ProjectStatus status;
	
	@ManyToOne
	private Contractor contractor;
}
