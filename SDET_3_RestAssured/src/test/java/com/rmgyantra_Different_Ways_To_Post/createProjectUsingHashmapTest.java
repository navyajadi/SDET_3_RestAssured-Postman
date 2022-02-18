package com.rmgyantra_Different_Ways_To_Post;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;



public class createProjectUsingHashmapTest {
	
	@Test
	
	public void createHashmap() {
		
		HashMap hp = new HashMap();
		hp.put("createdBy", "sri");
		hp.put("projectName", "PRJTY-04");
		hp.put("status", "Created");
		hp.put("teamSize", 5);
		
		given().contentType(ContentType.JSON).body(hp).when()
		.post("http://localhost:8084/addProject").then().assertThat().statusCode(201).log().all();
	}

}
