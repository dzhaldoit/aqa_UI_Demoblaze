package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
            loginButtonLocator = $("#login2"),
            nameOfUserLink = $("#nameofuser"),
            homeButtonLocator = $x("//a[text() = 'Home ']"),
            phonesButtonLocator = $("[onclick=\"byCat('phone')\"]"),
            notebookButtonLocator = $("[onclick=\"byCat('notebook')\"]"),
            monitorsButtonLocator = $("[onclick=\"byCat('monitor')\"]"),
            cartButtonLocator = $x("//a[text() = 'Cart']");

    private ElementsCollection
            products = $$("#tbodyid a[class]");

    public SelenideElement getLoginButtonLocator() {
        return loginButtonLocator;
    }

    public SelenideElement getNameOfUserLink() {
        return nameOfUserLink;
    }

    public SelenideElement getPhonesButtonLocator() {
        return phonesButtonLocator;
    }

    public ElementsCollection getProducts() {
        return products;
    }

    public SelenideElement getHomeButtonLocator() {
        return homeButtonLocator;
    }

    public SelenideElement getCartButtonLocator() {
        return cartButtonLocator;
    }

    public SelenideElement getNotebookButtonLocator() {
        return notebookButtonLocator;
    }

    public SelenideElement getMonitorsButtonLocator() {
        return monitorsButtonLocator;
    }

    /**
     * метод клика по продукту
     * возвращает наименование продукта
     *
     * @return
     */
    public String clickProduct() {
        int randomNumber = new Random().nextInt(products.size());
        String productText = products.get(randomNumber).getText();
        products.get(randomNumber).click();
        return productText;
    }
}