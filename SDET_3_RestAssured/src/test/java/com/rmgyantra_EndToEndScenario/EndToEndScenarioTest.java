package com.rmgyantra_EndToEndScenario;

import static io.restassured.RestAssured.given;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.rmgyantra.genericUtility.BaseAPIClass;
import com.rmgyantra.genericUtility.EndPoint;
import com.rmgyantra.genericUtility.JSONUtility;
import com.rmgyantra.genericUtility.JavaUtility;
import com.rmgynata_ProjectLibrary.pojoLibray;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenarioTest extends BaseAPIClass{

	@Test

	public void endToEndScenario() throws Throwable {

		JavaUtility jutil = new JavaUtility();

		pojoLibray pl = new pojoLibray("Navya", "NAVY-1" + jutil.generateRandom(), "Completed", 2);
		
//		baseURI="http://localhost";
//		port=8084;
		

	
		Response resp = given().contentType(ContentType.JSON).body(pl)

				.when().post("http://localhost:8084/addProject");

		JSONUtility jsUtil = new JSONUtility();

		String projectId = jsUtil.jsonPathFinder("projectId", resp);

		Response resp1 = given().pathParam("proId", projectId)
				
				.when().get("http://localhost:8084/projects/{proId}");

		String projectName = jsUtil.jsonPathFinder("projectName", resp1);

		ResultSet result = dUtil.executeQuery("select* from project");

		while (result.next()) {

			if (result.getString(4).equals(projectName)) {

				System.out.println(projectName + " is matching");
			}

		}

	}
}
