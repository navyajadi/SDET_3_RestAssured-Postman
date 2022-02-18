package com.rmgyantra.genericUtility;

import io.restassured.response.Response;

public class JSONUtility {

	public String jsonPathFinder(String JsonPath, Response rsps) {

	String	text=rsps.jsonPath().get(JsonPath);

		return text;

	}

}
