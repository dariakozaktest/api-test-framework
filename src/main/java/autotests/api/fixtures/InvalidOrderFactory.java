package autotests.api.fixtures;

import autotests.api.dto.OrderDto;

import static autotests.api.utils.RandomUtils.randomStringLetters;

public final class InvalidOrderFactory {

    public static OrderDto invalidShipDate() {
        return OrderFactory.with(b -> b.shipDate(randomStringLetters(5)));
    }
}
