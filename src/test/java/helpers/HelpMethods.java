package helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class HelpMethods {

    /**
     * метод клика на кнопку
     *
     * @param element
     */
    public HelpMethods clickButton(SelenideElement element) {
        element
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .click();
        return this;
    }

    /**
     * метод заполнения поля по локатору
     *
     * @param element
     * @param textToSet
     */
    public HelpMethods fillForm(SelenideElement element, String textToSet) {
        element.clear();
        element.shouldBe(Condition.visible).setValue(textToSet);
        return this;
    }
}