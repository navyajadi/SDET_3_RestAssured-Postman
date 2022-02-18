package com.CRUD_Operations_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	
	@Test
	
	public void deleteProject() {
		Response resp = RestAssured.delete("http://localhost:8084/TY_PROJ_815");
		
		ValidatableResponse VResp = resp.then();
		VResp.assertThat().statusCode(404 );
	}

}
