package com.rmgyanta_Hamcrest_Validation;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidationHamcrestTest {

	@Test
	public void validationHamcrest() {

		when().get("http://localhost:8084/projects").then().assertThat()
				.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
				.assertThat().body("[0].projectName", Matchers.equalTo("SDETY")).log().all();
	}

}
