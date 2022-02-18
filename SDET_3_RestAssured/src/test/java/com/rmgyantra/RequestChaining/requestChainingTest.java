package com.rmgyantra.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class requestChainingTest {

	@Test

	public void requestChaining() {

		Response resp = given().get("http://localhost:8084/projects");
		
		String projectId = resp.jsonPath().get("[1].projectId");
		
		System.out.println(projectId);
		given().pathParam("ProId", projectId).when()
		.delete("http://localhost:8084/projects/{ProId}")
		.then()
		.assertThat()
		.statusCode(204).log().all();
	}

}
