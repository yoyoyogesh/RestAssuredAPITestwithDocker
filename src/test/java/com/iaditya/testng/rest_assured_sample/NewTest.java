package com.iaditya.testng.rest_assured_sample;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class NewTest {

	@Test
	public void testGetDataGovPackageSearch(){
		Response response = RestAssured.given().contentType("application/json").when().get("https://catalog.data.gov/api/3/action/package_search");
		System.out.println("******* " + response.getBody().asString());
		RestAssured.given().
			contentType("application/json").
		when().
			get("https://catalog.data.gov/api/3/action/package_search")
		.then()
			.body(
					"success", 
					equalTo(true)
				);
	}
	
	//WIP - returns Bad requet - JSON Error: No request body data
	@Test
	public void testPostDataGovPackageCreate(){
		Response response = RestAssured.given().contentType("application/json").body("{\"name\": \"myDataSet\"}").when().post("https://catalog.data.gov/api/3/action/package_create");
		System.out.println("******* " + response.getBody().asString());
	}
	
}
