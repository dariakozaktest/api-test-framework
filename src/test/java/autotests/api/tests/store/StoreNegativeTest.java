package autotests.api.tests.store;

import autotests.api.tests.BaseApiTest;
import autotests.api.tests.providers.OrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static autotests.api.spec.ResponseSpec.*;
import static autotests.api.utils.RandomUtils.randomStringLetters;
import static java.net.HttpURLConnection.*;
import static org.hamcrest.Matchers.equalTo;

public class StoreNegativeTest extends BaseApiTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("autotests.api.tests.providers.StoreNegativeProvider#postInvalidPayloads")
    @DisplayName("Invalid payloads in post store request")
    public void createOrderInvalidPayload(String title, OrderRequest request) {
        request.send(storeClient, serverErrorResponse())
                        .body("code", equalTo(HTTP_INTERNAL_ERROR));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("autotests.api.tests.providers.StoreNegativeProvider#invalidParams")
    @DisplayName("Invalid param in get store by id request")
    public void getOrderByIdInvalidParam(String title, Object id) {
        storeClient.getOrderByIdRaw(id, notFoundResponse())
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("Order not found"));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("autotests.api.tests.providers.StoreNegativeProvider#invalidParams")
    @DisplayName("Invalid param in delete store request")
    public void deleteOrderInvalidParam(String title, Object id) {
        storeClient.deleteOrder(id, notFoundResponse())
                .body("code", equalTo(HTTP_NOT_FOUND))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("Order Not Found"));
    }

    @Test
    @DisplayName("orderId is null in get store by id request")
    public void getOrderByIdNull() {
        storeClient.getOrderByIdRaw("", notAllowedResponse())
                .body("code", equalTo(HTTP_BAD_METHOD));
    }

    @Test
    @DisplayName("orderId is null in delete store request")
    public void deleteOrderWithIdNull() {
        storeClient.deleteOrder("", notAllowedResponse())
                .body("code", equalTo(HTTP_BAD_METHOD));
    }

    @Test
    @DisplayName("Invalid orderId in get store by id request")
    public void getOrderByInvalidId() {
        String randomStr = randomStringLetters(5);
        storeClient.getOrderByIdRaw(randomStr, notFoundResponse())
                .body("code", equalTo(HTTP_NOT_FOUND))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("java.lang.NumberFormatException: For input string: \"" + randomStr + "\""));
    }

    @Test
    @DisplayName("Invalid orderId in delete store request")
    public void deleteOrderByInvalidId() {
        String randomStr = randomStringLetters(5);
        storeClient.deleteOrder(randomStr, notFoundResponse())
                .body("code", equalTo(HTTP_NOT_FOUND))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("java.lang.NumberFormatException: For input string: \"" + randomStr + "\""));
    }
}
