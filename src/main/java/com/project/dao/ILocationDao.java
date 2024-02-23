package com.project.dao;
import com.project.entity.LocationRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ILocationDao extends CrudRepository<LocationRequest, Long>{
	
	    
    @Query("SELECT COUNT(*) FROM LocationRequest e WHERE e.latitude = :latitude AND e.longitude = :longitude AND e.radius = :radius GROUP BY e.latitude, e.longitude, e.radius HAVING COUNT(*) > 1")
    Integer detectExistingRequests(@Param("latitude") String latitude,
                                   @Param("longitude") String longitude,
                                   @Param("radius") int radius);


}
