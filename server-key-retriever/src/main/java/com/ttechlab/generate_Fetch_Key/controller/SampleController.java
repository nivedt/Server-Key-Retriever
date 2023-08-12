package com.ttechlab.generate_Fetch_Key.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttechlab.generate_Fetch_Key.dao.DataEntity;
import com.ttechlab.generate_Fetch_Key.vo.SampleVO;

@RestController
@RequestMapping("sample-service")
public class SampleController {

//	private List<Data> dataList = new ArrayList<>(); // In-memory data structure
	private static long lowerBound = 10; // Lower bound (inclusive)
	private static long upperBound = 10000;

	private long number;

	public SampleController() {
		number = generateRandomPrime(lowerBound, upperBound);
		System.out.println("the key number is :" + number);
	}

	@GetMapping("/sample-response")
	public ResponseEntity<SampleVO> getSampleResponse() {
		return new ResponseEntity<>(new SampleVO("Hello", "World"), HttpStatus.OK);
	}

	@GetMapping("/get-data")
	public ResponseEntity<String> getData(@RequestParam("key") Long key) {

		if (key.longValue() == number) {
			return new ResponseEntity<>("Congratulations you have unlocked the data with key value: " + key,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid key " + key, HttpStatus.OK);
		}

	}

	public static long generateRandomPrime(long lowerBound, long upperBound) {
		Random random = new Random();
		long randomNum;

		do {
			randomNum = random.longs(lowerBound, upperBound).findAny().getAsLong();
		} while (!isPrime(randomNum));

		return randomNum;
	}

	public static boolean isPrime(long number) {
		if (number <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

//	@PostMapping("/save-data")
//	public ResponseEntity<String> createData(@RequestBody SampleVO sampleVO) { // saveData
//		return new ResponseEntity<>("Data saved successfully", HttpStatus.CREATED);
//	}
	
//	@PostMapping("/save-data")
//    public ResponseEntity<String> saveData(@RequestBody SampleVO sampleVO) {
//        // Process the data and save it
//
//        // Return a JSON response
//        String jsonResponse = "{\"message\": \"Data saved successfully\"}";
//        return ResponseEntity.ok()
//                .header("Content-Type", "application/json")
//                .body(jsonResponse);
//    }
	
	//------------------------------------------------
	
//	@PutMapping("/data")
//	public ResponseEntity<String> updateData(@RequestBody SampleVO sampleVO) {
//		return new ResponseEntity<>("Data updated successfully", HttpStatus.OK);
//	}
	
//	@PutMapping("/update-data/{id}")
//	public ResponseEntity<String> updateData(@PathVariable("id") Long id, @RequestBody SampleVO sampleVO) {
//	    // Process the data update based on the provided ID and new data
//
//	    // Return a JSON response
//	    String jsonResponse = "{\"message\": \"Data updated successfully\"}";
//	    return ResponseEntity.ok()
//	            .header("Content-Type", "application/json")
//	            .body(jsonResponse);
//	}
	
	@PostMapping("/save-data")
	public ResponseEntity<DataEntity> saveData(@RequestBody DataEntity data) {
	    // Process the data and save it

	    // Return the updated data in the response
	    data.setId(123); // Set the ID of the saved data
	    return ResponseEntity.ok()
	            .header("Content-Type", "application/json")
	            .body(data);
	}

	@PutMapping("/update-data/{id}")
	public ResponseEntity<DataEntity> updateData(@PathVariable Long id, @RequestBody DataEntity data) {
	    // Process the data update based on the provided ID

	    // Return the updated data in the response
	    data.setId(id); // Set the ID of the updated data
	    return ResponseEntity.ok()
	            .header("Content-Type", "application/json")
	            .body(data);
	}

	@DeleteMapping("/data")
	public ResponseEntity<String> deleteData() {
		return new ResponseEntity<>("Data deleted Successfully!", HttpStatus.OK);
	}
}
