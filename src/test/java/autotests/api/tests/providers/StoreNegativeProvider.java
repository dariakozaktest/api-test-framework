package autotests.api.tests.providers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static autotests.api.fixtures.InvalidOrderFactory.*;
import static autotests.api.fixtures.RawPayloads.*;
import static autotests.api.utils.RandomUtils.randomInt;

public final class StoreNegativeProvider {

    public static Stream<Arguments> postInvalidPayloads() {
        return Stream.of(
                Arguments.arguments("Invalid id", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithStringId(), spec)),
                Arguments.arguments("Invalid ship date", (OrderRequest) (client, spec) -> client.createOrderRaw(invalidShipDate(), spec)),
                Arguments.arguments("Invalid pet id", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithHugePetId(), spec)),
                Arguments.arguments("Invalid quantity", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithStringQuantity(), spec)),
                Arguments.arguments("Invalid status", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithIntStatus(), spec)),
                Arguments.arguments("Invalid complete", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithStringComplete(), spec)),
                Arguments.arguments("Huge id", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithHugeId(), spec)),
                Arguments.arguments("Huge pet id", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithHugePetId(), spec)),
                Arguments.arguments("Huge quantity", (OrderRequest) (client, spec) -> client.createOrderRaw(orderWithHugeQuantity(), spec))
        );
    }

    public static Stream<Arguments> invalidParams() {
        return Stream.of(
                Arguments.arguments("Negative orderId", "-1"),
                Arguments.arguments("orderId is 0", "0"),
                Arguments.arguments("orderId does not exist", randomInt(5))
        );
    }
}
