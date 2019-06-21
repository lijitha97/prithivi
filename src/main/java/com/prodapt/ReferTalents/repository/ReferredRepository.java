package com.prodapt.ReferTalents.repository;


import java.sql.Date;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.model.RtReferredJobDetails;
import com.prodapt.ReferTalents.model.RtSavedJobDetails;





@Repository
public interface ReferredRepository extends JpaRepository<RtReferredJobDetails, Integer> {

	List<RtReferredJobDetails> findByRjEmployeeCode(Integer rjEmployeeCode);
//	RtReferredJobDetails findByRjNameAndRjEmailAndRtPositionCode(String rjName, String rjEmail,String rtPositionCode);
	List<RtReferredJobDetails> findByRtPositionCode(String rtPositionCode);
	List<RtReferredJobDetails> findByRjEmployeeCodeAndRtPositionCode(Integer rjEmployeeCode,String rtPositionCode );
	RtReferredJobDetails findByRjNameAndRjEmailAndRtPositionCode(String rjName, String rjEmail,String rtPositionCode);
	RtReferredJobDetails findByRjNameOrRjEmail(String rjName, String rjEmail);
	RtReferredJobDetails findByRjNameAndRjDobAndRjEmailAndRtPositionCode(String rjName,Date rjDob,String rjEmail,String rtPositionCode);
	RtReferredJobDetails findByRjEmail(String rjEmail);
	
	
	@Query(value="select distinct rt_position_code,(select count(*) from `rt_referred_job_details`  t where `rj_status`='new' And t.rt_position_Code = j.rt_position_code And rj_employee_code= rj_employee_code ) as newreferral  from rt_referred_job_details j" ,nativeQuery=true ) 
	List<Object[]> findByCount(String rjStatus,Integer rjEmployeeCode);	
	
	@Query(value=" Select jd_position_code,(SELECT COUNT(*)  FROM `rt_referred_job_details` t where `rj_status`='new'  And t.rt_position_Code = j.jd_position_code) as newReferrals from rt_job_details j ",nativeQuery=true)
	List<Object[]> findByHrCount(String rjStatus);
	

	@Query(value=" Select jd_position_code,(SELECT COUNT(*)  FROM `rt_referred_job_details` t where `rj_status`  NOT IN ('new') And t.rt_position_Code = j.jd_position_code) as OldReferred from rt_job_details j",nativeQuery=true)
	List<Object[]> findByHrCountreferred(String rjStatus);
	
	@Query(value="select distinct rt_position_code,(select count(*) from `rt_referred_job_details`  t where `rj_status`NOT IN ('new') And t.rt_position_Code = j.rt_position_code And rj_employee_code=rj_employee_code) as newreferral  from rt_referred_job_details j" ,nativeQuery=true ) 
	List<Object[]> findByRefCount(String rjStatus,Integer rjEmployeeCode);	
	
		
}

