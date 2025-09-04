package autotests.api.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public final class RandomUtils {

    public static int randomInt(int size) {
        int m = (int) Math.pow(10, size - 1);
        return Math.abs(m + new Random().nextInt(9 * m));
    }

    public static int randomIntInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be <= max");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int randomNegativeInt(int maxAbsValue) {
        if (maxAbsValue <= 0) {
            throw new IllegalArgumentException("maxAbsValue must be > 0");
        }
        return -ThreadLocalRandom.current().nextInt(1, maxAbsValue + 1);
    }

    public static String randomStringLetters(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
