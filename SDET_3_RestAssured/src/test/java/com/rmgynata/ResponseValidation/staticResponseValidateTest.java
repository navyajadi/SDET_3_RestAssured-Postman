package com.rmgynata.ResponseValidation;

import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class staticResponseValidateTest {

	@Test
	public void staticResonse() {

		String exptDate = "SDET-TY3";
		Response reps = when().get("http://localhost:8084/projects");

		reps.then().assertThat().statusCode(200);
		String actlData = reps.jsonPath().get("[0].projectName");

		Assert.assertEquals(actlData, exptDate);

	}

}
