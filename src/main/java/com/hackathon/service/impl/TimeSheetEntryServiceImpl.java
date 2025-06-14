package com.hackathon.service.impl;

import com.hackathon.Repository.TimeSheetEntryRepository;
import com.hackathon.dto.TimeSheetEntryDto;
import com.hackathon.entities.TimeSheetEntry;
import com.hackathon.service.TimeSheetEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSheetEntryServiceImpl implements TimeSheetEntryService {

    @Autowired
    private TimeSheetEntryRepository timeSheetEntryRepository;

    @Override
    public TimeSheetEntry addTimeSheetEntry(TimeSheetEntry entry) {
        return timeSheetEntryRepository.save(entry);
    }
}
