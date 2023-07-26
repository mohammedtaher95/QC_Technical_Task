package tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CategoriesPatchTests {
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        baseURI = "http://localhost:3030";
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectHeader("Content-Type", "application/json; charset=utf-8");
        builder.expectContentType("application/json");
        responseSpec = builder.build();
    }


    @Test(description = "Check that the response status code is 200 when sending API PATCH/Categories request with Valid ID")
    public void CTT_PATCH_Request_VALID() {
        String beforemodificationid;

        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "555");
        map.put("name", "BeforemodificationCategorytest");
        JSONObject request = new JSONObject(map);

        //post to create ID with value 555
        Response response = given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/categories");

        //save ID 555 in variable
        beforemodificationid = response.jsonPath().getString("id");

        map.put("id", "555");
        map.put("name", "AftermodificationCategorytest");
        request = new JSONObject(map);

        //Send patch request to modify the name of ID 555
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/stores/"+beforemodificationid).
                then().
                statusCode(200).
                body("name", equalTo("AftermodificationCategorytest")).
                log().all();

        //Delete the modified ID
        given().
                delete("/categories/"+beforemodificationid).
                then().
                statusCode(200);
    }

    @Test(description = "Check that the response status code is 404 when sending API PATCH/Categories request with InValid ID")
    public void CTT_PATCH_Request_InvalidID() {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", "555");
        map.put("name", "AftermodificationCategorytest");
        JSONObject request = new JSONObject(map);

        //Send patch request to modify the name of ID 555
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/categories/555").
                then().
                statusCode(404).
                log().all();
    }

    @Test(description = "Check that the response status code is 404 when sending API PATCH/Categories request with InValid ID")
    public void CTT_PATCH_Request_stringID() {
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                patch("/categories/555").
                then().
                statusCode(404).
                log().all();
    }



    @DataProvider public Object[] idNameData(){
        return new Object[] {"abcat0010000","abcat0020001","abcat0020002" ,"abcat0020004"};
    }
}
