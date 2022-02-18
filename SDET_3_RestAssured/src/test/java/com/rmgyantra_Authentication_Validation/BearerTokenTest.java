package com.rmgyantra_Authentication_Validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	
	@Test
	
	public void bearerToken() {
		
		given().auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
		
	}

}
