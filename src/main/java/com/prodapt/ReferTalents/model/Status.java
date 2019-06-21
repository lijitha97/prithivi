package com.prodapt.ReferTalents.model;

import java.util.List;

public class Status {

	
	private Integer statusCode=400;
	private String message;
	private RtSavedJobDetails rtSavedJobDetails;
	private RtPreference rtPreference;
	private List<RtReferredJobDetails> rtReferredJobDetails;
	private Preferred preferred;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public RtSavedJobDetails getRtSavedJobDetails() {
		return rtSavedJobDetails;
	}
	public void setRtSavedJobDetails(RtSavedJobDetails rtSavedJobDetails) {
		this.rtSavedJobDetails = rtSavedJobDetails;
	}
	public List<RtReferredJobDetails> getRtReferredJobDetails() {
		return rtReferredJobDetails;
	}
	public void setRtReferredJobDetails(List<RtReferredJobDetails> rtReferredJobDetails) {
		this.rtReferredJobDetails = rtReferredJobDetails;
	}
	public RtPreference getRtPreference() {
		return rtPreference;
	}
	public void setRtPreference(RtPreference rtPreference) {
		this.rtPreference = rtPreference;
	}
	public Preferred getPreferred() {
		return preferred;
	}
	public void setPreferred(Preferred preferred) {
		this.preferred = preferred;
	}
	

	
	
	
}
