package com.ttechlab.generate_Fetch_Key.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RestPutClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        
        // Prepare the JSON data
        String json = "{\"name\":\"John\",\"age\":27}";

        // PUT request
        Long id = (long) 123; // ID of the data to be updated
        String putUrl = "http://localhost:8080/sample-service/update-data/" + id;
        HttpRequest putRequest = HttpRequest.newBuilder()
                .uri(URI.create(putUrl))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
        
        HttpResponse<String> putResponse = httpClient.send(putRequest, BodyHandlers.ofString());
        System.out.println("PUT response code: " + putResponse.statusCode());
        System.out.println("PUT response body: " + putResponse.body());
    }
}
