package com.prodapt.ReferTalents.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ReferTalents.model.Preferred;
import com.prodapt.ReferTalents.model.RtJobDetails;

@Repository
public interface PreferredJobsRepository extends JpaRepository<Preferred, Integer> {
	
	
    List<Preferred> findByPjEmployeeCode(Integer pjEmployeeCode);

}
