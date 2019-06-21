package com.prodapt.ReferTalents.model;

import java.sql.Date;

import javax.persistence.Column;

public class Referered {
	
	private int id;
	private int rjEmployeeCode;
	private boolean rjReferredFlag;
	private String rjName;
	private String rjEmail;
	private String rjEmployeeName;
	private String rtPositionCode;
	private String rtStatus;
	private Date rjDob;
	private String rjFile;
	private String rjMobile;
	private String rjEmployeeMail;
	private String rjCommend;


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
	public String getRtStatus() {
		return rtStatus;
	}
	public void setRtStatus(String rtStatus) {
		this.rtStatus = rtStatus;
	}
	public Date getRjDob() {
		return rjDob;
	}
	public void setRjDob(Date rjDob) {
		this.rjDob = rjDob;
	}
	public String getRjEmployeeMail() {
		return rjEmployeeMail;
	}
	public void setRjEmployeeMail(String rjEmployeeMail) {
		this.rjEmployeeMail = rjEmployeeMail;
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
	public String getRjCommend() {
		return rjCommend;
	}
	public void setRjCommend(String rjCommend) {
		this.rjCommend = rjCommend;
	}
	
	
	
	
	
	

}
