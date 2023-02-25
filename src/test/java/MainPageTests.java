import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.net.URL;

import static junit.framework.TestCase.*;



public class MainPageTests {

    private WebDriver driver;
    private final String incorrectOrderNum = "111";


    @Before
        public void setup() {
            driver = WebDriverFactory.get();
        }


        //Дополнительный Тест №1 Проверка лого Самоката
        @Test
        public void checkSamokatLogoToSamokatMainPage() {
            new MainPage(driver).clickSamokatLogo();
            String actual = driver.getCurrentUrl();
            String expected = AppConfig.URL;
            assertEquals("Не удалось попасть на главную страницу Самоката", actual, expected);
        }

        //Дополнительный Тест №2 Проверка перехода на страницу Яндекса при нажатии на его логотип
        @Test
        public void checkYandexLogoToYandexPage() {
            MainPage main = new MainPage(driver);
            main.clickYandexLogo();
            main.switchToWindow(1);
            String actual = driver.getCurrentUrl();
            String expected = AppConfig.Yandex_URL;
            assertEquals("В новом окне открылась неверная страница при нажатии на логотип Яндекса",
                    actual, expected);
        }

        //Дополнительный Тест №4 Проверка несуществующего заказа.
        @Test
        public void checkErrorInCaseOfNonexistentOrder() {
            boolean isOrderNotFoundVisible = new MainPage(driver)
                    .clickOrderStatusButton()
                    .inputOrderNumber(incorrectOrderNum)
                    .clickSearchButton()
                    .isContainerOrderNotFoundVisible();
            assertTrue(isOrderNotFoundVisible);
        }

        @After
        public void teardown() {
            driver.quit();
        }

}
