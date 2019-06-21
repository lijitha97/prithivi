package com.prodapt.ReferTalents.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

public class HRReferredJobDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private int id;
	
	@Column(name="rj_employee_code")
	private int rjEmployeeCode;
	
	@Column(name="rj_referred_flag")
	private boolean rjReferredFlag;
	
	@Column(name="rj_name")
	private String rjName;
	
	@Column(name="rj_email")
	private String rjEmail;
	
	@Column(name="rj_employee_name")
	private String rjEmployeeName;

	@Column(name="rt_position_code")
	private String rtPositionCode;
	

	@Column(name="rj_status")
	private String rjStatus;
	

	@Column(name="newReferrals")
	 private int newReferrals;

	@Column(name="OldReferred")
	 private int OldReferred;
	
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="rt_job_details_id",referencedColumnName="id")
	 
	 
	    private HRJobDetails hrjobdetails;
	 
	public HRJobDetails getHrjobdetails() {
		return hrjobdetails;
	}

	public void setHrjobdetails(HRJobDetails hrjobdetails) {
		this.hrjobdetails = hrjobdetails;
	}

	public HRReferredJobDetails() {}

	public int getRjEmployeeCode() {
		return rjEmployeeCode;
	}

	public void setRjEmployeeCode(int rjEmployeeCode) {
		this.rjEmployeeCode = rjEmployeeCode;
	}

	public boolean isRjReferredFlag() {
		return rjReferredFlag;
	}

	public void setRjReferredFlag(boolean rjReferredFlag) {
		this.rjReferredFlag = rjReferredFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRjName() {
		return rjName;
	}

	public void setRjName(String rjName) {
		this.rjName = rjName;
	}

	public String getRjEmail() {
		return rjEmail;
	}

	public void setRjEmail(String rjEmail) {
		this.rjEmail = rjEmail;
	}

	public String getRjEmployeeName() {
		return rjEmployeeName;
	}

	public void setRjEmployeeName(String rjEmployeeName) {
		this.rjEmployeeName = rjEmployeeName;
	}

	

	public String getRtPositionCode() {
		return rtPositionCode;
	}

	public void setRtPositionCode(String rtPositionCode) {
		this.rtPositionCode = rtPositionCode;
	}

	

	public String getRjStatus() {
		return rjStatus;
	}

	public void setRjStatus(String rjStatus) {
		this.rjStatus = rjStatus;
	}
	public int getNewReferrals() {
		return newReferrals;
	}

	public void setNewReferrals(int newReferrals) {
		this.newReferrals = newReferrals;
	}

	public int getOldReferred() {
		return OldReferred;
	}

	public void setOldReferred(int oldReferred) {
		OldReferred = oldReferred;
	}


}
