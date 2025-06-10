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
	
	@Query("SELECT e FROM EventImageDetails e WHERE e.id IN ("
			+ "SELECT MIN(e2.id) FROM EventImageDetails e2 WHERE e2.status = :status GROUP BY e2.caseId)")
	List<EventImageDetails> findOneRecordPerCaseIdByStatus(@Param("status") CaseStatus status);
		
	
	//following Method is reponsible to get evenetImageDetails By Using CaseId and Status
	List<EventImageDetails> findByCaseIdAndStatus(String caseId, CaseStatus status);

	/*BASICALLY 
	 * ALL THE FOLLOWING METHODS WE BUILD FOR POLICESTATION CONSOLE BASE
	 * 
	   These Method is reponsible get one of each case based on status and policestationId....
	*/
	@Query("SELECT e FROM EventImageDetails e WHERE e.imageId IN (" +
		       "SELECT MIN(e2.imageId) FROM EventImageDetails e2 " +
		       "WHERE e2.status = :status AND e2.policeStationDataMaster.policeStation_Id = :policeId " +
		       "GROUP BY e2.caseId)")
		List<EventImageDetails> findOneImagePerCaseByStatusAndPolice(
		    @Param("status") CaseStatus status,
		    @Param("policeId") Long policeId);

		/*
		 These Following queries are used to get all the count of cases using status and police id
		
		*/
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e " +
		       "WHERE e.status = 'UNRESOLVED' AND e.policeStationDataMaster.policeStation_Id = :policeId")
		Long countUnresolvedCasesByPoliceId(@Param("policeId") Long policeId);
	
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e " +
		       "WHERE e.status = 'RESOLVED' AND e.policeStationDataMaster.policeStation_Id = :policeId")
		Long countResolvedCasesByPoliceId(@Param("policeId") Long policeId);
	
	@Query("SELECT COUNT(DISTINCT e.caseId) FROM EventImageDetails e " +
		       "WHERE e.status = 'IN_PROGRESS' AND e.policeStationDataMaster.policeStation_Id = :policeId")
		Long countInProgressCasesByPoliceId(@Param("policeId") Long policeId);
	
	
	/*
	These Method is responsible to get all EventImage Details Using CaseId
	*/
	List<EventImageDetails> findByCaseId(String caseId);
	

}
