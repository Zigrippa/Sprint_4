import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static junit.framework.TestCase.assertTrue;


public class OrderFieldsTests {

    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    // Дополнительный Тест №3 Проверка ошибок для всех полей формы заказа.
    @Test
    public void checkWrongFirstNameInput() {
        boolean isErrorVisible = new MainPage(driver)
                .clickOrderButtonHead()
                .inputFirstName("123")
                .clickNextPageButton()
                .isErrorFirstNameVisible();
        assertTrue(isErrorVisible);
    }

    @Test
    public void checkWrongSecondNameInput() {
        boolean isErrorVisible = new MainPage(driver)
                .clickOrderButtonHead()
                .inputSecondName("123")
                .clickNextPageButton()
                .isErrorSecondNameVisible();
        assertTrue(isErrorVisible);
    }

    @Test
    public void checkWrongAddressInput() {
        boolean isErrorVisible = new MainPage(driver)
                .clickOrderButtonHead()
                .inputAddressField("123")
                .clickNextPageButton()
                .isErrorAddressVisible();
        assertTrue(isErrorVisible);
    }

    @Test
    public void checkWrongMetroStationInput() {
        boolean isErrorVisible = new MainPage(driver)
                .clickOrderButtonHead()
                .clickNextPageButton()
                .isErrorMetroStationVisible();
        assertTrue(isErrorVisible);
    }

    @Test
    public void checkWrongTelephoneInput() {
        boolean isErrorVisible = new MainPage(driver)
                .clickOrderButtonHead()
                .inputTelephoneNumber("123")
                .clickNextPageButton()
                .isErrorTelephoneVisible();
        assertTrue(isErrorVisible);
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
