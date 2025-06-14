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

@RestController
@RequestMapping("/api/timesheetentry")
public class TimeSheetEntryContoller {

    @Autowired
    private TimeSheetEntryService timeSheetEntryService;

    @PostMapping("/add")
    public ResponseEntity<TimeSheetEntry> add(@Valid @RequestBody TimeSheetEntryDto dto) {
        
        TimeSheetEntry savedEntry = timeSheetEntryService.addTimeSheetEntry(dto);
        return ResponseEntity.ok(savedEntry);
    }
    
    @GetMapping("getAll")
    public ResponseEntity<java.util.List<TimeSheetEntry>> getTimeSheets(){
    	java.util.List<TimeSheetEntry> timeSheetEntries = timeSheetEntryService.getTimeSheetEntries();
    	return ResponseEntity.ok(timeSheetEntries);
    }
}
