package com.rmgyantra_Different_Ways_To_Post;

import org.testng.annotations.Test;

import com.rmgynata_ProjectLibrary.pojoLibray;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createPojectUsingPOJOTest {

	@Test
	
	public void createPOJO() {
		
		Random r = new Random();
	
		int randomNumber = r.nextInt();
		
		pojoLibray pl = new pojoLibray("leela", "zozho"+randomNumber+" ", "ZOPJY", 3);
		
		given().contentType(ContentType.JSON).body(pl).when().post("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201).log().all();
		
	}
	
	
}
