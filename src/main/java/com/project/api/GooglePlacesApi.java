package com.project.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GooglePlacesApi {
	
	 private static final String API_KEY = "xxx";
    
	 public static String searchNearbyPlaces(String latitude, String longitude, int radius) throws Exception {
	        String apiUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	        String location = latitude + "," + longitude;
	        String radiusParam = String.valueOf(radius);
	        String apiKey = "key=" + API_KEY;

	        String urlString = apiUrl + "location=" + URLEncoder.encode(location, "UTF-8") +
	                "&radius=" + URLEncoder.encode(radiusParam, "UTF-8") +
	                "&" + apiKey;

	        URL url = new URL(urlString);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Accept", "application/json");

	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuilder response = new StringBuilder();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        String responseStr = response.toString();
	        
	        try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	        return responseStr;
	    }

}
