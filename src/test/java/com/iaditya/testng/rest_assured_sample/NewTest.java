package com.iaditya.testng.rest_assured_sample;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.withArgs;

import io.restassured.response.Response;


/**
 * Simple rest assured test suite using TestNG to drive the suite
 * 
 * @author adityai
 *
 */
public class NewTest {

	/**
	 * Simple get request response verification 
	 */
	@Test
	public void testGetDataGovPackageSearch(){
		Response response = RestAssured.given().contentType("application/json").when().get("https://catalog.data.gov/api/3/action/package_search");
		System.out.println("******* " + response.getBody().asString());
		RestAssured.given().
			contentType("application/json").
		when().
			get("https://catalog.data.gov/api/3/action/package_search")
		.then().assertThat().
			body(
					"success", 
					equalTo(true)
				);
	}

	/**
	 * Test method to search for elements in an array
	 * 
	 */
	@Test
	public void testGetDataGovPackageSearchArray(){
		Response response = RestAssured.given().contentType("application/json").when().get("https://catalog.data.gov/api/3/action/package_search");
		System.out.println("******* " + response.getBody().asString());
		response.then().assertThat().
			body("result.results[0].id", equalTo("1e68f387-5f1c-46c0-a0d1-46044ffef5bf")).
				body("result.results[1].id", equalTo("000f1c44-a0b8-402f-8d4b-a4b66dfb7734"));
	}

	
	/**
	 * Test method to search for elements in an array using withArgs
	 * 
	 * 
	 */
	@Test
	public void testGetDataGovPackageSearchArrayWithArgs(){
		int index = 0;
		Response response = RestAssured.given().contentType("application/json").when().get("https://catalog.data.gov/api/3/action/package_search");
		System.out.println("******* " + response.getBody().asString());
		
		//TODO: Need to find another example which has an array list in the json
//		response.then().assertThat().
//			body("result.results[%d].id", withArgs(index++), hasItems("1e68f387-5f1c-46c0-a0d1-46044ffef5bf")).
//			body("result.results[%d].id", withArgs(index), hasItem("000f1c44-a0b8-402f-8d4b-a4b66dfb7734"));
	}

	/**
	 * Simple post request response verification
	 * 
	 */
	@Test
	public void testPostDataGovPackageCreate(){
		Response response = RestAssured.given().contentType("application/json").body("{\"name\": \"myDataSet\"}").when().post("https://catalog.data.gov/api/3/action/package_create");
		//TODO: - returns Bad requet - JSON Error: No request body data
		System.out.println("******* " + response.getBody().asString());
	}
	
}
