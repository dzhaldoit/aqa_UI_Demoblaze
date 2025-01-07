package api;

import config.UrlConfings;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

public class Spec {
    protected static UrlConfings urlConfings = ConfigFactory.create(UrlConfings.class, System.getProperties());

    private static RequestSpecification request(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(urlConfings.getApiAuthUrl())
                .setContentType(ContentType.JSON)
                .build();
    }

    private static ResponseSpecification response(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void install(String path, int statusCode) {
        RestAssured.requestSpecification = request(path);
        RestAssured.responseSpecification = response(statusCode);
    }
}