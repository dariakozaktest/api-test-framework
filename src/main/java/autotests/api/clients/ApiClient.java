package autotests.api.clients;

import autotests.api.spec.RequestSpec;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public static <T> T get(String path,
                            ResponseSpecification spec,
                            Class<T> responseClass,
                            Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .when()
                .get(path, pathParams)
                .then()
                .spec(spec)
                .extract().as(responseClass);
    }

    public static <T> T get(String path,
                            ResponseSpecification spec,
                            TypeRef<T> typeRef,
                            Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .when()
                .get(path, pathParams)
                .then()
                .spec(spec)
                .extract().as(typeRef);
    }

    public static ValidatableResponse getRaw(String path,
                                             ResponseSpecification spec,
                                             Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .when()
                .get(path, pathParams)
                .then()
                .spec(spec);
    }

    public static ValidatableResponse deleteRaw(String path,
                                                ResponseSpecification spec,
                                                Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .when()
                .delete(path, pathParams)
                .then()
                .spec(spec);
    }

    public static <T> T post(String path, Object body,
                             ResponseSpecification spec,
                             Class<T> responseClass,
                             Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .body(body)
                .when()
                .post(path, pathParams)
                .then()
                .spec(spec)
                .extract().as(responseClass);
    }

    public static ValidatableResponse postRaw(String path, Object body,
                                              ResponseSpecification spec,
                                              Object... pathParams) {
        return given()
                .spec(RequestSpec.baseSpec())
                .body(body)
                .when()
                .post(path, pathParams)
                .then()
                .spec(spec);
    }
}

