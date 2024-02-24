package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.response.GooglePlacesApiResponse;
import com.project.service.LocationService;

@RestController
@RequestMapping("/api/v1/location")
@CrossOrigin(origins="http://localhost:3000")
public class LocationController {
	
	
	@Autowired
    private LocationService locationService;
	
    @GetMapping("/getNearby")
    public GooglePlacesApiResponse getLocation(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, @RequestParam("radius") int radius) {
    	
    	locationService.saveLocationRequest(latitude,longitude,radius);
    	return locationService.getLocation(latitude,longitude,radius);
    }
    


}
