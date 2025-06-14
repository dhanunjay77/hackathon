package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetRepository;
import com.hackathon.constants.Status;
import com.hackathon.dto.ManagerTimeSheetResponseDto;
import com.hackathon.dto.TimeSheetSubmitDto;
import com.hackathon.entities.TimeSheet;
import com.hackathon.exception.TimeSheetNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TimeSheetServiceImplTest {

    @Mock
    private TimeSheetRepository timeSheetRepository;

    @InjectMocks
    private TimeSheetServiceImpl timeSheetService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void submitTimeSheet_shouldSaveAndReturnTimeSheet() {
        // Positive scenario
        TimeSheetSubmitDto dto = new TimeSheetSubmitDto();
        dto.setContractorId(1);
        dto.setWeekStartTime(LocalDateTime.now());

        TimeSheet saved = new TimeSheet();
        saved.setContractorId(1);
        saved.setWeekStartTime(dto.getWeekStartTime());
        saved.setStatus(Status.PENDING);
        saved.setManagerComments("");

        when(timeSheetRepository.save(any(TimeSheet.class))).thenReturn(saved);

        TimeSheet result = timeSheetService.submitTimeSheet(dto);
        assertNotNull(result);
        assertEquals(Status.PENDING, result.getStatus());
        assertEquals(1, result.getContractorId());
        verify(timeSheetRepository, times(1)).save(any(TimeSheet.class));
    }

    @Test
    void managerRespondToTimeSheet_shouldUpdateStatusAndComments() {
        // Positive scenario: manager approves a timesheet
        ManagerTimeSheetResponseDto dto = new ManagerTimeSheetResponseDto();
        dto.setTimeSheetId(10);
        dto.setStatus(Status.APPROVED);
        dto.setManagerComments("Approved");

        TimeSheet existing = new TimeSheet();
        existing.setTimeSheetId(10);
        existing.setStatus(Status.PENDING);
        existing.setManagerComments("");

        when(timeSheetRepository.findById(10)).thenReturn(Optional.of(existing));
        when(timeSheetRepository.save(any(TimeSheet.class))).thenReturn(existing);

        TimeSheet result = timeSheetService.managerRespondToTimeSheet(dto);
        assertNotNull(result);
        assertEquals(Status.APPROVED, result.getStatus());
        assertEquals("Approved", result.getManagerComments());
        verify(timeSheetRepository, times(1)).findById(10);
        verify(timeSheetRepository, times(1)).save(existing);
    }

    @Test
    void managerRespondToTimeSheet_shouldThrowIfNotFound() {
        // Negative scenario: timesheet not found
        ManagerTimeSheetResponseDto dto = new ManagerTimeSheetResponseDto();
        dto.setTimeSheetId(99);
        dto.setStatus(Status.REJECTED);
        dto.setManagerComments("Not found");

        when(timeSheetRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(TimeSheetNotFoundException.class, () -> timeSheetService.managerRespondToTimeSheet(dto));
        verify(timeSheetRepository, times(1)).findById(99);
        verify(timeSheetRepository, never()).save(any());
    }
}
