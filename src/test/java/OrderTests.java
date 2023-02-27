import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;

import static config.WebDriverConfig.WAIT_SECONDS_TIMEOUT;
import static junit.framework.TestCase.assertTrue;


@RunWith(Parameterized.class)
public class OrderTests {

    private WebDriver driver;
    private String button;
    private String firstName;
    private String secondName;
    private String address;
    private int metroStation;
    private String telephoneNumber;
    private String date;
    private int daysRent;
    private String color;
    private String comment;

    public OrderTests(String button, String firstName, String secondName, String address,
                      int metroStation, String telephoneNumber, String date, int daysToDeliver,
                      String color, String comment) {
        this.button = button;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.daysRent = daysToDeliver;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"headButton", "Николай", "Степаненко", "ул. Боро-боро д.3 кв.8", 1, "89202223311",
                        "26.02.2023", 1, "серая безысходность", "СПАСИБО!"},
                {"bottomButton", "Роман", "Игнатьев", "ул. Помогите д.666 кв.13", 4, "89202323311",
                        "25.02.2023", 2, "чёрный жемчуг", "Нужны дополнительные колёсики..."},
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.get("chrome");
    }

    /* Так как имеет место баг с невозможность оформить заказ. Тест падает.
    Цитата из тренажёра:
    "Обрати внимание: в приложении есть баг, который не даёт оформить заказ. Он воспроизводится только в Chrome."*/

    // Основной Тест №2 Проверка позитивных сценариев
    @Test
    public void checkOrderButtonAndPositiveOrderCase() {
        boolean isStatusOrderWindowVisibleAfterOrder = new MainPage(driver)
                .clickAnyOrderButton(button)
                .inputFirstName(firstName)
                .inputSecondName(secondName)
                .inputAddressField(address)
                .chooseMetroStation(metroStation)
                .inputTelephoneNumber(telephoneNumber)
                .clickNextPageButton()
                .chooseDate(date)
                .chooseDaysRent(daysRent)
                .chooseColor(color)
                .inputComment(comment)
                .clickOrderButton()
                .clickYesButton()
                .isStatusOrderWindowVisible();
        assertTrue(isStatusOrderWindowVisibleAfterOrder);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
