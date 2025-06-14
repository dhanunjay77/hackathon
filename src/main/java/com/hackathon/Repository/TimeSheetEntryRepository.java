package com.hackathon.Repository;

import com.hackathon.entities.TimeSheetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetEntryRepository extends JpaRepository<TimeSheetEntry, Integer> {

}
