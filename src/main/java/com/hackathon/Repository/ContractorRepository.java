package com.hackathon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.entities.Contractor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer> {

}
