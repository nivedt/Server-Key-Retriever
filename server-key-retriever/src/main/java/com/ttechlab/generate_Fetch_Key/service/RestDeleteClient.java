package com.ttechlab.generate_Fetch_Key.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RestDeleteClient {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		// DELETE request
		String deleteUrl = "http://localhost:8080/sample-service/data";
		HttpRequest deleteRequest = HttpRequest.newBuilder().uri(URI.create(deleteUrl)).DELETE().build();
		HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, BodyHandlers.ofString());
		System.out.println("DELETE response code: " + deleteResponse.statusCode());
		System.out.println("DELETE response body: " + deleteResponse.body());
	}
}
