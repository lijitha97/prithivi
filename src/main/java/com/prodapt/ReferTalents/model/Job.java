package com.prodapt.ReferTalents.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



//The @Entity annotation specifies that the class is an entity and is mapped to a database table.
//The @Id annotation specifies the primary key of an entity.
//The @GeneratedValue gives the generation strategy for the values of primary keys.
//The @Table annotation specifies the name of the database table to be used for mapping.
//The @Column specifies the name of the column.

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="rt_job_details")

public class Job {


	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
    private int id;
	
	@Column(name = "jd_position_title")
    private String jdPositionTitle;
	
	@Column(name = "jd_business_unit")
    private String jdBusinessUnit;
	
	@Column(name = "jd_delivery_centre" )
    private String jdDeliveryCentre;
	
	@Column(name = "jd_position_creation_date")
    private String jdPositionCreationDate;
	
	@Column(name = "jd_education")
    private String jdEducation;
	
	@Column(name = "jd_experience")
    private String jdExperience;
	
	@Column(name = "jd_designation")
   private String jdDesignation;
	
	@Column(name = "jd_work_location")
    private String jdWorkLocation;
	
	@Column(name = "jd_job_responsibilities")
    private String jdJobResponsibilities;
	
	@Column(name = "jd_skills")
    private String jdSkills;
	
	@Column(name = "jd_position_code")
    private String jdPositionCode;
	
	public Job() {}

	
//	Getters and setters
	
//	Q1)Why should I write getters/setters?
//	A)Because the access is declared as private.
	
//	Q2)why it is declared as private?
//	A)Because with the help of getters and setters,it will be declared as public.
//    It is holding control over the property. 
//    If you make a field public, it means you provide direct access to the caller. 
//    if you provide a getter/setter, you provide them indirect access while taking full control.
//    The only way to set a value is through setter, and you get a value through a getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJdPositionTitle() {
		return jdPositionTitle;
	}

	public void setJdPositionTitle(String jdPositionTitle) {
		this.jdPositionTitle = jdPositionTitle;
	}

	public String getJdBusinessUnit() {
		return jdBusinessUnit;
	}

	public void setJdBusinessUnit(String jdBusinessUnit) {
		this.jdBusinessUnit = jdBusinessUnit;
	}

	public String getJdDeliveryCentre() {
		return jdDeliveryCentre;
	}

	public void setJdDeliveryCentre(String jdDeliveryCentre) {
		this.jdDeliveryCentre = jdDeliveryCentre;
	}

	public String getJdPositionCreationDate() {
		return jdPositionCreationDate;
	}

	public void setJdPositionCreationDate(String jdPositionCreationDate) {
		this.jdPositionCreationDate = jdPositionCreationDate;
	}

	public String getJdEducation() {
		return jdEducation;
	}

	public void setJdEducation(String jdEducation) {
		this.jdEducation = jdEducation;
	}

	public String getJdExperience() {
		return jdExperience;
	}

	public void setJdExperience(String jdExperience) {
		this.jdExperience = jdExperience;
	}

	public String getJdDesignation() {
		return jdDesignation;
	}

	public void setJdDesignation(String jdDesignation) {
		this.jdDesignation = jdDesignation;
	}

	public String getJdWorkLocation() {
		return jdWorkLocation;
	}

	public void setJdWorkLocation(String jdWorkLocation) {
		this.jdWorkLocation = jdWorkLocation;
	}

	public String getJdJobResponsibilities() {
		return jdJobResponsibilities;
	}

	public void setJdJobResponsibilities(String jdJobResponsibilities) {
		this.jdJobResponsibilities = jdJobResponsibilities;
	}

	public String getJdSkills() {
		return jdSkills;
	}

	public void setJdSkills(String jdSkills) {
		this.jdSkills = jdSkills;
	}

	public String getJdPositionCode() {
		return jdPositionCode;
	}

	public void setJdPositionCode(String jdPositionCode) {
		this.jdPositionCode = jdPositionCode;
	}
	
	
	
	
	
}