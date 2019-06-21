package com.prodapt.ReferTalents.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.ReferTalents.model.RtPreference;



@Repository
public interface PreferenceRepository extends JpaRepository<RtPreference, Integer> {

	List<RtPreference> findByPjEmployeeCode(Integer pjEmployeeCode);
}


