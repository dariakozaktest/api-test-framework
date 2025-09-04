package autotests.api.fixtures;

public final class RawPayloads {

    public static String orderWithStringId() {
        return "{"
                + "\"id\":\"string\","
                + "\"petId\":123,"
                + "\"quantity\":1,"
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithHugeId() {
        return "{"
                + "\"id\":1888887654345665465153,"
                + "\"petId\":123,"
                + "\"quantity\":1,"
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithStringPetId() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":\"string\","
                + "\"quantity\":1,"
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithHugePetId() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":1888887654345665465153,"
                + "\"quantity\":1,"
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithStringQuantity() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":10,"
                + "\"quantity\":\"string\","
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithHugeQuantity() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":10,"
                + "\"quantity\":1888887654345665465153,"
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithIntStatus() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":10,"
                + "\"quantity\":\"string\","
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":1,"
                + "\"complete\":true"
                + "}";
    }

    public static String orderWithStringComplete() {
        return "{"
                + "\"id\":10,"
                + "\"petId\":10,"
                + "\"quantity\":\"string\","
                + "\"shipDate\":\"2025-09-04T12:00:00.000Z\","
                + "\"status\":\"placed\","
                + "\"complete\":\"true\""
                + "}";
    }
}
