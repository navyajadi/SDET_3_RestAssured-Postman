package com.rmgyantra_Authentication_Validation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthenticationTest {
	
	@Test
	
	public void basicAuthentication() {
		
		given().auth().basic("rmgyantra", "rmgy@9999").when().get("http://localhost:8084").then().log().all();
	}

}
