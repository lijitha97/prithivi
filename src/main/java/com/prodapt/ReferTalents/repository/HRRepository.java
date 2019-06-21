package com.prodapt.ReferTalents.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.ReferTalents.model.RtReferredJobDetails;

public interface HRRepository extends JpaRepository<RtReferredJobDetails, Integer> {
	

	List<RtReferredJobDetails> findByRtPositionCodeAndRjEmployeeCode(String rtPositionCode, Integer rjEmployeeCode);

}
