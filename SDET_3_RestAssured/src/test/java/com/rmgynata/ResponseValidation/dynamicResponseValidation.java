package com.rmgynata.ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseValidation {
	@Test
	
	public void dynamicResponse() {
		{
			
			String excpData="SDET-TY3";
			
			Response resps = when().get("http://localhost:8084/projects");
			
			resps.then().assertThat().statusCode(200);
			
			List<String> listData = resps.jsonPath().get("projectName");
			
			for(String actalData:listData) {
				
				if(actalData.equals(excpData)) {
					
					System.out.println(actalData + "is present");
					
					break;
				}
			}
			
		}
	}

}
