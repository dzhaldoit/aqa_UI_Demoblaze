package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement
            addToCartButtonLocator = $(".btn-success");

    public SelenideElement getAddToCartButtonLocator() {
        return addToCartButtonLocator;
    }
}