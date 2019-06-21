package com.prodapt.ReferTalents.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.ReferTalents.model.Job;
import com.prodapt.ReferTalents.model.Preferred;
import com.prodapt.ReferTalents.model.RtJobDetails;
//import com.prodapt.ReferTalents.repository.JobRepository;
//import com.prodapt.ReferTalents.repository.PreferredJobsRepository;
import com.prodapt.ReferTalents.repository.RefTalRepository;



@RestController

public class JobController {


	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	RefTalRepository refTalRepository;
//	
//	@Autowired
//	JobRepository jobRepository;
//	
	
//	@PostMapping("job")
//	public Job job(@RequestBody Job job) {
//		return jobRepository.save(job);
//	}
//	
//	@PostMapping("preferredJob")
//	public Preferred savePreferred(@RequestBody Preferred preferred,@RequestParam Integer id) {
//	
//	    BookCategory bookCategory=new BookCategory();
//	    bookCategory.setName("test");
//		
//		Job job=jobRepository.getOne(id);
//		preferred.setJob(job);
//		return preferredJobsRepository.save(preferred);
//	
//	}
	
//	@GetMapping("getAll")
//	public List<Job> getPreferred() {
//		return jobRepository.findAll();
//	}
//	
//	@GetMapping("getAllPreferred")
//	public List<Preferred> getAllPreferred() {
//		return preferredJobsRepository.findAll();
//	}

	
//@RequestMapping(value="/abc")
//public List<Job> getDetails()
//{
//
//	  Query query = entityManager.createNativeQuery(
//	  
//	  "select DISTINCT id,jd_position_title,jd_business_unit,jd_delivery_centre,jd_position_creation_date,jd_education,jd_experience,jd_designation,jd_work_location,jd_job_responsibilities,jd_skills,jd_position_code from `refertalents`.`rt_job_details`,`refertalents`.`rt_preferred_job_details` where rt_job_details.jd_skills = rt_preferred_job_details.pj_skills Or rt_job_details.jd_experience=rt_preferred_job_details.pj_experience"
//	  , Job.class);
//	  
//	  List<Job> job = query.getResultList(); 
//	  return  job; 
//}
	 
//	  Q1)What is a query?
//	   A)A query is a request for information from a database

//    Q2)Why a query is used?
//     A)Because in the model class the tables are just mapped together,but to get the consolidated data 
//        from both the tables a query is used.
//        Here a query is written to get data from rt_job_details_table based on matching skills for 
//   	  the particular employee code
//      
//	  Q3)How writting a query displays output data in the front end.
//	   A)1)EntityManager is a JPA interface
//	     2)JPA standardizes support for queries using both the Java Persistence Query Language (JPQL) 
//	       and the Structured Query Language (SQL). You obtain Query instances from an EntityManager.
//       3)A query is created and stored inside job list and then the job is returned    	
//	
	@RequestMapping(value="/abc")
	public List<Job> getDetails(@RequestParam Integer code)
	{  
        Query query = entityManager.createNativeQuery(
	   "select DISTINCT `rt_job_details`.id,jd_position_title,jd_business_unit,jd_delivery_centre,jd_position_creation_date,jd_education,jd_experience,jd_designation,jd_work_location,jd_job_responsibilities,jd_skills,jd_position_code from `refertalents`.`rt_job_details`,`refertalents`.`rt_preferred_job_details` where rt_job_details.jd_skills = rt_preferred_job_details.pj_skills and rt_preferred_job_details.pj_employee_code='"+code+"'",Job.class);
	         
	         List<Job> job = query.getResultList(); 
	         return  job; 
	}
	
	@GetMapping(value="/jobs")
    public List<RtJobDetails> getjobsDetails(@RequestParam Integer code,@RequestParam String skills,@RequestParam String location,@RequestParam String experience)
    {  
           List<String> jdList = new ArrayList<String>();
           jdList.add(skills);
           jdList.add(location);
           jdList.add(experience);
           System.out.println("List of job details :"+jdList.get(0)); 
           if(jdList.get(1)==""&& jdList.get(2)=="") {
                  return refTalRepository.findAll().stream().filter(data->data.getJdSkills().toLowerCase().contains(jdList.get(0).toLowerCase())).collect(Collectors.toList());
           }
           else if(jdList.get(0)==""&& jdList.get(2)=="") {
                  return refTalRepository.findAll().stream().filter(data->data.getJdWorkLocation().toLowerCase().contains(jdList.get(1).toLowerCase())).collect(Collectors.toList());
           }
           else if(jdList.get(0)==""&& jdList.get(1)=="") {
                  return refTalRepository.findAll().stream().filter(data->data.getJdExperience().toLowerCase().contains(jdList.get(2).toLowerCase())).collect(Collectors.toList());
           }
          
           else if(jdList.get(0)=="" ) {
                  return refTalRepository.findAll().stream().filter(data->data.getJdWorkLocation().toLowerCase().contains(jdList.get(1).toLowerCase()) || data.getJdExperience().toLowerCase().contains(jdList.get(2).toLowerCase())).collect(Collectors.toList());
           }
           else if(jdList.get(1)=="") {
                  return refTalRepository.findAll().stream().filter(data->data.getJdSkills().toLowerCase().contains(jdList.get(0).toLowerCase()) || data.getJdExperience().toLowerCase().contains(jdList.get(2).toLowerCase())).collect(Collectors.toList());
           }
           else if(jdList.get(2)=="") {
                  return refTalRepository.findAll().stream().filter(data->data.getJdSkills().toLowerCase().contains(jdList.get(0).toLowerCase()) || data.getJdWorkLocation().toLowerCase().contains(jdList.get(1).toLowerCase())).collect(Collectors.toList());
           }
           else if(jdList.get(0)=="" &&jdList.get(1)==""&&jdList.get(2)=="") {
               return null;
        }
           else {
                  return refTalRepository.findAll().stream().filter(data->data.getJdSkills().toLowerCase().contains(jdList.get(0).toLowerCase()) || data.getJdWorkLocation().toLowerCase().contains(jdList.get(1).toLowerCase())||data.getJdExperience().contains(jdList.get(2))).collect(Collectors.toList());
                  }
    
         }
	
	
	@GetMapping("/getdetailsdert")
    public Set<RtJobDetails> getdetails(@RequestParam Integer code,  @RequestParam String skills, @RequestParam String location,@RequestParam String experience) {
           Set<RtJobDetails> liJobDetails = new HashSet<RtJobDetails>();
           
           List<String> jdList = new ArrayList<String>();
           jdList.add(skills.trim().isEmpty()?"null":skills);
           jdList.add(location.trim().isEmpty()?"null":location);
           jdList.add(experience.trim().isEmpty()?"null":experience);
           
           
                  String[] listOfSkills = jdList.get(0).split(",");
                  for (String skill : listOfSkills) {
                        liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill.trim()));
                  }

                  String[] listLocations = jdList.get(1).split(",");
                  for (String loc : listLocations) {
                        liJobDetails.addAll(refTalRepository.findByJdWorkLocationContaining(loc.trim()));
                  }
                  
                  String[] listExpriences = jdList.get(2).split(",");
                  for (String exepri : listExpriences) {
                        liJobDetails.addAll(refTalRepository.findByJdExperienceContaining(exepri.trim()));
                  }
                  
                  return liJobDetails;
           

           
    }


	
//	@GetMapping("/getdetailsdert")
//    public Set<RtJobDetails> getdetails(@RequestParam Integer code,  @RequestParam String skills, @RequestParam String location,@RequestParam String experience) {
//           Set<RtJobDetails> liJobDetails = new HashSet<RtJobDetails>();
//           
//           List<String> jdList = new ArrayList<String>();
//           jdList.add(skills);
//           jdList.add(location);
//           jdList.add(experience);
//           if(jdList.get(1)==""&& jdList.get(2)=="") {
//                  String[] listOfSkills = jdList.get(0).split(",");
//                  for (String skill : listOfSkills) {
//                  liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill));
//                  }}
//           else if(jdList.get(0)==""&& jdList.get(2)=="") {
//                        String[] listLocations = jdList.get(1).split(",");
//                        for (String loc : listLocations) {
//                               liJobDetails.addAll(refTalRepository.findByJdWorkLocationContaining(loc));
//                        }
//                  }
//           else if(jdList.get(0)==""&& jdList.get(1)=="") {
//                  String[] listExpriences = jdList.get(2).split(",");
//                  for (String exepri : listExpriences) {
//                        liJobDetails.addAll(refTalRepository.findByJdExperienceContaining(exepri));
//                  }
//           }
//           else if(jdList.get(0)=="") {
//                  String[] listOfSkills = jdList.get(0).split(",");
//                  for (String skill : listOfSkills) {
//                        liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill));
//                  }
//
//                  String[] listLocations = jdList.get(1).split(",");
//                  for (String loc : listLocations) {
//                        liJobDetails.addAll(refTalRepository.findByJdWorkLocationContaining(loc));
//                  }
//           }
//           else if(jdList.get(1)=="") {
//                  String[] listOfSkills = jdList.get(0).split(",");
//                  for (String skill : listOfSkills) {
//                        liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill));
//                  }
//                  String[] listExpriences = jdList.get(2).split(",");
//                  for (String exepri : listExpriences) {
//                        liJobDetails.addAll(refTalRepository.findByJdExperienceContaining(exepri));
//                  }
//           }
//           else if(jdList.get(2)=="") {
//                  String[] listOfSkills = jdList.get(0).split(",");
//                  for (String skill : listOfSkills) {
//                        liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill));
//                  }
//
//                  String[] listLocations = jdList.get(1).split(",");
//                  for (String loc : listLocations) {
//                        liJobDetails.addAll(refTalRepository.findByJdWorkLocationContaining(loc));
//                  }
//           }
//           
//           else {
//                  String[] listOfSkills = jdList.get(0).split(",");
//                  for (String skill : listOfSkills) {
//                        liJobDetails.addAll(refTalRepository.findByJdSkillsContaining(skill));
//                  }
//
//                  String[] listLocations = jdList.get(1).split(",");
//                  for (String loc : listLocations) {
//                        liJobDetails.addAll(refTalRepository.findByJdWorkLocationContaining(loc));
//                  }
//                  
//                  String[] listExpriences = jdList.get(2).split(",");
//                  for (String exepri : listExpriences) {
//                        liJobDetails.addAll(refTalRepository.findByJdExperienceContaining(exepri));
//                  }
//           }
//           
//           
//
//           return liJobDetails;
//    }
//
//	
	@GetMapping("/nippon")
	public List<RtJobDetails> fgt(@RequestParam Integer code,@RequestParam String skills,@RequestParam String location){
		
		 List<String> jdList = new ArrayList<String>();
         jdList.add(skills);
         jdList.add(location);
        
		return refTalRepository.findAll().stream().filter(data->data.getJdSkills().toLowerCase().contains(jdList.get(0).toLowerCase()) || data.getJdWorkLocation().toLowerCase().contains(jdList.get(1).toLowerCase())).collect(Collectors.toList());
		
	}






}


