package attaches;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.RemoteConfig;
import config.UrlConfings;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.sessionId;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attaches {
    private static RemoteConfig remoteConfigs = ConfigFactory.create(RemoteConfig.class, System.getProperties());

    private static UrlConfings urlConfings = ConfigFactory.create(UrlConfings.class, System.getProperties());

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public static byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    // этот метод необходим для следующего. Его в тесты не прикладываем
    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    //этот метод прикладываем в тесты (то есть в AfterEach) НЕ РАБОТАЕТ С FIREFOX
    public static void browserConsoleLogs() {
        attachAsText(
                "Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER))
        );
    }

    //Этот метод прикладываем в @AfterEach
    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String addVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    //Здесь просто создается ссылка для предыдущего метода
    public static URL getVideoUrl() {
        String videoUrl = String.format("https://%s/video/%s.mp4", urlConfings.getRemoteUrl(), sessionId().toString());
        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}