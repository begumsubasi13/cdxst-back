package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.handlers.GooglePlacesApiException;
import com.project.response.EResponseStatus;
import com.project.response.GenericResponse;
import com.project.response.GooglePlacesApiResponse;
import com.project.service.LocationService;

@RestController
@RequestMapping("/api/v1/location")
@CrossOrigin(origins="http://localhost:3000")
public class LocationController {
	
	
	@Autowired
    private LocationService locationService;
	
    @GetMapping("/getNearby")
    public GooglePlacesApiResponse getLocation(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("radius") int radius) throws GooglePlacesApiException {
    	
    	GooglePlacesApiResponse apiResp = locationService.getLocation(latitude,longitude,radius);
    	
    	if(apiResp != null) {
    		locationService.saveLocationRequest(latitude,longitude,radius,apiResp);
    		return apiResp;
    	}
    	else {
    		throw GooglePlacesApiException.builder()
            .withMessage(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusDescription())
            .withErrorCode(EResponseStatus.GOOGLE_PLACES_API_ERROR.getStatusCode())
            .build();

    	}
    }
    


}
