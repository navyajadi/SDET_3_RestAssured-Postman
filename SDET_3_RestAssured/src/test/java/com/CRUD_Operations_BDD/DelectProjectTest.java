package com.CRUD_Operations_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DelectProjectTest {
	@Test
	
	public void delectProject() {
		
		when().delete("http://localhost:8084/projects/TY_PROJ_815")
		.then().assertThat().statusCode(204)
		.and().contentType(ContentType.JSON).log().all();
	}

}
