package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage {
    private final WebDriver driver;

    private final By orderButtonHead = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private final By orderButtonBottom = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    private final By samokatLogo = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/a[2]/img");
    private final By yandexLogo = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[1]/a[1]/img");
    private final By orderStatusButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[2]");
    private final By orderNumInput = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/div/input");
    private final By searchOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button");

    private final ArrayList<By> questions = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"accordion__heading-0\"]"), By.xpath("//*[@id=\"accordion__heading-1\"]"),
            By.xpath("//*[@id=\"accordion__heading-2\"]"), By.xpath("//*[@id=\"accordion__heading-3\"]"),
            By.xpath("//*[@id=\"accordion__heading-4\"]"), By.xpath("//*[@id=\"accordion__heading-5\"]"),
            By.xpath("//*[@id=\"accordion__heading-6\"]"), By.xpath("//*[@id=\"accordion__heading-7\"]")));
    private final ArrayList<By> answers = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"accordion__panel-0\"]/p"), By.xpath("//*[@id=\"accordion__panel-1\"]/p"),
            By.xpath("//*[@id=\"accordion__panel-2\"]/p"), By.xpath("//*[@id=\"accordion__panel-3\"]/p"),
            By.xpath("//*[@id=\"accordion__panel-4\"]/p"), By.xpath("//*[@id=\"accordion__panel-5\"]/p"),
            By.xpath("//*[@id=\"accordion__panel-6\"]/p"), By.xpath("//*[@id=\"accordion__panel-7\"]/p")));


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public MainPage clickAnyQuestionButton(int number) {
        driver.findElement(questions.get(number)).click();
        return this;
    }

    public OrderPage clickOrderButtonHead() {
        driver.findElement(orderButtonHead).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
        return new OrderPage(driver);
    }

    public OrderPage clickAnyOrderButton(String button) {
        if (button.equals("headButton")){
            driver.findElement(orderButtonHead).click();
        } else if (button.equals("bottomButton")) {
            driver.findElement(orderButtonBottom).click();
        }
        return new OrderPage(driver);
    }

    public MainPage scrollPageToQuestions() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]")));
        return this;
    }

    public MainPage scrollPageToOrderButtonBottom() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(orderButtonBottom));
        return this;
    }

    public String returnAnswerToQuestion(int number) {
        return driver.findElement(answers.get(number)).getText();
    }


    public void clickSamokatLogo() {
        driver.findElement(samokatLogo).click();
    }

    public void clickYandexLogo() {
        driver.findElement(yandexLogo).click();
    }

    public void switchToWindow(int numberWindow) {
        String handle = driver.getWindowHandles().toArray()[numberWindow]
                .toString();
        driver.switchTo().window(handle);
    }

    public MainPage clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    public MainPage inputOrderNumber(String orderNum) {
        driver.findElement(orderNumInput).sendKeys(orderNum);
        return this;
    }

    public TrackOrderPage clickSearchButton() {
        driver.findElement(searchOrderButton).click();
        return new TrackOrderPage(driver);
    }
}
