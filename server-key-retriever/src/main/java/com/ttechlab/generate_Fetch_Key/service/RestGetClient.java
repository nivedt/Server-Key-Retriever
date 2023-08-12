package com.ttechlab.generate_Fetch_Key.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestGetClient {

	private static final String GET_URL = "http://localhost:8080/sample-service/get-data?key=";

	public static void main(String[] args) throws IOException, InterruptedException {
		for (int number = 10; number < 10000; number++) {
			if (checkPrime(number) && isKey(number)) {
				System.out.println("The desired key is " + number);
			}
		}		
	}

	private static Boolean checkPrime(int num) {
		// Check from 2 to n-1
		for (int c = 2; c * c < num; c++) {
			if (num % c == 0) {
				return false;
			}
		}
		return true;
	}

	private static Boolean isKey(int key) throws IOException, InterruptedException  {
		
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(GET_URL+key))
              .build();
      HttpResponse<String> response = null;
      
      try {
    	  response = client.send(request,
    			  HttpResponse.BodyHandlers.ofString());
      }
      catch(Exception e) {
    	  throw new RuntimeException(e);
      }
      if(response!=null) {
    	  if(response.body().contains("Invalid key")) {
//    	  System.out.println(response.body());
    		  return false;
    	  }
      }
//      System.out.println(response.body());
	  return true;
	}
	
	
}

