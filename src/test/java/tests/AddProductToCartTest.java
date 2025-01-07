package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@DisplayName("Тесты на добавление товара в корзину")
public class AddProductToCartTest extends TestBase {
    private static MainPage mainPage = new MainPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();

    static Stream<Arguments> addProductToCartTest() {
        return Stream.of(
                Arguments.of(mainPage.getPhonesButtonLocator()),
                Arguments.of(mainPage.getNotebookButtonLocator()),
                Arguments.of(mainPage.getMonitorsButtonLocator())
        );
    }

    @Tag("cartTest")
    @DisplayName("Тест на добавление товара в корзину")
    @MethodSource()
    @ParameterizedTest()
    void addProductToCartTest(SelenideElement element) {
        step("Переход на сайт", () -> {
            Selenide.open("/");
        });
        String chosenProduct =
                step("Выбор товара на главной странице", () -> {
                    helpMethods
                            .clickButton(mainPage.getHomeButtonLocator())
                            .clickButton(element);
                    Selenide.sleep(1000);
                    return mainPage.clickProduct();
                });
        step("Добавление товара в корзину", () -> {
            helpMethods
                    .clickButton(productPage.getAddToCartButtonLocator());
            Selenide.confirm();
        });
        step("Переход в корзину", () -> {
            helpMethods
                    .clickButton(mainPage.getCartButtonLocator());
            Selenide.sleep(1000);
        });
        step("Проверка наличия товара в корзине", () -> {
            List<String> productsList = cartPage.getProductsTitle().texts();
            Assertions.assertTrue(productsList.contains(chosenProduct));
        });
    }
}