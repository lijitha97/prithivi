package com.prodapt.ReferTalents.repository;

	
	import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.ReferTalents.model.RtJobDetails;


//@Repository is a Spring annotation that indicates that the decorated class is a repository.
//A repository is a mechanism for encapsulating storage, retrieval, and search behavior which 
//emulates a collection of objects. 

	@Repository
	public interface RefTalRepository extends JpaRepository<RtJobDetails, Integer> {
		
		RtJobDetails findByJdPositionCode(String jdPositionCode);
		
		Set<RtJobDetails> findByJdSkillsContaining(String jdSkills);
		Set<RtJobDetails> findByJdWorkLocationContaining(String jdWorkLocation);
		Set<RtJobDetails> findByJdExperienceContaining(String jdExperience); 


	}



