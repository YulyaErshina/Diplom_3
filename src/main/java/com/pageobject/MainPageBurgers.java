package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPageBurgers {

    //главная страница тестового стенда Бургеры
    public static final String HOME_PAGE_BURGERS = ("https://stellarburgers.nomoreparties.site/");

    //локатор кнопки "Личный Кабинет"
    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement personalAreaButton;
    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement signInButton;
    //локатор раздела "Начинки"
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement fillings;
    //локатор заголовка "Начинки"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Начинки']")
    private SelenideElement headerFillings;
    //локатор раздела "Начинки" после клика на него
    @FindBy(how = How.XPATH,using = ".//span[text()='Начинки']")
    private SelenideElement headerFillingsVisibleAfterClick;
    //локатор раздела "Соусы"
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement sauces;
    //локатор заголовка "Соусы"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Соусы']")
    private SelenideElement headerSauces;
    //локатор раздела "Соусы" после клика на него
    @FindBy(how = How.XPATH,using = ".//span[text()='Соусы']")
    private SelenideElement headerSaucesVisibleAfterClick;
    //локатор раздела "Булки"
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement buns;
    //локатор заголовка "Булки"
    @FindBy(how = How.XPATH,using = ".//h2[text()='Булки']")
    private SelenideElement headerBuns;
    //локатор раздела "Булки" после клика на него
    @FindBy(how = How.XPATH,using = ".//span[text()='Булки']")
    private SelenideElement headerBunsVisibleAfterClick;
    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH,using = "//section[2]/div/button[text()='Оформить заказ']")
    private SelenideElement checkoutButton;

    //метод клика по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        personalAreaButton.shouldBe(enabled).click();
    }
    //метод клика по кнопке "Войти в аккаунт"
    public void clickLoginButton() {
        signInButton.click();
    }
    //метод клика по разделу "Начинки"
    @Step("Клик по разделу \"Начинки\"")
    public void clickFilling() {
        fillings.shouldBe(exist);
        fillings.click();
    }
    //метод нахождения заголовка "Начинки"
    public boolean isHeaderFillingVisible() {
        return headerFillingsVisibleAfterClick.getText().contentEquals("Начинки");
    }
    //метод клика по разделу "Соусы"
    @Step("Клик по разделу \"Соусы\"")
    public void clickSauces() {
        sauces.shouldBe(exist);
        sauces.click();
    }
    //метод нахождения заголовка "Соусы"
    public boolean isHeaderSaucesVisible() {
        return headerSaucesVisibleAfterClick.getText().contentEquals("Соусы");
    }
    //метод клика по разделу "Булки"
    @Step("Клик по разделу \"Булки\"")
    public void clickBuns() {
        buns.shouldBe(exist);
        buns.click();
    }
    //метод нахождения заголовка "Булки"
    public boolean isHeaderBunsVisible() {
        return headerBunsVisibleAfterClick.getText().contentEquals("Булки");
    }
    //метод нахождения кнопки "Оформить заказ"
    public boolean isCheckoutButtonDisplayed() {
        checkoutButton.shouldBe(exist);
        return checkoutButton.isDisplayed();
    }

    //получение урла страницы
    public String getUrl() {
        String urlPage = WebDriverRunner.url();
        return urlPage;
    }
}