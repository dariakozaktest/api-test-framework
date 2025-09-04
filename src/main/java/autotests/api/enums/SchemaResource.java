package autotests.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SchemaResource {

    API_RESPONSE("schemas/api-response.json"),
    INVENTORY("schemas/inventory.json"),
    ORDER("schemas/order.json");

    private final String path;
}
