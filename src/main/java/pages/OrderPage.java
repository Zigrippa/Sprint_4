package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderPage {
    private final WebDriver driver;

    private final By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private final By secondNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private final By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private final By metroStationField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    private final ArrayList<By> metroStationDropMenu = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[225]")));

    private final By telephoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    private final By nextPageButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    private final By dateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");

    private final By daysRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/span");
    private final ArrayList<By> daysRentDropMenu = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[5]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[6]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[7]")));
    private final ArrayList<By> checkBoxColor = new ArrayList<>(Arrays.asList(
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]"),
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[2]")));
    private final By commentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    private final By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private final By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    private final By confirmOrderWindow = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]");
    private final By statusOrderWindow = By.id("Order_ModalHeader__3FDaJ");
    private final By errorFirstNameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div");
    private final By errorSecondNameInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div");
    private final By errorAddressInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div");
    private final By errorMetroStationInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div[2]");
    private final By errorTelephoneInput = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div");



    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage inputFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public OrderPage inputSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
        return this;
    }

    public OrderPage inputAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public OrderPage chooseMetroStation(int metro) {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationDropMenu.get(1)).click();
        return this;
    }

    public OrderPage inputTelephoneNumber(String telephoneNumber) {
        driver.findElement(telephoneField).sendKeys(telephoneNumber);
        return this;
    }

    public OrderPage clickNextPageButton() {
        driver.findElement(nextPageButton).click();
        return this;
    }

    public OrderPage chooseDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        return this;
    }

    public OrderPage chooseDaysRent(int numberOfDays) {
        driver.findElement(daysRent).click();
        driver.findElement(daysRentDropMenu.get(numberOfDays)).click();
        return this;
    }

    public OrderPage chooseColor(String whichColor) {
        switch (whichColor) {
            case "чёрный жемчуг":
                driver.findElement(checkBoxColor.get(0)).click();
                break;
            case "серая безысходность":
                driver.findElement(checkBoxColor.get(1)).click();
                break;
        }
        return this;
    }

    public OrderPage inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    public OrderPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPage clickYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }

    public boolean isStatusOrderWindowVisible() {
        return driver.findElement(statusOrderWindow).isDisplayed();
    }

    public boolean isConfirmOrderWindowVisible() {
        return driver.findElement(confirmOrderWindow).isDisplayed();
    }

    public boolean isErrorFirstNameVisible() {
        return driver.findElement(errorFirstNameInput).isDisplayed();
    }

    public boolean isErrorSecondNameVisible() {
        return driver.findElement(errorSecondNameInput).isDisplayed();
    }

    public boolean isErrorAddressVisible() {
        return driver.findElement(errorAddressInput).isDisplayed();
    }

    public boolean isErrorMetroStationVisible() {
        return driver.findElement(errorMetroStationInput).isDisplayed();
    }

    public boolean isErrorTelephoneVisible() {
        return driver.findElement(errorTelephoneInput).isDisplayed();
    }
}
