package com.prodapt.ReferTalents.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PreferredDTO {

    private int id;
	private int pjEmployeeCode;
	private String pjEmployeeName;
	private String pjPreferenceName;
	private String pjPositionTitle;
	private String pjSkills;
	private String pjLocation;
	private int pjExperience;
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
	public String getPjPreferenceName() {
		return pjPreferenceName;
	}
	public void setPjPreferenceName(String pjPreferenceName) {
		this.pjPreferenceName = pjPreferenceName;
	}
	public String getPjPositionTitle() {
		return pjPositionTitle;
	}
	public void setPjPositionTitle(String pjPositionTitle) {
		this.pjPositionTitle = pjPositionTitle;
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
	public int getPjExperience() {
		return pjExperience;
	}
	public void setPjExperience(int pjExperience) {
		this.pjExperience = pjExperience;
	}
	
	
	

}
