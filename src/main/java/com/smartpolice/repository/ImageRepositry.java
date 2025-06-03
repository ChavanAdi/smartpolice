package com.smartpolice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smartpolice.constants.CaseStatus;
import com.smartpolice.entity.EventImageDetails;

@Repository
public interface ImageRepositry extends JpaRepository<EventImageDetails, Long>{
	
	List<EventImageDetails> findByStatus(CaseStatus status);

	/*
	All These Following Methods is Responsible Getting Count Based on CaseId and Status
	
	*/
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e WHERE e.status = 'UNRESOLVED'")
	 long allUnResolvedCasesCount();
	
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e WHERE e.status = 'RESOLVED'")
	 long allResolvedCasesCount();
	
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e WHERE e.status = 'IN_PROGRESS'")
	 long allInProgressCasesCount();
	
	/*	
	 * 
		These query is responsible to get All Case Details Based on Status and they fetch only one Case with same caseid 
		suppose i have 20 entries for one case that time they give only one object or first f them
	*/
	
	@Query("SELECT e FROM EventImageDetails e WHERE e.id IN (" +
		       "SELECT MIN(e2.id) FROM EventImageDetails e2 WHERE e2.status = :status GROUP BY e2.caseId)")
		List<EventImageDetails> findOneRecordPerCaseIdByStatus(@Param("status") CaseStatus status);

}
