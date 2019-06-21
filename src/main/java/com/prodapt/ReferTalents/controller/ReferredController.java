package com.prodapt.ReferTalents.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prodapt.ReferTalents.dto.ReferredDTO;
import com.prodapt.ReferTalents.model.Job;
import com.prodapt.ReferTalents.model.Referered;
import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.model.RtReferredJobDetails;
import com.prodapt.ReferTalents.model.RtSavedJobDetails;
import com.prodapt.ReferTalents.model.Status;
import com.prodapt.ReferTalents.repository.RefTalRepository;
import com.prodapt.ReferTalents.repository.ReferredRepository;

import ch.qos.logback.classic.Logger;

//import static com.prodapt.ReferTalents.utils.ApplicationUtil.REFERRAL_STATUS;

@RestController

@RequestMapping("/RtReferredJobDetails")

public class ReferredController {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	ReferredRepository referredRepository;
	
	@Autowired
	RefTalRepository refTalRepository;

	@PostMapping("rtreferredjobdetails")
	public RtReferredJobDetails refer(@RequestBody RtReferredJobDetails r) {
		RtJobDetails rtjobdetails = refTalRepository.findByJdPositionCode(r.getRtPositionCode());
		r.setRtJobDetails(rtjobdetails);
		return referredRepository.save(r);
	}

//@PostMapping("validatedusers")
//public Boolean validatedRefererUsr(@RequestBody RtReferredJobDetails r) {
//	RtReferredJobDetails rtjobdetails=referredRepository.findByRjNameAndRjDobAndRjEmailAndRtPositionCode(r.getRjName(), r.getRjDob(), r.getRjEmail(),r.getRtPositionCode());
//	boolean statusmsg = false;
//	
//	if(rtjobdetails!=null){
//		statusmsg=true;
//		return statusmsg;
//	}
//	
//	return statusmsg;
//	
//}
//	
	@GetMapping("employeename")
	public List<RtReferredJobDetails> getemployeename(@RequestParam String rjEmail, @RequestParam String rjName,
			@RequestParam String rtPositionCode, @RequestParam Date rjDob) {
		Query query = entityManager.createNativeQuery(
				"select  rj_employee_name  from rt_referred_job_details where rj_email='" + rjEmail + "' and rj_name= '"
						+ rjName + "'and rt_position_code='" + rtPositionCode + "' and rj_dob='" + rjDob + "'");
		List<RtReferredJobDetails> rtReferredJobDetails = query.getResultList();
		return rtReferredJobDetails;

	}

	@GetMapping("getreferred")
	public List<RtReferredJobDetails> getreferred(@RequestParam Integer rjEmployeeCode) {
		return referredRepository.findByRjEmployeeCode(rjEmployeeCode);
	}

//staticmessage
//@RequestMapping(value = "/staticcontent/", method = RequestMethod.GET)
//public Status getstatic() {
//       Status status=new Status();
//       status.setMessages("Referred Jobs");
//       status.setStatusCode(200);
//       return status;
//}
	
	@Autowired 
	private Environment env;
	
//	@PostMapping("notification")
//	public ResponseEntity<Void> sendNotification(@RequestParam String status, @RequestParam Integer referralCode) {
//		REFERRAL_STATUS rs = REFERRAL_STATUS.valueOf(status.toUpperCase());
//		for (REFERRAL_STATUS s: REFERRAL_STATUS.values()) {
//			switch (rs) {
//			case ACCEPTED:
//				String m = env.getProperty("accepted");
//				m = m.replace("@###@", "ABC");
//				System.out.println("ACCEPTED"); 
//				break;
//			}
//		}
//		return null;
//	}

//upload via fileSystem.
	@RequestMapping(value = "/uploads", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("/home/ubuntu/Desktop/refertalentsFiles/files/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();

		return new ResponseEntity<>("File uploaded Succesfuflly", HttpStatus.OK);
	}

	@GetMapping("getreferredAll")
	public List<RtJobDetails> getreferredAll(@RequestParam Integer empid) {

		List<RtJobDetails> returnList = new ArrayList<RtJobDetails>();
		List<RtReferredJobDetails> list = referredRepository.findByRjEmployeeCode(empid);
		Set<String> listPostionCodes = list.stream().map(a -> a.getRtPositionCode()).collect(Collectors.toSet());
		HashMap<String, RtJobDetails> map = new HashMap<String, RtJobDetails>();
		for (String positionCode : listPostionCodes) {

			ArrayList<Referered> reArrayList = new ArrayList<Referered>();

			for (RtReferredJobDetails rtReferredJobDetails : list) {

				if (!map.containsKey(positionCode)) {
					map.put(positionCode, refTalRepository.findByJdPositionCode(positionCode));

				}
				if (rtReferredJobDetails.getRtPositionCode().contains(positionCode)) {
					Referered referered = new Referered();
					referered.setId(rtReferredJobDetails.getId());
					referered.setRjDob(rtReferredJobDetails.getRjDob());
					referered.setRjEmail(rtReferredJobDetails.getRjEmail());
					referered.setRjEmployeeCode(rtReferredJobDetails.getRjEmployeeCode());
					referered.setRjEmployeeName(rtReferredJobDetails.getRjEmployeeName());
					referered.setRjName(rtReferredJobDetails.getRjName());
					referered.setRjReferredFlag(rtReferredJobDetails.isRjReferredFlag());
					referered.setRtPositionCode(rtReferredJobDetails.getRtPositionCode());
					referered.setRtStatus(rtReferredJobDetails.getRjStatus());
					referered.setRjEmployeeMail(rtReferredJobDetails.getRjEmployeeMail());
					
					System.out.print("---->"+rtReferredJobDetails.getRjDob());
					reArrayList.add(referered);

				}

			}
			map.get(positionCode).setLiReferereds(reArrayList);

		}
		for (String positionCode : map.keySet()) {
			returnList.add(map.get(positionCode));

		}

		return returnList;
	}



	@GetMapping("employeenames")
	public List<RtReferredJobDetails> getemployeenames(@RequestParam String rtPositionCode, @RequestParam Date rjDob) {
		Query query = entityManager
				.createNativeQuery("select  rj_employee_name  from rt_referred_job_details where rj_dob='" + rjDob
						+ "'and rt_position_code='" + rtPositionCode + "'");
		List<RtReferredJobDetails> rtReferredJobDetails = query.getResultList();
		return rtReferredJobDetails;

	}
	
	  @GetMapping("mobilecount")
	    public List<RtReferredJobDetails> getmobilecount(@RequestParam String rtPositionCode){
	       Query query=entityManager.createNativeQuery("select rj_mobile from rt_referred_job_details where rt_position_code='"+rtPositionCode+"'");
	       List<RtReferredJobDetails> rtReferredJobDetails=query.getResultList();
	              return rtReferredJobDetails;
	       
	    }


	@PostMapping("validatedusers")
	public Boolean validatedRefererUsr(@RequestBody RtReferredJobDetails r) {
		boolean statusmsg = false;
		try {
			RtReferredJobDetails rtjobdetails = referredRepository.findByRjNameAndRjDobAndRjEmailAndRtPositionCode(
					r.getRjName(), r.getRjDob(), r.getRjEmail(), r.getRtPositionCode());
		
			if (rtjobdetails.getRjDob() != null && rtjobdetails.getRjName() != null && rtjobdetails.getRjEmail() != null && rtjobdetails.getRjEmail() != null) {
					statusmsg = true;
					return statusmsg;

			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return statusmsg;
	}
	

	
    @GetMapping("count")
 public List<RtReferredJobDetails> getcount(@RequestParam Integer rjEmployeeCode) {
        Query query = entityManager.createNativeQuery("select count(*) from rt_referred_job_details  where  rj_employee_code= '"+rjEmployeeCode+"' ");
        List<RtReferredJobDetails> rtReferredJobDetails = query.getResultList();
        return rtReferredJobDetails;

 }

	
//	@GetMapping("count")
//    public List<RtReferredJobDetails> getcount(@RequestParam Integer rjEmployeeCode) {
//           Query query = entityManager.createNativeQuery("select count(*) from rt_referred_job_details  where  rj_employee_code= '"+rjEmployeeCode+"' ");
//           List<RtReferredJobDetails> rtReferredJobDetails = query.getResultList();
//           return rtReferredJobDetails;
//
//    }

	
	@GetMapping("countingold")
	public List<Object[]> getingcount(@RequestParam Integer rjEmployeeCode, @RequestParam String rjStatus) {
	return referredRepository.findByRefCount(rjStatus, rjEmployeeCode);
}
//	@GetMapping("count")
//	public List<RtReferredJobDetails> getcount(@RequestParam Integer rjEmployeeCode, @RequestParam String rjStatus) {
//		Query query = entityManager
//				.createNativeQuery("select distinct rt_position_code,(select count(*) from `rt_referred_job_details`  t where `rj_status`='new' And t.rt_position_Code = j.rt_position_code And rj_employee_code= '"+rjEmployeeCode+"' ) as newreferral "
//						+ " from rt_referred_job_details j");
//		List<RtReferredJobDetails> rtReferredJobDetails = query.getResultList();
//		return rtReferredJobDetails;
//
//	}
}
