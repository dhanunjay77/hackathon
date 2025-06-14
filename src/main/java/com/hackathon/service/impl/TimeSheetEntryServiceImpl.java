package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetEntryRepository;
import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import com.hackathon.service.TimeSheetEntryService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service implementation for handling timesheet entry operations.
 */
@Service
public class TimeSheetEntryServiceImpl implements TimeSheetEntryService {
    private static final Logger logger = LoggerFactory.getLogger(TimeSheetEntryServiceImpl.class);

    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;

    /**
     * Adds a new timesheet entry for a contractor.
     * @param dtoEntry the timesheet entry data
     * @return the saved TimeSheetEntry entity
     */
    @Override
    public TimeSheetEntry addTimeSheetEntry(TimeSheetEntryDto dtoEntry) {
        logger.info("Adding timesheet entry for contractorId={}, projectId={}, activityId={}",
                dtoEntry.getContractorId(), dtoEntry.getProjectId(), dtoEntry.getActivityId());
        TimeSheetEntry entry = new TimeSheetEntry();
        entry.setContractorId(dtoEntry.getContractorId());
        dtoEntry.getContractorId();
        entry.setProjectId(dtoEntry.getProjectId());
        entry.setActivityId(dtoEntry.getActivityId());
        entry.setHoursWorked(dtoEntry.getHoursWorked());
        entry.setComments(dtoEntry.getComments());
        entry.setDate(LocalDateTime.now());
        TimeSheetEntry saved = timeSheetEntryRepository.save(entry);
        logger.info("Timesheet entry added with id={}", saved.getEntryId());
        return saved;
    }

    /**
     * Retrieves all timesheet entries.
     * @return list of TimeSheetEntry entities
     */
    @Override
    public List<TimeSheetEntry> getTimeSheetEntries() {
        logger.info("Fetching all timesheet entries");
        return timeSheetEntryRepository.findAll();
    }
}
