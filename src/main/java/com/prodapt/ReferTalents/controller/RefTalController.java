package com.prodapt.ReferTalents.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.model.RtSavedJobDetails;
import com.prodapt.ReferTalents.model.SortByPositionCode;
import com.prodapt.ReferTalents.model.Status;
import com.prodapt.ReferTalents.repository.RefTalRepository;
import com.prodapt.ReferTalents.repository.SavedRepository;;

//     Controller handles a request from the client.


@RestController
@RequestMapping("/RtJobDetails")
public class RefTalController {

	
	
//	RefTalRepository is injected with the @Autowired annotation
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	RefTalRepository refTalRepository;
//
	@Autowired
	SavedRepository savedRepository;
	//	public RefTalController(RefTalService reftalService) {
//		// TODO Auto-generated constructor stub
//		this.reftalService = reftalService;
//	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public List<RtJobDetails> getAll() {
 
//		It is Get method which returns refTalRepository
		return this.refTalRepository.findAll();
		
	}
	@PostMapping("updateSaved")
	public RtJobDetails updateRtJobDetails(@RequestBody RtJobDetails rtJobDetails)
	{
		return this.refTalRepository.save(rtJobDetails);
	}
	
	@RequestMapping(value = { "/saved", "" }, method = RequestMethod.GET)
	public List<RtJobDetails> getAllRTJobsBasenEmpId(@RequestParam Integer empId) {
 
		List<RtJobDetails> rtJobDetails=refTalRepository.findAll();
		
		List<String> listPostionCodes=rtJobDetails.stream().map(a->a.getJdPositionCode()).collect(Collectors.toList());
		List<RtSavedJobDetails> rtSavedJobDetails=savedRepository.findBySjEmployeeCode(empId);
		for(RtSavedJobDetails rtJobs:rtSavedJobDetails) {
			if(listPostionCodes.contains(rtJobs.getPositionCode())) {
				if(rtJobs.isSjSaveFlag()) {
					rtJobDetails.stream().filter(a->a.getJdPositionCode().equalsIgnoreCase(rtJobs.getPositionCode())).findFirst().get().setSaved(true);
				}
			}
		}
		
		Collections.sort(rtJobDetails,new SortByPositionCode());
//		System.out.println(rtJobDetails.get(arg0));
		return rtJobDetails;

	}
	
	@GetMapping("countlanding")
    public List<RtJobDetails> getcounts() {
           Query query = entityManager.createNativeQuery("select count(*) from rt_job_details");
           List<RtJobDetails> rtJobDetails = query.getResultList();
           return rtJobDetails;
           }


	
//	staticcotent
//	@RequestMapping(value = "/staticcontent/", method = RequestMethod.GET)
//    public Status getstatic() {
//           Status status=new Status();
//           status.setMessages("Different Jobs");
//           status.setStatusCode(200);
//           return status;
//    }

//	@GetMapping("countlanding")
//    public List<RtJobDetails> getcounts() {
//           Query query = entityManager.createNativeQuery("select count(*) from rt_job_details");
//           List<RtJobDetails> rtJobDetails = query.getResultList();
//           return rtJobDetails;
//           }

	
	@GetMapping("logo")
	public List<RtJobDetails> getdate() {
//		Map<String, String> hm =new HashMap<String, String>();
//		ArrayList<Object> rtJobDetailsList = new ArrayList<Object>();
		Query query = entityManager.createNativeQuery("SELECT * FROM rt_job_details where refreshed_date = (select MAX(refreshed_date) from rt_job_details)", RtJobDetails.class);
		
		@SuppressWarnings("unchecked")
		List<RtJobDetails> rtJobDetails = (List<RtJobDetails>) query.getResultList();
		
		  String  jdPostionCodeStr =(String) rtJobDetails.get(0).getJdPositionCode();
		
//        hm.put("jdPositionCode",jdPostionCodeStr);
        
        return rtJobDetails;
	}
	
	@GetMapping("prefered")
    public List<RtJobDetails> getprefered(@RequestParam String skills,@RequestParam String location){
           Query query= entityManager.createNativeQuery("select * from `refertalents`.rt_job_details   where  jd_skills like '%"+skills+"%' or jd_work_location like '%"+location+"%'",RtJobDetails.class);
           List<RtJobDetails> rtJobDetails = query.getResultList();
           return rtJobDetails;
    }


}

	