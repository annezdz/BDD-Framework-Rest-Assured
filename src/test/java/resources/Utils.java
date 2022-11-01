package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

    RequestSpecification requestSpecification;

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI="https://rahulshetty.com";

        requestSpecification = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        return requestSpecification;
    }
}
