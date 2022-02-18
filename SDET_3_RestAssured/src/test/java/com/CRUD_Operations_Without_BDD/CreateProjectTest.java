package com.CRUD_Operations_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test

	public void createTest() 
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "teena");
		jobj.put("projectName", "TY_SDET-3");
		jobj.put("status", "Created");
		jobj.put("teamSize", 9);
		
		RequestSpecification reqSpc = RestAssured.given();
		reqSpc.contentType(ContentType.JSON);
		reqSpc.body(jobj);
		
		
		Response resp = RestAssured.post("http://localhost:8084/addProject");
		ValidatableResponse Vresp = resp.then();
		Vresp.assertThat().statusCode(201);
		Vresp.log().all();
		

	}
}
