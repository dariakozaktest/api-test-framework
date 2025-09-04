package autotests.api.spec;

import autotests.api.enums.SchemaResource;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static autotests.api.enums.SchemaResource.API_RESPONSE;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.containsString;

public class ResponseSpec {

    public static ResponseSpecification successResponse(SchemaResource schema) {
        return new ResponseSpecBuilder()
                .expectStatusCode(HTTP_OK)
                .expectHeader("Content-Type", containsString("application/json"))
                .expectBody(matchesJsonSchemaInClasspath(schema.getPath()))
                .build();
    }

    public static ResponseSpecification badRequestResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HTTP_BAD_REQUEST)
                .expectHeader("Content-Type", containsString("application/json"))
                .expectBody(matchesJsonSchemaInClasspath(API_RESPONSE.getPath()))
                .build();
    }

    public static ResponseSpecification notFoundResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HTTP_NOT_FOUND)
                .expectHeader("Content-Type", containsString("application/json"))
                .expectBody(matchesJsonSchemaInClasspath(API_RESPONSE.getPath()))
                .build();
    }

    public static ResponseSpecification notAllowedResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HTTP_BAD_METHOD)
                .expectHeader("Content-Type", containsString("application/json"))
                .build();
    }

    public static ResponseSpecification serverErrorResponse() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HTTP_INTERNAL_ERROR)
                .expectHeader("Content-Type", containsString("application/json"))
                .expectBody(matchesJsonSchemaInClasspath(API_RESPONSE.getPath()))
                .build();
    }
}
