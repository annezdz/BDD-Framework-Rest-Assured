package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;
import resources.enums.APIResources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlaceValidationDefinitions extends Utils{

    RequestSpecification res;
    ResponseSpecification responseSpecification;
    Response response;
    TestDataBuild body = new TestDataBuild();

    @Given("add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = RestAssured.given().spec(requestSpecification())
                .body(body.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String resource) {
      APIResources resources =  APIResources.valueOf(resource);
       response = res.when().post(resources.getResource()).then().spec(responseSpecification).extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }

    @And("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectValue) {
        String body = response.asString();
        JsonPath jsonPath = new JsonPath(body);
        assertEquals(jsonPath.get(keyValue).toString(), expectValue);
    }

}
