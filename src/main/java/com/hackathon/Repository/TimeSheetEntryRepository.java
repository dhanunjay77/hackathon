package com.hackathon.Repository;

import com.hackathon.entities.TimeSheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TimeSheetEntryRepository extends JpaRepository<TimeSheetEntry, Integer> {
    List<TimeSheetEntry> findByContractorIdAndProjectIdAndDateBetween(int contractorId, int projectId, LocalDateTime start, LocalDateTime end);
}
