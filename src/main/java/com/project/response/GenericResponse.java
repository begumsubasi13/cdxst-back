package com.project.response;

public class GenericResponse {
	
    private String status;
    private int    responseCode;
    private String responseDescription;
       
	public GenericResponse(String status, int responseCode, String responseDescription) {
		super();
		this.status = status;
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDescription() {
		return responseDescription;
	}
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
    
}
