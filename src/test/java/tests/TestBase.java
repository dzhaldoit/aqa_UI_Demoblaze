package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import attaches.Attaches;
import config.AuthConfings;
import config.RemoteConfig;
import config.UrlConfings;
import helpers.CustomApiListener;
import helpers.HelpMethods;
import helpers.forAuth.Login;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    protected static AuthConfings authConfings = ConfigFactory.create(AuthConfings.class, System.getProperties());
    protected static RemoteConfig remoteConfigs = ConfigFactory.create(RemoteConfig.class, System.getProperties());
    protected static UrlConfings urlConfings = ConfigFactory.create(UrlConfings.class, System.getProperties());
    protected Login login = new Login();
    protected HelpMethods helpMethods = new HelpMethods();
    private static String browser = System.getProperty("browser", "Chrome100");
    private static String browserSize = System.getProperty("browserSize", "1920x1080");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = urlConfings.getBaseUrl();

        RestAssured.filters(CustomApiListener.withCustomTemplates());
        setBrowserAndVersion(browser);
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub", remoteConfigs.getUser(), remoteConfigs.getPass(),
                urlConfings.getRemoteUrl());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attaches.attachScreenshot();
        Attaches.browserConsoleLogs();
        Attaches.addVideo();
        Selenide.closeWebDriver();
    }

    public static void setBrowserAndVersion(String browser1) {
        switch (browser1) {
            case "chrome100":
                Configuration.browser = "Chrome";
                Configuration.browserVersion = "100.0";
                break;
            case "fireFox97":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "97.0";
                break;
            case "fireFox98":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "98.0";
                break;
            case "chrome99":
                Configuration.browser = "Chrome";
                Configuration.browserVersion = "99.0";
        }
    }
}