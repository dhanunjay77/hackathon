package com.hackathon.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Contractor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contractorId;
	
	private String name;
	
	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Project> projects;
}
