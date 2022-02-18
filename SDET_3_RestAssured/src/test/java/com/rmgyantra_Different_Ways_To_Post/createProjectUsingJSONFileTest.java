package com.rmgyantra_Different_Ways_To_Post;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class createProjectUsingJSONFileTest {
	
	@Test
	
	public void jsonfile() {
		
		
		File file = new File("./AllData.json");
		
		given().contentType(ContentType.JSON).body(file).when().post("http://localhost:8084/addProject").then()
		.assertThat().statusCode(201).log().all();
	}

}
