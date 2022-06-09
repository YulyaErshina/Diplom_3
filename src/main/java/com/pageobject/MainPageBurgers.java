package com.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
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
    // кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;
//    // кнопка "Лента заказов"
//    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Лента Заказов')]")
//    private SelenideElement feedButton;
    // элемент "Булок" - Флюоресцентная булка R2-D3
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/bun-01.png']")
    private SelenideElement bunsElement;
    // элемент "Соусов" - Соус Spicy-X
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/sauce-02.png']")
    private SelenideElement saucesElement;
    // элемент "Начинок" - Мясо бессмертных моллюсков Protostomia
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/meat-02.png']")
    private SelenideElement fillingsElement;
    // поле "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsField;
    // поле "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesField;
    // поле "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsField;
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

    //метод нахождения кнопки "Оформить заказ"
    public boolean isCheckoutButtonDisplayed() {
        checkoutButton.shouldBe(exist);
        return checkoutButton.isDisplayed();
    }

    //метод клика по "Булки"
    public MainPageBurgers clickByBuns() {
        bunsField.click();
        return this;
    }

    //метод клика по "Соусы"
    public MainPageBurgers clickBySauces() {
        saucesField.click();
        return this;
    }

    //метод клика по "Начинки"
    public MainPageBurgers clickByFillings() {
        fillingsField.click();
        return this;
    }

    //элемент из раздела "Булки" отображается
    public boolean isDisplayedBuns() {
        return bunsElement.isDisplayed();
    }

    //элемент из раздела "Соусы" отображается
    public boolean isDisplayedSauces() {
        return saucesElement.isDisplayed();
    }

    //элемент из раздела "Начинки" отображается
    public boolean isDisplayedMeats() {
        return fillingsElement.isDisplayed();
    }

    //скролл до раздела "Начинки"
    public MainPageBurgers scrollToFillings() {
        fillingsElement.scrollIntoView(true);
        return this;
    }

    //получение урла страницы
    public String getUrl() {
        String urlPage = WebDriverRunner.url();
        return urlPage;
    }
}