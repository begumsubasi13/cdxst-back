package com.project.exception.handlers;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class GooglePlacesApiException extends Exception {
	
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String  message;
    private Integer errorCode;

    public GooglePlacesApiException() {
        super();
    }


}
