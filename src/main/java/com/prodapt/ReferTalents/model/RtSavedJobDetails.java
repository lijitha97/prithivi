package com.prodapt.ReferTalents.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.CodePointLength;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RtSavedJobDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@Column(name="sj_employee_code")
	private int sjEmployeeCode;
	
	@Column(name="sj_save_flag")
	private boolean sjSaveFlag;
	
	@Column(name="position_code")
	private String positionCode;
	
	@Column(name="rj_status")
	private String rjStatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="jb_id",referencedColumnName="id")
	
	private RtJobDetails rtJobDetails;
	
	public RtSavedJobDetails() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSjEmployeeCode() {
		return sjEmployeeCode;
	}

	public void setSjEmployeeCode(int sjEmployeeCode) {
		this.sjEmployeeCode = sjEmployeeCode;
	}

	public boolean isSjSaveFlag() {
		return sjSaveFlag;
	}

	public void setSjSaveFlag(boolean sjSaveFlag) {
		this.sjSaveFlag = sjSaveFlag;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getRjStatus() {
		return rjStatus;
	}

	public void setRjStatus(String rjStatus) {
		this.rjStatus = rjStatus;
	}

	public RtJobDetails getRtJobDetails() {
		return rtJobDetails;
	}

	public void setRtJobDetails(RtJobDetails rtJobDetails) {
		this.rtJobDetails = rtJobDetails;
	}

	
	

}
