package helpers.forAuth;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import api.ApiHelpMethods;
import org.openqa.selenium.Cookie;

public class Login extends ApiHelpMethods {

    public void doLoginInUiUsingApi(String token) {
        String tokenValue = authWithApi(token);
        Selenide.open("/");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(authCookieName, tokenValue));
        Selenide.open("/");
    }
}