package autotests.api.tests.providers;

import autotests.api.clients.StoreClient;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

@FunctionalInterface
public interface OrderRequest {
    ValidatableResponse send(StoreClient storeClient, ResponseSpecification responseSpec);
}
