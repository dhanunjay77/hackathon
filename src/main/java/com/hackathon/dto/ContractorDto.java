package com.hackathon.dto;

import java.util.List;

import com.hackathon.entities.Project;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class ContractorDto {

	private String name;
	
	@OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProjectDto> projects;
}
