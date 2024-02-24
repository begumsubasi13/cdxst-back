package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LocationRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_service_sq")
	@SequenceGenerator(name = "location_service_sq", sequenceName = "LOCATION_SERVICE_SEQUENCE", allocationSize = 1)
    @JsonIgnore
	private Long requestId;
	
	private String latitude;
	private String longitude;
	private int radius;
	private long requestTime;
	
	@Lob
	private String result;
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public long getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
