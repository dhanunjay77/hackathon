package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetEntryRepository;
import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import com.hackathon.service.TimeSheetEntryService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSheetEntryServiceImpl implements TimeSheetEntryService {

    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;

    @Override
    public TimeSheetEntry addTimeSheetEntry(TimeSheetEntryDto dtoEntry) {
    	TimeSheetEntry entry = new TimeSheetEntry();
        entry.setContractorId(dtoEntry.getContractorId());
        entry.setProjectId(dtoEntry.getProjectId());
        entry.setActivityId(dtoEntry.getActivityId());
        entry.setHoursWorked(dtoEntry.getHoursWorked());
        entry.setComments(dtoEntry.getComments());
        entry.setDate(LocalDateTime.now());
    	return timeSheetEntryRepository.save(entry);
    }

	@Override
	public List<TimeSheetEntry> getTimeSheetEntries() {
		return timeSheetEntryRepository.findAll();
	}
}
