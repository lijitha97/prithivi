
package com.prodapt.ReferTalents.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity

@Table(name="rt_prefer_job_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Preferred {


	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="pj_employee_code")
    private Integer pjEmployeeCode;
    @Column(name="pj_skills")
    private String pjSkills;
    @Column(name="pj_location")
    private String pjLocation;
    @Column(name="pj_experience")
    private String pjExperience;

    public Preferred(){
        
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPjEmployeeCode() {
		return pjEmployeeCode;
	}

	public void setPjEmployeeCode(Integer pjEmployeeCode) {
		this.pjEmployeeCode = pjEmployeeCode;
	}

	public String getPjSkills() {
		return pjSkills;
	}

	public void setPjSkills(String pjSkills) {
		this.pjSkills = pjSkills;
	}

	public String getPjLocation() {
		return pjLocation;
	}

	public void setPjLocation(String pjLocation) {
		this.pjLocation = pjLocation;
	}

	public String getPjExperience() {
		return pjExperience;
	}

	public void setPjExperience(String pjExperience) {
		this.pjExperience = pjExperience;
	}
    
}