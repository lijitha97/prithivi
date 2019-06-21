package com.prodapt.ReferTalents.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ReferTalents.model.HRJobDetails;
import com.prodapt.ReferTalents.model.HRReferredJobDetails;
import com.prodapt.ReferTalents.model.Job;
import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.model.RtReferredJobDetails;
import com.prodapt.ReferTalents.repository.RefTalRepository;
import com.prodapt.ReferTalents.repository.ReferredRepository;

@RestController

@RequestMapping("/HR")
public class HRController {

	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	ReferredRepository referredRepository;
	@Autowired
	RefTalRepository refTalRepository;

	



//
//	@PostMapping("rtreferredjobdetails")
//	public RtReferredJobDetails refer(@RequestBody RtReferredJobDetails r,@RequestParam Integer id) {
//		RtJobDetails rtjobdetails=refTalRepository.getOne(id);
//		r.setRtjobdetails(rtjobdetails);
//		return referredRepository.save(r);
//	
//	}
//	
//	
//	
//	@GetMapping("getreferred")
//	public List<RtReferredJobDetails> getreferred(@RequestParam Integer rjEmployeeCode,@RequestParam String rtJobDetailsJdPositionCode)
//	{
//	return referredRepository.findByRjEmployeeCodeAndRtJobDetails_JdPositionCode(rjEmployeeCode, rtJobDetailsJdPositionCode);
//	}	

//@RequestMapping(value="/getreffered")
//public List<Job> getDetails(@RequestParam Integer code)
//{
//
//	System.out.println("select DISTINCT * from `refertalents`.`rt_job_details`,`refertalents`.`rt_referred_job_details` where rt_job_details.id = rt_referred_job_details.rt_job_details_id and rt_referred_job_details.rj_employee_code='"+code+"'");
//	  Query query = entityManager.createNativeQuery(
//	"select DISTINCT * from `refertalents`.`rt_job_details`,`refertalents`.`rt_referred_job_details` where rt_job_details.id = rt_referred_job_details.rt_job_details_id and rt_referred_job_details.rj_employee_code='"+code+"'",RtReferredJobDetails.class);
//	  
//	  
//	  
//	  List<Job> job = query.getResultList(); 
//	  return  job; 
//}



//
//
//@PostMapping("Hrrtreferredjobdetails")
//public RtReferredJobDetails refer(@RequestBody RtReferredJobDetails r) {
//	RtJobDetails rtjobdetails=refTalRepository.findByJdPositionCode(r.getRtPositionCode());
//	r.setRtjobdetails(rtjobdetails);
//	return referredRepository.save(r);
//
//}
//
//@PostMapping("validatedusers")
//public Boolean validatedRefererUsr(@RequestBody RtReferredJobDetails r) {
//	RtReferredJobDetails rtjobdetails=referredRepository.findByRjNameAndRjEmail(r.getRjName(),r.getRjEmail());
//	boolean statusmsg = false;
//	if(rtjobdetails!=null) {
//		statusmsg=true;
//		return statusmsg;
//	}else {
//		return statusmsg;
//	}
//	
////	return statusmsg;
//}


@GetMapping("getposition")
public List<RtReferredJobDetails> getreferred(@RequestParam String rtPositionCode)
{
return referredRepository.findByRtPositionCode( rtPositionCode);
}	

@GetMapping("get")
public List<RtReferredJobDetails> getreferred()
{
return referredRepository.findAll();
}

//Query for newReferrals and Referred



//@RequestMapping(value="/getnewjobs")
//public List<HRJobDetails> getDetails()
//{  
//    Query query = entityManager.createNativeQuery(
//   "Select id,jd_position_title,jd_business_unit,jd_delivery_centre,jd_position_creation_date,jd_experience,jd_education,jd_skills,jd_designation,jd_job_responsibilities,jd_work_location,jd_position_code,(SELECT COUNT(*)  FROM `rt_referred_job_details` t where `rj_status`='new'  And t.rt_position_Code = j.jd_position_code) as newReferrals,(SELECT COUNT(*)  FROM `rt_referred_job_details` t where `rj_status`  NOT IN ('new') And t.rt_position_Code = j.jd_position_code) as OldReferred from rt_job_details j",HRJobDetails.class);
//         
//         List<HRJobDetails> job = query.getResultList(); 
//         return  job; 
//}


@RequestMapping(value="/getnewjobs")
public List<RtJobDetails> getAlljob() {
	 
//	It is Get method which returns refTalRepository
	return refTalRepository.findAll();
	
}


@RequestMapping(value="/geta")
public List<HRReferredJobDetails> geDetails()

{  
    Query query = entityManager.createNativeQuery(
   "SELECT COUNT(*)  as newReferrals FROM `rt_referred_job_details` t, `rt_job_details` j where `rj_status`='new'  And t.rt_position_Code = j.jd_position_code",HRReferredJobDetails.class);
         
         List<HRReferredJobDetails> joba = query.getResultList(); 
         return  joba; 
}





//@GetMapping("getjobs")
//public List<RtJobDetails> getAll() {
//	 
////	It is Get method which returns refTalRepository
//	return this.refTalRepository.findAll();
//
//}

//@GetMapping("logo")
//public List<RtJobDetails> getdate() {
////	Map<String, String> hm =new HashMap<String, String>();
////	ArrayList<Object> rtJobDetailsList = new ArrayList<Object>();
//	Query query = entityManager.createNativeQuery("SELECT * FROM rt_job_details where refreshed_date = (select MAX(refreshed_date) from rt_job_details)", RtJobDetails.class);
//	
//	@SuppressWarnings("unchecked")
//	List<RtJobDetails> rtJobDetails = (List<RtJobDetails>) query.getResultList();
//	
//	  String  jdPostionCodeStr =(String) rtJobDetails.get(0).getJdPositionCode();
//	
////    hm.put("jdPositionCode",jdPostionCodeStr);
//    
//    return rtJobDetails;
//}

@RequestMapping(value="/get-file")
public List<RtReferredJobDetails> getfile(Integer rjEmployeeCode, String rtPositionCode)
{  
//     "rt_position_code-"+rtPositionCode... and rt_position_code='" +rtPositionCode+ "'
System.out.println("rj_employee_code-"+rjEmployeeCode+ "rt_position_code-"+rtPositionCode );
	Query query = entityManager.createNativeQuery( 
   "select rj_file from rt_referred_job_details where rj_employee_code='" +rjEmployeeCode+ "' And rt_position_code='" +rtPositionCode+ "'");
     
	List<RtReferredJobDetails> job = query.getResultList();
	  System.out.println(job);
         return  job; 
}

@Transactional
@RequestMapping("StatusChange")
public int RtReferredJobDetails(@RequestParam String status,int id,String comment)
{  
    Query query = entityManager.createNativeQuery(
   "UPDATE `rt_referred_job_details` SET `rj_status` = '" + status + "',rj_commend='"+comment+"'  WHERE id= '" + id + "'",  RtReferredJobDetails.class);
         
         int statuschange = query.executeUpdate(); 
         return  statuschange; 
}


//@GetMapping("getCounts")
//    public List<RtReferredJobDetails> getCountNewReferrals(){
//    	return this.referredRepository.getCountNewReferrals();
//    }

@GetMapping("hrCount")
public List<Object[]> getcount(@RequestParam String rjStatus){
	return referredRepository.findByHrCount(rjStatus);
	
}

@GetMapping("hrrefCount")
public List<Object[]> getrefcount(@RequestParam String rjStatus){
	return referredRepository.findByHrCountreferred(rjStatus);



}
}

