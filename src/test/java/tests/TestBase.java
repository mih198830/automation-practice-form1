package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserTypeConfig;
import config.BrowserVersionConfig;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrastionFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrastionFormPage registrastionFormPage = new RegistrastionFormPage();
    TestData testData = new TestData();
    Attach attach = new Attach();
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    public static BrowserVersionConfig browserConfig = ConfigFactory.create(BrowserVersionConfig.class);
    public static BrowserTypeConfig browserType = ConfigFactory.create(BrowserTypeConfig.class);


    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browser = System.getProperty("browser", browserType.FIREFOX());
        Configuration.browserVersion = System.getProperty("browserVersion", browserConfig.chromeVersion100());
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = String.format("https://%s:%s@%s", config.login(), config.password(), config.remoteUrl());
        //Configuration.remote = config.getRemoteWebDriver();//second configuration
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

