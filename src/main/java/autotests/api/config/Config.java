package autotests.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties PROPS = new Properties();

    static {
        String env = System.getProperty("env", "qa");
        String filename = env + ".properties";

        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(filename)) {
            if (in == null) throw new RuntimeException("Config file is not found: " + filename);
            PROPS.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + filename, e);
        }
    }

    public static String baseUrl() { return PROPS.getProperty("base.url"); }
}
