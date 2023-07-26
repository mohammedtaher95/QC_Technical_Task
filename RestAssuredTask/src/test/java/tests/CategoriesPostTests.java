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

public class CategoriesPostTests {
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        baseURI = "http://localhost:3030";
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectHeader("Content-Type", "application/json; charset=utf-8");
        builder.expectContentType("application/json");
        responseSpec = builder.build();
    }

    @Test(description = "Check that the response status code is 200 when sending API POST/categories request with valid data")
    public void CTT_POST_Valid_Request() {

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "555");
        map.put("name", "Categorytest");
        JSONObject request = new JSONObject(map);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories").
                then().
                statusCode(201);

        given().
                get("/categories/?name=Categorytest").
                then().
                statusCode(200).
                body("data.size()", equalTo(1)).log().all();

        given().
                delete("/categories/?name=Categorytest").
                then().
                statusCode(200);


        given().
                get("/categories/?name=Categorytest").
                then().
                statusCode(200).
                body("data.size()", equalTo(0)).log().all();
    }

    @Test(description = "Check that the response status code is 400 when sending API POST/categories request with no ID")
    public void CTT_POST_Request_NO_ID() {

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("name", "Categorytest");
        JSONObject request = new JSONObject(map);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories").
                then().
                statusCode(400);
    }

    @Test(description = "Check that the response status code is 400 when sending API POST/categories request with no name")
    public void CTT_POST_Request_NO_Name() {

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "556");
        JSONObject request = new JSONObject(map);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories").
                then().
                statusCode(400);
    }

    @Test(description = "Check that the response status code is 400 when sending API POST/categories request with no data")
    public void CTT_POST_Request_NO_DATA() {
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                post("/categories").
                then().
                statusCode(400);
    }

    @Test(description = "Check that the response status code is 400 when sending API POST/categories request with existing ID")
    public void CTT_POST_Request_Exist_ID() {

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "pcmcat84000050001");
        map.put("name", "Categorytest");
        JSONObject request = new JSONObject(map);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories").
                then().
                statusCode(400);

    }

    @Test(description = "Check that the response status code is 200 when sending API DELETE/categories request with valid id")
    void CTT_DELETE_Request_VALID() {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "555");
        map.put("name", "Categorytest");
        JSONObject request = new JSONObject(map);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories").
                then().
                statusCode(201);

        given().
                get("/categories/?name=Categorytest").
                then().
                statusCode(200).
                body("data.size()", equalTo(1)).log().all();

        given().
                delete("/categories/?name=Categorytest").
                then().
                statusCode(200);


        given().
                get("/categories/?name=Categorytest").
                then().
                statusCode(200).
                body("data.size()", equalTo(0)).log().all();
    }

    @Test(description = "Check that the response status code is 404 when sending API DELETE/categories request with unknown id")
    void CTT_DELETE_Request_INVALID_ID() {
        given().
                delete("/categories/1111111111").
                then().
                statusCode(404).log().all();

    }

    @DataProvider public Object[] idNameData(){
        return new Object[] {"abcat0010000","abcat0020001","abcat0020002" ,"abcat0020004"};
    }
}
