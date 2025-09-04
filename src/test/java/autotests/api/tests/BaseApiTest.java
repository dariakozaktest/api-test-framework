package autotests.api.tests;

import autotests.api.clients.StoreClient;
import autotests.api.config.Config;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(autotests.api.tests.support.PrettyTestLogger.class)
public abstract class BaseApiTest {

    private static final Logger LOGGER = Logger.getLogger(BaseApiTest.class.getName());

    protected StoreClient storeClient = new StoreClient();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = Config.baseUrl();
        LOGGER.info("Base URL: " + Config.baseUrl());

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
