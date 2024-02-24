package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.GooglePlacesApi;
import com.project.dao.ILocationDao;
import com.project.entity.LocationRequest;
import com.project.response.EResponseStatus;
import com.project.response.GenericResponse;
import com.project.response.GooglePlacesApiResponse;

@Service
public class LocationService {
	
	@Autowired
    private ILocationDao locationDao;
	
	public GooglePlacesApiResponse getLocation(final String latitude, final String longitude, final int radius) {
		GooglePlacesApiResponse response = new GooglePlacesApiResponse();
		try {
			String nearbyPlaces = GooglePlacesApi.searchNearbyPlaces(latitude, longitude, radius);
			response = new GooglePlacesApiResponse(nearbyPlaces, new GenericResponse(EResponseStatus.SUCCESS.getStatus(), EResponseStatus.SUCCESS.getStatusCode(),
					EResponseStatus.SUCCESS.getStatusDescription()));
		} catch (Exception e) {
			return new GooglePlacesApiResponse(null, new GenericResponse(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatus(), EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusCode(),
					EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusDescription()));
		}
		return response;
	}
	
	public GenericResponse saveLocationRequest(final String latitude, final String longitude, final int radius) {
		LocationRequest lr = new LocationRequest();
		lr.setLatitude(latitude);
		lr.setLongitude(longitude);
		lr.setRadius(radius);
		lr.setRequestTime(System.currentTimeMillis());
		
		boolean requestExists = requestExists(lr);
		if(!requestExists) {
			
			try {
				LocationRequest saveLoc = this.locationDao.save(lr);
			}
			catch (Exception e) {			
				return new GenericResponse(EResponseStatus.ERROR.getStatus(), EResponseStatus.ERROR.getStatusCode(),
						EResponseStatus.ERROR.getStatusDescription());
				
			}
			return new GenericResponse(EResponseStatus.SUCCESS.getStatus(), EResponseStatus.SUCCESS.getStatusCode(),
					EResponseStatus.SUCCESS.getStatusDescription());
		}
		else {
			return new GenericResponse(EResponseStatus.REQ_ALREADY_EXISTS_ERROR.getStatus(), EResponseStatus.REQ_ALREADY_EXISTS_ERROR.getStatusCode(),
					EResponseStatus.REQ_ALREADY_EXISTS_ERROR.getStatusDescription());
		}
		
	}
	
	public boolean requestExists(LocationRequest locationRequest) {
			
		Integer detectExistingRequests = locationDao.detectExistingRequests(locationRequest.getLatitude(),
																			locationRequest.getLongitude(),
																			locationRequest.getRadius());
		if(detectExistingRequests != null) {
			
			if(detectExistingRequests > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
    }

}
