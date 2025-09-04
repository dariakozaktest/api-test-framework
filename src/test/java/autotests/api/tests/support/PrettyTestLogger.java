package autotests.api.tests.support;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PrettyTestLogger implements BeforeTestExecutionCallback, AfterTestExecutionCallback, TestWatcher {

    private static final String SEP = "========================================================";
    private static final Map<String, Instant> STARTS = new ConcurrentHashMap<>();

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String name = displayName(context);
        System.out.println("\n" + SEP);
        System.out.println("▶ START: " + name);
        STARTS.put(context.getUniqueId(), Instant.now());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        String id = context.getUniqueId();
        Instant start = STARTS.getOrDefault(id, Instant.now());
        long ms = Duration.between(start, Instant.now()).toMillis();
        System.out.println("⏱ DURATION: " + ms + " ms");
        System.out.println(SEP);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("✔ PASSED: " + displayName(context));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("⚠ ABORTED: " + displayName(context) + " — " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("✖ FAILED: " + displayName(context));
        if (cause != null) {
            System.out.println("   REASON: " + cause.getClass().getSimpleName() + ": " + cause.getMessage());
        }
    }

    private String displayName(ExtensionContext ctx) {
        return ctx.getTestClass().map(Class::getSimpleName).orElse("<class>")
                + " :: "
                + ctx.getDisplayName();
    }
}
