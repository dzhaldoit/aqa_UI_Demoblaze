package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$$x;

public class CartPage {

    private ElementsCollection
            productsTitle = $$x("//tbody//td[2]"),
            deleteButton = $$x("//a[text() = 'Delete']");

    public ElementsCollection getProductsTitle() {
        return productsTitle;
    }

    public void deleteProducts() {
        for (int i = deleteButton.size(); i > 0; i--) {
            deleteButton.get(i - 1).click();
            Selenide.sleep(1000);
        }
    }
}