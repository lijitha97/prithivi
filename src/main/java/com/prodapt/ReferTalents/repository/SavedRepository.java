package com.prodapt.ReferTalents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ReferTalents.model.RtSavedJobDetails;
import com.prodapt.ReferTalents.model.Status;

@Repository
public interface SavedRepository extends JpaRepository<RtSavedJobDetails, Integer>{
	
	List<RtSavedJobDetails> findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(Integer sjEmployeeCode, String jdPositionCode);
	
	List<RtSavedJobDetails> findBySjEmployeeCodeAndSjSaveFlagTrue(Integer sjEmployeeCode);
	List<RtSavedJobDetails> findByRtJobDetails_JdPositionCode(String jdPositionCode);
	List<RtSavedJobDetails> findBySjEmployeeCode(Integer sjEmployeeCode);

	

	
	


}
