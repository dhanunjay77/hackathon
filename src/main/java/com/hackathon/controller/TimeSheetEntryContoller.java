package com.hackathon.controller;

import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import com.hackathon.service.TimeSheetEntryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/timesheetentry")
@RequiredArgsConstructor
@PreAuthorize("hasRole('TIMESHEETEntry')")
public class TimeSheetEntryContoller {

    @Autowired
    private TimeSheetEntryService timeSheetEntryService;

    @PostMapping("/add")
    public ResponseEntity<TimeSheetEntry> add(@Valid @RequestBody TimeSheetEntryDto dto) {
        TimeSheetEntry entry = new TimeSheetEntry();
        entry.setContractorId(dto.getContractorId());
        entry.setProjectId(dto.getProjectId());
        entry.setActivityId(dto.getActivityId());
        entry.setHoursWorked(dto.getHoursWorked());
        entry.setComments(dto.getComments());
        entry.setDate(LocalDateTime.now());
        TimeSheetEntry savedEntry = timeSheetEntryService.addTimeSheetEntry(entry);
        return ResponseEntity.ok(savedEntry);
    }
}
