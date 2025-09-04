package autotests.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Endpoint {

    STORE_INVENTORY("/store/inventory"),
    STORE_ORDER("/store/order"),
    STORE_ORDER_BY_ID("/store/order/{orderId}");

    private final String path;
}
