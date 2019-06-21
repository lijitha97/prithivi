//package com.prodapt.ReferTalents.controller;
//
//	import java.util.List;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.RequestBody;
//	import org.springframework.web.bind.annotation.RequestParam;
//	import org.springframework.web.bind.annotation.RestController;
//
//	import com.prodapt.ReferTalents.model.RtReferredJobDetails;
//	import com.prodapt.ReferTalents.model.RtJobDetails;
//	import com.prodapt.ReferTalents.repository.RefTalRepository;
//	import com.prodapt.ReferTalents.repository.ReferredRepository;
//
//	@RestController
//	public class ReferJobDetailsController {
//		
//		@Autowired
//		RefTalRepository refTalRepository;
//		
//		@Autowired
//		ReferredRepository referredRepository;
//		
//		
//		@PostMapping("rtjobdetails")
//		public RtJobDetails rtjobdetails(@RequestBody RtJobDetails rtjobdetails) {
//			return refTalRepository.save(rtjobdetails);
//		}
//		
//		@PostMapping("rtreferredjobdetails")
//		public RtReferredJobDetails refer(@RequestBody RtReferredJobDetails r,@RequestParam Integer id) {
//			RtJobDetails rtjobdetails=refTalRepository.getOne(id);
//			r.setRtjobdetails(rtjobdetails);
//			return referredRepository.save(r);
//		
//		}
//		
//		@GetMapping("getAll")
//		public List<RtJobDetails> getBooks() {
//			return refTalRepository.findAll();
//		}
//		
//		@GetMapping("getAllReferral")
//		public List<RtReferredJobDetails> getAllBooks() {
//			return referredRepository.findAll();
//		}
//
//	}
//
