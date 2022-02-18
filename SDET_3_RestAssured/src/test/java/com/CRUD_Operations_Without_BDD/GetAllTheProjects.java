package com.CRUD_Operations_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheProjects {

	@Test
	public void getAllProjects() {
		
		Response rsp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(rsp.prettyPrint());
		// System.out.println(rsp.getContentType());
		// System.out.println(rsp.getStatusCode());

		ValidatableResponse VResp = rsp.then();

		VResp.assertThat().statusCode(200);
		VResp.assertThat().contentType("application/json");
	}

}
