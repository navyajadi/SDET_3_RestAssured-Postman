package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class oAuthParameterTest {
	@Test

	public void oAuthParameter() {

		Response rsp = given().formParam("client_id", "Navya")
				.formParam("client_secret", "fe6a2c7a4e6d04076741335216405485")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://Example.com")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		System.out.println(rsp.prettyPrint());

		String token = rsp.jsonPath().get("access_token");
		System.out.println(token);

		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2536")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log()
		.all();

	}

}
