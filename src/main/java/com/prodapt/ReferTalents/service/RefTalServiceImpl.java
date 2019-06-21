package com.prodapt.ReferTalents.service;

	import java.util.List;

	import org.springframework.stereotype.Service;

import com.prodapt.ReferTalents.model.RtJobDetails;
import com.prodapt.ReferTalents.repository.RefTalRepository;

	@Service
	public class RefTalServiceImpl implements RefTalService {
		
//		It contains the implementation of getAll method and save method
		
		RefTalRepository reftalRepository;
		
		public RefTalServiceImpl(RefTalRepository reftalRepository) {
			this.reftalRepository = reftalRepository;
		}
		
		public List<RtJobDetails> getAll() {
			return reftalRepository.findAll();
		}
		
		
//		The findAll() method returns the list of all job details from the "rt_job_details" table in the database.
		

		@Override
		public RtJobDetails save(RtJobDetails rjd) {
			return this.reftalRepository.save(rjd);
		}

//    The save method is used to save all the details fetched from findAll method 
	}


