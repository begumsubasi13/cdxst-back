package com.project.response;

import com.project.entity.LocationRequest;

public class GooglePlacesApiResponse  {

	public String apiResp;
	public GenericResponse genericResponse;
		
	public GooglePlacesApiResponse(String apiResp, GenericResponse genericResponse) {
		super();
		this.apiResp = apiResp;
		this.genericResponse = genericResponse;
	}

	public GooglePlacesApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getApiResp() {
		return apiResp;
	}

	public void setApiResp(String apiResp) {
		this.apiResp = apiResp;
	}

	public GenericResponse getGenericResponse() {
		return genericResponse;
	}

	public void setGenericResponse(GenericResponse genericResponse) {
		this.genericResponse = genericResponse;
	}

}
