package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("JenkinsTest")
    void systemTest() {
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "103");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}
