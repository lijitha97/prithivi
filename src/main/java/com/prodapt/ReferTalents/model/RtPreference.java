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


//The @Entity annotation specifies that the class is an entity and is mapped to a database table.
//The @Id annotation specifies the primary key of an entity.
//The @GeneratedValue gives the generation strategy for the values of primary keys.
//The @Table annotation specifies the name of the database table to be used for mapping.
//The @Column specifies the name of the column.



@Entity
@Table(name="rt_preferred_job_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class RtPreference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="pj_employee_code")
	private int pjEmployeeCode;
	
	@Column(name="pj_employee_name")
	private String pjEmployeeName;
	
	@Column(name="pj_skills")
	private String pjSkills;
	
	@Column(name="pj_location")
	private String pjLocation;
	
	@Column(name="pj_experience")
	private String pjExperience;
	
	@Column(name="rj_status")
	private String rjStatus;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="rt_job_details_id",referencedColumnName="id")
//	private RtJobDetails rtJobDetails;
	
//	private int rt_job_details_id;
	
	public RtPreference() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPjEmployeeCode() {
		return pjEmployeeCode;
	}
	public void setPjEmployeeCode(int pjEmployeeCode) {
		this.pjEmployeeCode = pjEmployeeCode;
	}
	public String getPjEmployeeName() {
		return pjEmployeeName;
	}
	public void setPjEmployeeName(String pjEmployeeName) {
		this.pjEmployeeName = pjEmployeeName;
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

	public String getRjStatus() {
		return rjStatus;
	}
	public void setRjStatus(String rjStatus) {
		this.rjStatus = rjStatus;
	}
	
	
	
	
	
	
	

	
	
}
