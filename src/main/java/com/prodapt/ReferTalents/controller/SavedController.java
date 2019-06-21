package com.prodapt.ReferTalents.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.model.RtSavedJobDetails;
import com.prodapt.ReferTalents.model.Status;
import com.prodapt.ReferTalents.repository.RefTalRepository;
import com.prodapt.ReferTalents.repository.SavedRepository;

@RestController
public class SavedController {
	
	

	@PersistenceContext
	EntityManager entityManager;
	
	
	@Autowired
	SavedRepository savedRepository;
	
	@Autowired
	RefTalRepository refTalRepository;
	
	
//	get all details  and show to saved tab
	
	
	@GetMapping("getempid")
	public List<RtSavedJobDetails> getsaved(@RequestParam Integer sjEmployeeCode){
		return savedRepository.findBySjEmployeeCodeAndSjSaveFlagTrue(sjEmployeeCode);
	}
	
//	check that status
	
	@GetMapping("getstatus")
	public ResponseEntity<Status> getsave(@RequestParam Integer sjEmployeeCode,@RequestParam String jdPositionCode){
		Status status=new Status();
		List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
		  if(!list.isEmpty()&& list.size()>0) 
		  { 
			  status.setStatusCode(200);
			  status.setRtSavedJobDetails(list.get(0));
		  }
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	
//	save details to save table and fetch details from job details
		
	@PostMapping("savejobdetails")
    public RtSavedJobDetails savejdobed(@RequestBody RtSavedJobDetails save) {
           RtJobDetails rtJobDetails = refTalRepository.findByJdPositionCode(save.getPositionCode());
           save.setRtJobDetails(rtJobDetails);
           RtSavedJobDetails returnSave = null;
           if (save.getId() != 0) {
                  RtSavedJobDetails save2 = savedRepository.getOne(save.getId());
                  if (save2.getSjEmployeeCode() != save.getSjEmployeeCode()) {
                        RtSavedJobDetails save3 = new RtSavedJobDetails();
                        save3.setRjStatus(save.getRjStatus());
                        save3.setSjEmployeeCode(save.getSjEmployeeCode());
                        save3.setRtJobDetails(rtJobDetails);
                        save3.setPositionCode(save.getPositionCode());
                        save3.setSjSaveFlag(save.isSjSaveFlag());
                        returnSave = savedRepository.save(save3);
                  } else {
                        returnSave = savedRepository.save(save);
                  }

           } else {
                  returnSave = savedRepository.save(save);
           }
           returnSave.getRtJobDetails().setSaved(save.isSjSaveFlag());

           
           return returnSave;

    }

//	
//	@GetMapping("countsave")
//    public List<RtSavedJobDetails> getcount(@RequestParam Integer sjEmployeeCode) {
//           Query query = entityManager.createNativeQuery("select count(*) from rt_saved_job_details where sj_save_flag=1 and sj_employee_code = '"+sjEmployeeCode+"' ");
//           List<RtSavedJobDetails> rtSavedJobDetails = query.getResultList();
//           return rtSavedJobDetails;
//
//    }

	
	@GetMapping("countsave")
    public List<RtSavedJobDetails> getcount(@RequestParam Integer sjEmployeeCode) {
           Query query = entityManager.createNativeQuery("select count(*) from rt_saved_job_details where sj_save_flag=1 and sj_employee_code = '"+sjEmployeeCode+"' ");
           List<RtSavedJobDetails> rtSavedJobDetails = query.getResultList();
           return rtSavedJobDetails;

    }


	
//	@GetMapping("get")
//	public List<RtSavedJobDetails> getsave(){
//		return savedRepository.findAll();
//	}
//	
//	
//	
//	@PostMapping ("savejob")
//	public RtSavedJobDetails savedjob(@RequestBody RtSavedJobDetails r,@RequestParam Integer id) {
//	RtJobDetails rtJobDetails=refTalRepository.getOne(id);
//	r.setRtJobDetails(rtJobDetails);
//	return savedRepository.save(r);
//		
//	}
//	
//	@GetMapping("saveflag")
//	public List<RtSavedJobDetails> getflag(){
//		return savedRepository.findAll();
//		
//	} 
	
	
	

}
