package com.project.dao;
import com.project.entity.LocationRequest;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ILocationDao extends CrudRepository<LocationRequest, Long>{
	
	    
    @Query("SELECT lr FROM LocationRequest lr WHERE lr.latitude = :latitude AND lr.longitude = :longitude AND lr.radius = :radius")
    List<LocationRequest> detectExistingRequests(@Param("latitude") String latitude,
                                   @Param("longitude") String longitude,
                                   @Param("radius") int radius);
    
}
