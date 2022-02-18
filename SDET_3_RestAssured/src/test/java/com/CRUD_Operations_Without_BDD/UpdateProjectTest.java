package com.CRUD_Operations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	
	public void update() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "raniii");
		jobj.put("projectName", "TY_SDET-3");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 9);
		
		RequestSpecification reqSpc = RestAssured.given();
		reqSpc.contentType(ContentType.JSON);
		reqSpc.body(jobj);
		
		
		Response resp = RestAssured.put("http://localhost:8084/projects/TY_PROJ_204");
		ValidatableResponse Vresp = resp.then();
		Vresp.assertThat().statusCode(200);
		Vresp.log().all();
		

	}
	}

