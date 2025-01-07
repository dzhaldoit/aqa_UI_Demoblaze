package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import pages.conponents.LoginForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Позитивный тест на авторизацию ui")
public class AuthUiPositiveTest extends TestBase {

    private LoginForm loginForm = new LoginForm();

    @Tag("authPositive")
    @DisplayName("Позитивный тест на авторизацию ui")
    @Test
    void authPositiveTest() {
        step("Переход на сайт", () -> {
            Selenide.open("/");
        });
        step("Авторизация", () -> {
            loginForm.doLogin(authConfings.getUsername(), authConfings.getPassword());
        });
        step("Проверка авторизации", () -> {
            loginForm.getNameOfUserLink().shouldBe(Condition.visible);
            loginForm.getLoginButtonLocator().shouldNotBe(Condition.visible);
        });
    }
}