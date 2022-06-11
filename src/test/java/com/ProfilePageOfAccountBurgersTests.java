package com;

import com.codeborne.selenide.Configuration;
import com.pageobject.ProfilePageOfAccountBurgers;
import com.pageobject.LoginPageBurgers;
import com.pageobject.MainPageBurgers;
import com.pageobject.RegistrationPageBurgers;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.HOME_PAGE_BURGERS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfilePageOfAccountBurgersTests {

    static String name = RandomStringUtils.randomAlphabetic(10);
    static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    static String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setup() {

        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //заполнить форму с именем, электронной почтой и паролем
        registrationPage.fillFormRegistration(name, email, password);
    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Клик на Личный кабинет")
    public void checkAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        ProfilePageOfAccountBurgers accountProfile = page(ProfilePageOfAccountBurgers.class);
        //проверить на дисплее "Выход"
        assertTrue(accountProfile.isExitDisplayed());
    }

    @Test
    @Description("Клик на Конструктор")
    public void checkConstructorFromAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        ProfilePageOfAccountBurgers accountProfile = page(ProfilePageOfAccountBurgers.class);
        //кликнуть на "Конструктор"
        accountProfile.clickConstructorButton();

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Переход по клику на логотип Stellar Burgers")
    public void goToMainPageByClickOnLogoTest() {
        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        ProfilePageOfAccountBurgers accountProfile = page(ProfilePageOfAccountBurgers.class);

        //Клик по логотипу
        accountProfile.clickLogoStellar();

        //проверка, что открыта нужная страница
       assertEquals(mainPage.getUrl(), HOME_PAGE_BURGERS);
    }

    @Test
    @Description("При клике на кнопку Выход происходит выход из профиля")
    public void checkLogoutFromAccountProfileTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        ProfilePageOfAccountBurgers accountProfile = page(ProfilePageOfAccountBurgers.class);
        //кликнуть на "Выход"
        accountProfile.clickExit();

        //проверить на дисплее кнопку "Войти"
        assertTrue(loginPage.isLoginButtonDisplayed());
    }
}
