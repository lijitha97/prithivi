package com.prodapt.ReferTalents.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ReferredDTO {

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
	
	@Column(name="rj_dob")
	private Date rjDob;
	
	@Column(name="rj_file")
	private String rjFile;
	
	@Column(name="rj_mobile")
	private String rjMobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getRjDob() {
		return rjDob;
	}

	public void setRjDob(Date rjDob) {
		this.rjDob = rjDob;
	}

	

	public String getRjFile() {
		return rjFile;
	}

	public void setRjFile(String rjFile) {
		this.rjFile = rjFile;
	}

	public String getRjMobile() {
		return rjMobile;
	}

	public void setRjMobile(String rjMobile) {
		this.rjMobile = rjMobile;
	}
	
	
	
}
	
	
