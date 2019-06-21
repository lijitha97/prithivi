package com.prodapt.ReferTalents.service;

	import java.util.List;

import com.prodapt.ReferTalents.model.RtJobDetails;

	public interface RefTalService {
		
//		It contains the getAll  and save method
		
		List<RtJobDetails> getAll();

		RtJobDetails save(RtJobDetails rjd);


}
