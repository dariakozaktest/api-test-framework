package autotests.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    APPROVED("approved"),
    DELIVERED("delivered"),
    PLACED("placed");

    private final String status;
}
