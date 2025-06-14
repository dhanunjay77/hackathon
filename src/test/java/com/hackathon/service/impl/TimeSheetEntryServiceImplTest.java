package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetEntryRepository;
import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TimeSheetEntryServiceImplTest {

    @Mock
    private TimeSheetEntryRepository timeSheetEntryRepository;

    @InjectMocks
    private TimeSheetEntryServiceImpl timeSheetEntryService;

    private TimeSheetEntryDto validDto;
    private TimeSheetEntry savedEntry;

    @BeforeEach
    void setUp() {
        validDto = new TimeSheetEntryDto();
//        validDto.setContractorId(1);
        validDto.setProjectId(2);
        validDto.setActivityId(3);
        validDto.setHoursWorked(8.0);
        validDto.setComments("Worked on feature X");

        savedEntry = new TimeSheetEntry();
        savedEntry.setEntryId(100);
//        savedEntry.setContractorId(1);
        savedEntry.setProjectId(2);
        savedEntry.setActivityId(3);
        savedEntry.setHoursWorked(8.0);
        savedEntry.setComments("Worked on feature X");
        savedEntry.setDate(LocalDateTime.now());
    }

    @Test
    void addTimeSheetEntry_shouldSaveAndReturnEntry() {
        // Positive scenario
        when(timeSheetEntryRepository.save(any(TimeSheetEntry.class))).thenReturn(savedEntry);
        TimeSheetEntry result = timeSheetEntryService.addTimeSheetEntry(validDto);
        assertNotNull(result);
        assertEquals(savedEntry.getEntryId(), result.getEntryId());
        assertEquals(savedEntry.getContractorId(), result.getContractorId());
        verify(timeSheetEntryRepository, times(1)).save(any(TimeSheetEntry.class));
    }

    @Test
    void addTimeSheetEntry_shouldThrowExceptionForNullDto() {
        // Negative scenario: null DTO
        assertThrows(NullPointerException.class, () -> timeSheetEntryService.addTimeSheetEntry(null));
    }

    @Test
    void getTimeSheetEntries_shouldReturnList() {
        // Positive scenario
        when(timeSheetEntryRepository.findAll()).thenReturn(Arrays.asList(savedEntry));
        List<TimeSheetEntry> result = timeSheetEntryService.getTimeSheetEntries();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(savedEntry.getEntryId(), result.get(0).getEntryId());
        verify(timeSheetEntryRepository, times(1)).findAll();
    }

    @Test
    void getTimeSheetEntries_shouldReturnEmptyList() {
        // Negative scenario: no entries
        when(timeSheetEntryRepository.findAll()).thenReturn(Collections.emptyList());
        List<TimeSheetEntry> result = timeSheetEntryService.getTimeSheetEntries();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(timeSheetEntryRepository, times(1)).findAll();
    }
}

