package com.rmgyantra_Different_Ways_To_Post;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgynata_ProjectLibrary.pojoLibray;

import io.restassured.http.ContentType;

public class DataProviderTest {

	@Test(dataProvider = "providerdata")

	public void CreateProject(String createdBy, String projectName, String status, int teamSize) {

		Random r = new Random();

		int randomNumber = r.nextInt();

		pojoLibray pl = new pojoLibray(createdBy, projectName + randomNumber, status, teamSize);

		given().contentType(ContentType.JSON).body(pl).when().post("http://localhost:8084/addProject").then()
				.assertThat().statusCode(201).log().all();
	}

	@DataProvider

	public Object[][] providerdata() {
		Object objarr[][] = new Object[2][4];

		objarr[0][0] = "careers";
		objarr[0][1] = "CRS_01";
		objarr[0][2] = "On Going";
		objarr[0][3] = 3;

		objarr[1][0] = "career";
		objarr[1][1] = "CRS_02";
		objarr[1][2] = "On Going";
		objarr[1][3] = 5;

		return objarr;

	}
}
