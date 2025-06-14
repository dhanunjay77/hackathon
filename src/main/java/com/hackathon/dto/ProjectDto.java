package com.hackathon.dto;

import com.hackathon.constants.ProjectStatus;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProjectDto {

	private String projectName;

	private String client;

	private ProjectStatus status;

	@ManyToOne
	private ContractorDto contractor;
}
