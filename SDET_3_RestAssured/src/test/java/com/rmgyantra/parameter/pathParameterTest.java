package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class pathParameterTest {
	@Test

	public void pathParameter() {

		given().contentType(ContentType.JSON)
		.pathParam("pID", "TY_PROJ_1002")
		.when()
		.get("http://localhost:8084/projects/{pID}")
		.then()
		.log()
		.all();
	}

}
