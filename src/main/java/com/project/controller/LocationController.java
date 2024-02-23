package com.project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
@CrossOrigin(origins="http://localhost:3000")
public class LocationController {
	
    @GetMapping("/getNearby")
    public String getLocation(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("radius") Double radius) {
    	
        return "Latitude: " + latitude + ", Longitude: " + longitude + ", Radius: " + radius;
    }
    
    @GetMapping("/getNearby/{latitude}")
    public String getLocation2(@PathVariable double latitude) {
    	
        return "Latitude: " + latitude;
    }
    
    @GetMapping("/test")
    public String test() {
    	
        return "test";
    }

}
