package autotests.api.utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public final class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_INSTANT;

    public static String randomFutureDate(int maxDays) {
        long randomDay = ThreadLocalRandom.current().nextLong(1, maxDays + 1);
        return OffsetDateTime.now().plusDays(randomDay).format(FORMATTER);
    }
}
