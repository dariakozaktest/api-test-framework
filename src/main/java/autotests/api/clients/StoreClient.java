package autotests.api.clients;

import autotests.api.dto.OrderDto;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static autotests.api.enums.Endpoint.*;

public class StoreClient {

    public OrderDto createOrder(OrderDto order, ResponseSpecification responseSpec) {
        return ApiClient.post(
                STORE_ORDER.getPath(),
                order,
                responseSpec,
                OrderDto.class
        );
    }

    public ValidatableResponse createOrderRaw(Object body, ResponseSpecification responseSpec) {
        return ApiClient.postRaw(
                STORE_ORDER.getPath(),
                body,
                responseSpec
        );
    }

    public ValidatableResponse deleteOrder(Object id, ResponseSpecification responseSpec) {
        return ApiClient.deleteRaw(
                STORE_ORDER_BY_ID.getPath(),
                responseSpec,
                id
        );
    }

    public Map<String, Integer> getInventory(ResponseSpecification responseSpec) {
        return ApiClient.get(
                STORE_INVENTORY.getPath(),
                responseSpec,
                new TypeRef<>() {}
        );
    }

    public ValidatableResponse getInventoryRaw(ResponseSpecification responseSpec) {
        return ApiClient.getRaw(
                STORE_INVENTORY.getPath(),
                responseSpec
        );
    }

    public OrderDto getOrderById(int id, ResponseSpecification responseSpec) {
        return ApiClient.get(
                STORE_ORDER_BY_ID.getPath(),
                responseSpec,
                OrderDto.class,
                id
        );
    }

    public ValidatableResponse getOrderByIdRaw(Object id, ResponseSpecification responseSpec) {
        return ApiClient.getRaw(
                STORE_ORDER_BY_ID.getPath(),
                responseSpec,
                id
        );
    }
}
