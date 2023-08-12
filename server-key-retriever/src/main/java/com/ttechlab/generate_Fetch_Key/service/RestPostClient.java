package com.ttechlab.generate_Fetch_Key.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.ttechlab.generate_Fetch_Key.dao.DataEntity;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPostClient {
//	 private static final String GET_POST_URL = "http://localhost:8080/sample-service/save-data";

	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		Gson gson = new Gson();

		// Prepare the JSON data
		DataEntity data = new DataEntity();
		data.setName("John");
		data.setAge(30);
		String json = gson.toJson(data);
		System.out.println(data);

//		String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
//		YourClass yourObject = gson.fromJson(json, YourClass.class);

		
		// POST request
		String postUrl = "http://localhost:8080/sample-service/save-data";
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create(postUrl))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
		
		
		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
		System.out.println("POST response code: " + postResponse.statusCode());
		System.out.println("POST response body: " + postResponse.body());

		if (postResponse.statusCode() >= 200 && postResponse.statusCode() < 300) {
		    try {
		        // Convert JSON response to Java object
		        DataEntity responseEntity = gson.fromJson(postResponse.body(), DataEntity.class);
		        System.out.println("Response entity: " + responseEntity);
		    } catch (JsonSyntaxException e) {
		        // Handle JSON parsing exception
		        e.printStackTrace();
		    }
		} else {
		    // Handle non-successful response
		    System.out.println("Error: " + postResponse.body());
		}		
		
//		HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
//		System.out.println("POST response code: " + postResponse.statusCode());
//		System.out.println("POST response body: " + postResponse.body());
//
//		try {
//		    // Convert JSON response to Java object
//		    DataEntity responseEntity = gson.fromJson(postResponse.body(), DataEntity.class);
//		    System.out.println("Response entity: " + responseEntity);
//		} catch (JsonSyntaxException e) {
//		    // Handle the exception
//		    e.printStackTrace();
//		}


		// Convert JSON response to Java object
		DataEntity responseEntity = gson.fromJson(postResponse.body(), DataEntity.class);
		System.out.println("Response entity: " + responseEntity);

	}
}

