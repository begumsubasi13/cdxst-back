package com.project.response;

public enum EResponseStatus {
	
	SUCCESS("SUCCESS",0,"SUCCESS"),
	ERROR("FAILED",999,"FAILED"),
	REQ_ALREADY_EXISTS_ERROR("FAILED",998,"Request already exists");
	
	private String status;
    private int statusCode;
	private String statusDescription;
	
	private EResponseStatus(String status, int statusCode, String statusDescription) {
		this.status = status;
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

}
