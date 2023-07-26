package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class CategoriesGetTests {
	private static ResponseSpecification responseSpec;

	@BeforeClass
	public void setup() {
		baseURI = "http://localhost:3030";
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectHeader("Content-Type", "application/json; charset=utf-8");
		builder.expectContentType("application/json");
		responseSpec = builder.build();
	}

	@Test(description = "Check that the response status code is 200 when sending API GET/categories request ")
	public void CTT_GET_status_code() {
		given().
			get("/categories").
		then().
			spec(responseSpec).
			statusCode(200).
			log().all();
	}

	@Test(description = "Check that the total number of products is an integer when sending API GET/categories request ")
	public void CTT_GET_All_ID_Numbers() {
		given().
			get("/categories").
		then().
			spec(responseSpec).
			statusCode(200).
			body("total",equalTo(4307)).
			log().all();
	}

	@Test(description = "Check that the length of data is equal to the limit MAX number 25 when sending API GET/categories request with limit parameter 25")
	public void CTT_GET_Default_Limit() {
		given().
			get("/categories").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(10)).
			log().all();
	}

	@Test(description = "Check that the length of data is equal to the limit MAX number 25 when sending API GET/categories request with limit parameter 35")
	public void CTT_GET_Limit_MAX() {
		given().
			get("/categories?$limit=25").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(25)).
			log().all();
	}

	@Test(description = "Check that the length of data is equal to the limit Default number 10 when sending API GET/categories request with limit parameter 0")
	public void CTT_GET_Limit_Exceed_MAX() {
		given().
			get("/categories?$limit=35").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(25)).
			log().all();
	}
	@Test(description = "Check that the length of data is equal to the limit Default number 10 when sending API GET/categories request with limit parameter 0")
	public void CTT_GET_Limit_MIN() {
		given().
			get("/categories?$limit=0").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(0)).
			log().all();
	}

	@Test(description = "Check that response error message when sending API GET/categories request with string limit parameter q")
	public void CTT_GET_String_Limit() {
		given().
			get("/categories?$limit=q").
		then().
			spec(responseSpec).
			statusCode(500).
			body("message", equalTo("SQLITE_ERROR: no such column: NaN")).
			log().all();
	}

	@Test(description = "Check that some of data are skipped in response when sending API GET/categories request with SKIP parameter less than the max IDs")
	public void CTT_GET_Skip() {
		given().
			get("/categories?$skip=4305").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(2)).
			log().all();
	}
	@Test(description = "Check that All data are skipped in response when sending API GET/categories request with SKIP parameter equal max IDs")
	public void CTT_GET_Skip_MAX() {
		given().
			get("/categories?$skip=4307").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(0)).
			log().all();
	}

	@Test(description = "Check that All data are skipped in response when sending API GET/categories request with SKIP parameter more than the max IDs")
	public void CTT_GET_Skip_Exceed_MAX() {
		given().
			get("/categories?$skip=4308").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(0)).
			log().all();
	}

	@Test(description = "Check that no data are skipped in response and return 10 as the default limit when sending API GET/categories request with SKIP parameter 0")
	public void CTT_GET_Skip_MIN() {
		given().
			get("/categories?$skip=0").
		then().
			spec(responseSpec).
			statusCode(200).
			body("data.size()", equalTo(10)).
			log().all();
	}

	@Test(description = "Check that response error message in response when sending API GET/categories request with String SKIP parameter q")
	public void CTT_GET_String_Skip() {
		given().
			get("/categories?$skip=q").
		then().
			spec(responseSpec).
			statusCode(500).
			body("message", equalTo("SQLITE_ERROR: no such column: NaN")).
			log().all();
	}

	@Test(dataProvider = "idNameData", description = "Check that the response status code is 200 when sending API GET/Categories/validID")
	public void CTT_GET_ID(String id) {
		given().
			get("/categories/"+id).
		then().
			spec(responseSpec).
			statusCode(200).
			body("id", equalTo(id)).
			log().all();
	}

	@Test(description = "Check that the response status code is 404 when sending API GET/Categories/invalidID")
	public void CTT_GET_status_code_Not_exist_id() {
		given().
			get("/categories/993223").
		then().
			spec(responseSpec).
			statusCode(404).
			log().all();
	}

	@Test(description = "Check that the error message in response when sending API GET/Categories/invalidID")
	public void CTT_GET_Message_Not_exist_id() {
		given().
			get("/categories/993223").
		then().
			spec(responseSpec).
			statusCode(404).
			body("message",equalTo("No record found for id '993223'")).
			log().all();
	}
	
	 @DataProvider public Object[] idNameData(){
	        return new Object[] {"abcat0010000","abcat0020001","abcat0020002" ,"abcat0020004"};
	    }
}
