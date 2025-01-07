package tests;

import com.codeborne.selenide.Selenide;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты товаров в корзине")
public class AuthUserAddProductToCartTest extends TestBase {
    private MainPage mainPage = new MainPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();

    @AfterEach
    void after() {
        helpMethods
                .clickButton(mainPage.getCartButtonLocator());
        cartPage.deleteProducts();
        Assertions.assertEquals(0, cartPage.getProductsTitle().texts().size());
    }

    @Tag("authCart")
    @DisplayName("Тест на сохранение товара в корзине")
    @Test
    void addProductToCartAuthUserTest() {
        step("Авторизация при помощи апи", () -> {
            login.doLoginInUiUsingApi(authConfings.getToken());
        });
        step("Переход на страницу товаров", () -> {
            helpMethods
                    .clickButton(mainPage.getHomeButtonLocator())
                    .clickButton(mainPage.getPhonesButtonLocator());
            Selenide.sleep(1000);
        });
        String chosenProduct =
                step("Добавление товара в корзину", () -> {
                    String chosenProductToReturn = mainPage.clickProduct();
                    helpMethods
                            .clickButton(productPage.getAddToCartButtonLocator());
                    Selenide.confirm();
                    return chosenProductToReturn;
                });
        step("Вторая авторизации с помощью апи", () -> {
            Selenide.closeWebDriver();
            login.doLoginInUiUsingApi(authConfings.getToken());
        });
        step("Переход в корзину", () -> {
            helpMethods
                    .clickButton(mainPage.getCartButtonLocator());
            Selenide.sleep(1000);
        });
        step("Проверка товара в корзине", () -> {
            List<String> productsList = cartPage.getProductsTitle().texts();
            Assertions.assertTrue(productsList.contains(chosenProduct));
        });
    }
}