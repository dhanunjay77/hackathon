package com.hackathon.service;

import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;

public interface TimeSheetEntryService {
    TimeSheetEntry addTimeSheetEntry(TimeSheetEntryDto entry);
}
