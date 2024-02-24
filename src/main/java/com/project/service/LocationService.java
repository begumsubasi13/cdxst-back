package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.GooglePlacesApi;
import com.project.dao.ILocationDao;
import com.project.entity.LocationRequest;
import com.project.exception.handlers.GooglePlacesApiException;
import com.project.response.EResponseStatus;
import com.project.response.GenericResponse;
import com.project.response.GooglePlacesApiResponse;

@Service
public class LocationService {

	@Autowired
	private ILocationDao locationDao;

	public GooglePlacesApiResponse getLocation(final String latitude, final String longitude, final int radius)
			throws GooglePlacesApiException {
		GooglePlacesApiResponse response = new GooglePlacesApiResponse();
		try {
			String nearbyPlaces = GooglePlacesApi.searchNearbyPlaces(latitude, longitude, radius);
			response = new GooglePlacesApiResponse(nearbyPlaces,
					new GenericResponse(EResponseStatus.SUCCESS.getStatus(), EResponseStatus.SUCCESS.getStatusCode(),
							EResponseStatus.SUCCESS.getStatusDescription()));
		} catch (Exception e) {
			throw GooglePlacesApiException.builder()
					.withMessage(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusDescription())
					.withErrorCode(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusCode()).build();

		}
		return response;
	}

	public GooglePlacesApiResponse saveLocationRequest(final String latitude, final String longitude, final int radius,
			final GooglePlacesApiResponse resp) throws GooglePlacesApiException {
		LocationRequest lr = new LocationRequest();
		lr.setLatitude(latitude);
		lr.setLongitude(longitude);
		lr.setRadius(radius);
		lr.setRequestTime(System.currentTimeMillis());
		lr.setResult(resp.getApiResp());

		boolean requestExists = false;
		List<LocationRequest> existinReqs = requestExists(lr);
		if (existinReqs != null) {

			if (existinReqs.size() > 0) {
				requestExists = true;
			} else {
				requestExists = false;
			}
		} else {
			requestExists = false;
		}
		if (!requestExists) {
			try {
				LocationRequest saveLoc = this.locationDao.save(lr);
			} catch (Exception e) {
				throw GooglePlacesApiException.builder()
				.withMessage(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusDescription())
				.withErrorCode(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusCode()).build();
			}
			return new GooglePlacesApiResponse(null, new GenericResponse(EResponseStatus.SUCCESS.getStatus(),
					EResponseStatus.SUCCESS.getStatusCode(), EResponseStatus.SUCCESS.getStatusDescription()));
		} else {
			return new GooglePlacesApiResponse(existinReqs.get(0).getResult(),
					new GenericResponse(EResponseStatus.SUCCESS.getStatus(), EResponseStatus.SUCCESS.getStatusCode(),
							EResponseStatus.SUCCESS.getStatusDescription()));
		}
	}

	public List<LocationRequest> requestExists(LocationRequest locationRequest) {

		List<LocationRequest> existingRequests = locationDao.detectExistingRequests(locationRequest.getLatitude(),
				locationRequest.getLongitude(), locationRequest.getRadius());
		return existingRequests;

	}

}
