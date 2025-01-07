package pages.conponents;

import com.codeborne.selenide.SelenideElement;
import helpers.HelpMethods;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm extends MainPage {
    private HelpMethods helpMethods = new HelpMethods();
    private String
            wrongUserAlertText = "User does not exist.",
            emptyFieldAlertText = "Please fill out Username and Password.",
            wrongPasswordAlertText = "Wrong password.";

    SelenideElement
            usernameLocator = $("#loginusername"),
            passwordLocator = $("#loginpassword"),
            logInModalButton = $("[onclick = 'logIn()']"),
            closeModalButton = $x("//button[@onclick= 'logIn()']//..//button[text() = 'Close']");

    public String getWrongUserAlertText() {
        return wrongUserAlertText;
    }

    public String getEmptyFieldAlertText() {
        return emptyFieldAlertText;
    }

    public String getWrongPasswordAlertText() {
        return wrongPasswordAlertText;
    }

    public SelenideElement getCloseModalButton() {
        return closeModalButton;
    }

    /**
     * метод вход в аккаунт через ui
     *
     * @param userName
     * @param password
     */
    public void doLogin(String userName, String password) {
        helpMethods
                .clickButton(getLoginButtonLocator())
                .fillForm(usernameLocator, userName)
                .fillForm(passwordLocator, password)
                .clickButton(logInModalButton);
    }
}