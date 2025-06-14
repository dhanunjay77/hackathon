package com.hackathon.service;

import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import java.util.*;

public interface TimeSheetEntryService {
    TimeSheetEntry addTimeSheetEntry(TimeSheetEntryDto entry);
    
    List<TimeSheetEntry> getTimeSheetEntries();
}
