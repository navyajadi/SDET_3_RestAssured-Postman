package com.rmgyantra_Different_Ways_To_Post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectUsingJSONObjectTest {
	
	@Test
	
	public void create() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "sita");
		jobj.put("projectName", "PRJTY-03");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		given().contentType(ContentType.JSON).body(jobj).when()
		.post("http://localhost:8084/addProject").then().assertThat().statusCode(201).log().all();
	}

}
