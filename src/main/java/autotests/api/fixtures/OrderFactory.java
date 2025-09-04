package autotests.api.fixtures;

import autotests.api.dto.OrderDto;
import autotests.api.enums.Status;

import java.util.function.UnaryOperator;

import static autotests.api.enums.Status.PLACED;
import static autotests.api.utils.DateUtils.randomFutureDate;
import static autotests.api.utils.RandomUtils.randomInt;
import static autotests.api.utils.RandomUtils.randomIntInRange;

public final class OrderFactory {

    public static OrderDto orderBase() {
        return OrderDto.builder()
                .id(randomIntInRange(1, 10))
                .petId(randomInt(3))
                .quantity(randomInt(1))
                .shipDate(randomFutureDate(10))
                .status(PLACED.getStatus())
                .complete(true)
                .build();
    }

    public static OrderDto orderBaseWithStatus(Status status) {
        return OrderDto.builder()
                .id(randomIntInRange(1, 10))
                .petId(randomInt(3))
                .quantity(randomInt(1))
                .shipDate(randomFutureDate(10))
                .status(status.getStatus())
                .complete(true)
                .build();
    }

    public static OrderDto with(UnaryOperator<OrderDto.OrderDtoBuilder> f) {
        return f.apply(orderBase().toBuilder()).build();
    }
}
