package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.faker.FakeData;
import pages.conponents.LoginForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@DisplayName("Негативные тесты на авторизацию")
public class AuthUiNegativeTest extends TestBase {

    private static LoginForm loginForm = new LoginForm();
    private static FakeData fakeData = new FakeData();

    static Stream<Arguments> authNegativeTest() {
        return Stream.of(
                Arguments.of(fakeData.fakeUser, fakeData.fakePassword, loginForm.getWrongUserAlertText()),
                Arguments.of(authConfings.getUsername(), fakeData.fakePassword, loginForm.getWrongPasswordAlertText()),
                Arguments.of("", fakeData.fakePassword, loginForm.getEmptyFieldAlertText()),
                Arguments.of(authConfings.getUsername(), "", loginForm.getEmptyFieldAlertText()),
                Arguments.of("", "", loginForm.getEmptyFieldAlertText())
        );
    }

    @Tag("authNegative")
    @DisplayName("Негативные тесты на авторизацию")
    @MethodSource()
    @ParameterizedTest(name = "name {0}, pass {1}, {2}")
    void authNegativeTest(String username, String password, String alertExpectedText) {
        step("Переход на сайт", () -> {
            Selenide.open("/");
        });
        String alertActualText =
                step("Попытка авторизации", () -> {
                    loginForm.doLogin(username, password);
                    String alertActualTextToReturn = Selenide.switchTo().alert().getText();
                    Selenide.confirm();
                    loginForm.getCloseModalButton();
                    return alertActualTextToReturn;
                });
        step("Проверки, что авторизации не прошла", () -> {
            Assertions.assertEquals(alertExpectedText, alertActualText);
            loginForm.getLoginButtonLocator().shouldBe(Condition.visible);
            loginForm.getNameOfUserLink().shouldNotBe(Condition.visible);
        });
    }
}