package autotests.api.tests.store;

import autotests.api.dto.OrderDto;
import autotests.api.enums.Status;
import autotests.api.tests.BaseApiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Map;

import static autotests.api.enums.SchemaResource.*;
import static autotests.api.fixtures.OrderFactory.orderBaseWithStatus;
import static autotests.api.spec.ResponseSpec.successResponse;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTest extends BaseApiTest {

    @ParameterizedTest(name = "Create, get, delete store order flow with status - {0}")
    @EnumSource(Status.class)
    @DisplayName("Create, get, delete store order flow")
    public void createGetDeleteOrder(Status status) {
        OrderDto orderExpected = orderBaseWithStatus(status);

        OrderDto orderCreated = storeClient.createOrder(orderExpected, successResponse(ORDER));
        assertEquals(orderExpected.getId(), orderCreated.getId());
        assertEquals(orderExpected.getPetId(), orderCreated.getPetId());
        assertEquals(orderExpected.getQuantity(), orderCreated.getQuantity());
        assertEquals(orderExpected.getStatus(), orderCreated.getStatus());
        assertEquals(orderExpected.getComplete(), orderCreated.getComplete());

        OrderDto fetchedOrder = storeClient.getOrderById(orderCreated.getId(), successResponse(ORDER));
        assertEquals(orderCreated.getId(), fetchedOrder.getId());
        assertEquals(orderCreated.getPetId(), fetchedOrder.getPetId());
        assertEquals(orderCreated.getQuantity(), fetchedOrder.getQuantity());
        assertEquals(orderCreated.getStatus(), fetchedOrder.getStatus());
        assertEquals(orderCreated.getComplete(), fetchedOrder.getComplete());

        storeClient.deleteOrder(orderCreated.getId(), successResponse(API_RESPONSE))
                .body("code", equalTo(HTTP_OK));
    }

    @Test
    @DisplayName("Get store inventory")
    public void getStoreInventory() {
        storeClient.getInventory(successResponse(INVENTORY));
    }

    @Test
    @DisplayName("Store inventory values are not null")
    public void getStoreInventoryValues() {
        Map<String, Integer> inventory = storeClient.getInventory(successResponse(INVENTORY));
        inventory.values().forEach(v -> assertNotNull(v, "Value is present (or zero)."));
    }
}
