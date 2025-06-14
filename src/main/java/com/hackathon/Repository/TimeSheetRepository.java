package com.hackathon.Repository;

import com.hackathon.entities.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
}
