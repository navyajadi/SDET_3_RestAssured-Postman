package com.CRUD_Operations_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@Test
	public void updateProject() {
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "gita");
		jobj.put("projectName", "PRJTY-01");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 14);
		
		given().contentType(ContentType.JSON).body(jobj).when()
		.put("http://localhost:8084/projects/TY_PROJ_202").then().assertThat().statusCode(200).log().all();
	}

}
