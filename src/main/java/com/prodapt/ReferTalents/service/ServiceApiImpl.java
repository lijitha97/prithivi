package com.prodapt.ReferTalents.service;

	import java.util.List;

	import org.springframework.stereotype.Service;

import com.prodapt.ReferTalents.model.RtPreference;
import com.prodapt.ReferTalents.repository.PreferenceRepository;

	@Service
	public class ServiceApiImpl implements ServiceApi {
		
		PreferenceRepository preferenceRepository;
		
		public ServiceApiImpl(PreferenceRepository preferenceRepository) {
			// TODO Auto-generated constructor stub
			this.preferenceRepository = preferenceRepository;
		}
		
		public List<RtPreference> getAll() {
			// TODO Auto-generated method stub
			return preferenceRepository.findAll();
		}

		@Override
		public RtPreference save(RtPreference prjd) {
			// TODO Auto-generated method stub
			return this.preferenceRepository.save(prjd);
		}


	}


