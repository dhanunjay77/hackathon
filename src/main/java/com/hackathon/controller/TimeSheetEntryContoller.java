package com.hackathon.controller;

import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import com.hackathon.service.TimeSheetEntryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller for handling timesheet entry operations (add, getAll).
 */
@RestController
@RequestMapping("/api/timesheetentry")
public class TimeSheetEntryContoller {
    private static final Logger logger = LoggerFactory.getLogger(TimeSheetEntryContoller.class);

    @Autowired
    private TimeSheetEntryService timeSheetEntryService;

    /**
     * Endpoint to add a new timesheet entry for a contractor.
     * @param dto the timesheet entry data
     * @return the saved timesheet entry
     */
    @PostMapping("/add")
    public ResponseEntity<TimeSheetEntry> add(@Valid @RequestBody TimeSheetEntryDto dto) {
        logger.info("Received add timesheet entry request: contractorId={}, projectId={}, activityId={}",
                dto.getContractorId(), dto.getProjectId(), dto.getActivityId());
        TimeSheetEntry savedEntry = timeSheetEntryService.addTimeSheetEntry(dto);
        logger.info("Timesheet entry added successfully with id={}", savedEntry.getEntryId());
        return ResponseEntity.ok(savedEntry);
    }

    /**
     * Endpoint to get all timesheet entries.
     * @return list of all timesheet entries
     */
    @GetMapping("getAll")
    public ResponseEntity<java.util.List<TimeSheetEntry>> getTimeSheets(){
        logger.info("Fetching all timesheet entries");
        java.util.List<TimeSheetEntry> timeSheetEntries = timeSheetEntryService.getTimeSheetEntries();
        logger.info("Fetched {} timesheet entries", timeSheetEntries.size());
        return ResponseEntity.ok(timeSheetEntries);
    }
}
