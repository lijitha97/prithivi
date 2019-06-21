package com.prodapt.ReferTalents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.ReferTalents.model.Preferred;
import com.prodapt.ReferTalents.model.Status;
import com.prodapt.ReferTalents.repository.PreferredJobsRepository;

@RestController
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class PreferController {

	
	@Autowired
	PreferredJobsRepository preferredJobsRepository;
	
	
    @GetMapping("checkpreferstatus1")
    public ResponseEntity<Status> getprefer(@RequestParam Integer pjEmployeeCode){
           Status status=new Status();
           List<Preferred> list =preferredJobsRepository.findByPjEmployeeCode(pjEmployeeCode);
           if(!list.isEmpty()&& list.size()>0) {
                  status.setStatusCode(200);
                  status.setPreferred(list.get(0));
           }
           return  new ResponseEntity<Status>(status, HttpStatus.OK);
           
    }
    
    @PostMapping ("querypost1")
    public Preferred jobquery (@RequestBody Preferred save) {
           System.out.println(save.getPjEmployeeCode());
           System.out.println(save.getPjExperience());
           System.out.println(save.getPjLocation());
    return preferredJobsRepository.save(save);
    }
    
    @GetMapping("getdetail")
    public List<Preferred> getdetail(@RequestParam Integer pjEmployeeCode){
           return preferredJobsRepository.findByPjEmployeeCode(pjEmployeeCode);
           
    }



	
}
