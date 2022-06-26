package tests.properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Disabled
    @Tag("JenkinsTest")
    void systemTest() {
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "103");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println("I am testing " + browser);
    }
}
