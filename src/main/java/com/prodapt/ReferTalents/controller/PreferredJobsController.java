//package com.prodapt.ReferTalents.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.prodapt.ReferTalents.model.RtJobDetails;
//import com.prodapt.ReferTalents.service.PreferredJobsService;
//
//
//@RestController
//@RequestMapping("/RtDetails")
//public class PreferredJobsController {
//	
//	PreferredJobsService preferredjobsService;
//
//	public PreferredJobsController(PreferredJobsService preferredjobsService) {
//		// TODO Auto-generated constructor stub
//		this.preferredjobsService = preferredjobsService;
//	}
//	
//	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
//	public List<RtJobDetails> getAll() {
//		return this.preferredjobsService.getAll();
//
//		}
//	}
//
