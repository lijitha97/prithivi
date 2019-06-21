package com.prodapt.ReferTalents.controller;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.ReferTalents.dto.PreferredDTO;
import com.prodapt.ReferTalents.model.Job;
import com.prodapt.ReferTalents.model.RtPreference;
import com.prodapt.ReferTalents.model.Status;
import com.prodapt.ReferTalents.repository.PreferenceRepository;
import com.prodapt.ReferTalents.repository.RefTalRepository;
import com.prodapt.ReferTalents.service.ServiceApi;


@RestController
@CrossOrigin("*")
@RequestMapping("/RtPreference")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class preferenceController {
	
	
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired 
    RefTalRepository refTalRepository;

	@Autowired
	PreferenceRepository preferenceRepository;
    
	// TODO Auto-generated constructor stub
	@Autowired
	ServiceApi serviceApi;

	public preferenceController(ServiceApi serviceApi) {
		// TODO Auto-generated constructor stub
		this.serviceApi = serviceApi;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public List<RtPreference> getDetails(@RequestParam Integer code)
	
	{

	       Query query = entityManager.createNativeQuery(
	       "select * from rt_preferred_job_details where pj_employee_code='"+code+ "'",RtPreference.class);
	         
	         List<RtPreference> rtPreferredJobDetails = query.getResultList(); 
	         return  rtPreferredJobDetails; 
	}
	
	
	
    @GetMapping("checkpreferstatus")
    public ResponseEntity<Status> getprefer(@RequestParam Integer pjEmployeeCode){
           Status status=new Status();
           List<RtPreference> list =preferenceRepository.findByPjEmployeeCode(pjEmployeeCode);
           if(!list.isEmpty()&& list.size()>0) {
                  status.setStatusCode(200);
                  status.setRtPreference(list.get(0));
           }
           return  new ResponseEntity<Status>(status, HttpStatus.OK);
           
    }

	



    @GetMapping("fgh")
    public List<RtPreference> ghgh(@RequestParam Integer pjEmployeeCode){
           return preferenceRepository.findByPjEmployeeCode(pjEmployeeCode);
           
    }
    @PostMapping("querypost")
    public RtPreference topic(@RequestBody RtPreference save) {
		return preferenceRepository.save(save);
    	
    }


//    @PostMapping ("querypost")
//    public  List<RtPreference> tprefer(@RequestBody RtPreference save) {
//           System.out.println(save.getPjEmployeeCode());
//           System.out.println(save.getPjExperience());
//           System.out.println(save.getPjLocation());
//    return preferenceRepository.save(save);
//    }

	
	
	@PostMapping("save")
	public RtPreference savePreference(@RequestBody RtPreference rtPreferredJobDetails) {
		return serviceApi.save(rtPreferredJobDetails);
	}
	
}
