package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class gitPathParameterTest {
	@Test

	public void gitPathParameter() {

		given().pathParam("username", "navyajadi")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos").then().log().all();

	}

}
