package com.hackathon.controller;

import com.hackathon.dto.ManagerTimeSheetResponseDto;
import com.hackathon.dto.TimeSheetSubmitDto;
import com.hackathon.entities.TimeSheet;
import com.hackathon.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/timesheet")
public class TimeSheetController {

    @Autowired
    private TimeSheetService timeSheetService;

    @PostMapping("/submit")
    public ResponseEntity<TimeSheet> submitTimeSheet(@RequestBody TimeSheetSubmitDto dto) {
        TimeSheet timeSheet = timeSheetService.submitTimeSheet(dto);
        return ResponseEntity.ok(timeSheet);
    }

    @PutMapping("/manager-response")
    public ResponseEntity<TimeSheet> managerRespondToTimeSheet(@RequestBody ManagerTimeSheetResponseDto dto) {
        TimeSheet updated = timeSheetService.managerRespondToTimeSheet(dto);
        return ResponseEntity.ok(updated);
    }
}
