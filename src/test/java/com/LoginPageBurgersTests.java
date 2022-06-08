package com;

import com.codeborne.selenide.Configuration;
import com.pageobject.ForgotPasswordPageBurgers;
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
import static org.junit.Assert.assertTrue;

public class LoginPageBurgersTests {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

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
    @Description("Вход с помощью кнопки «Войти в аккаунт» на главной странице")
    public void checkLoginWithLoginButtonOnMainPageTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Войти в аккаунт"
        mainPage.clickLoginButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через кнопку «Личный кабинет» на главной странице")
    public void checkLoginWithPersonalAccountButtonOnMainPageTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через страницу регистрации")
    public void checkLoginButtonRegistrationPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Зарегистрироваться"
        loginPage.clickRegister();

        RegistrationPageBurgers registrationPage = page(RegistrationPageBurgers.class);
        //кликнуть на "Войти"
        registrationPage.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }

    @Test
    @Description("Вход через кнопку в форме восстановления пароля на странице восстановления пароля")
    public void checkLoginButtonForgotPasswordPageForLoginTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на "Личный Кабинет"
        mainPage.clickPersonalAccountButton();

        LoginPageBurgers loginPage = page(LoginPageBurgers.class);
        //кликнуть на "Восстановить пароль"
        loginPage.clickRecoverPassword();

        ForgotPasswordPageBurgers forgotPassword = page(ForgotPasswordPageBurgers.class);
        //кликнуть на "Войти"
        forgotPassword.clickLogin();

        //заполнить форму с электронной почтой и паролем
        loginPage.fillFormLogin(email, password);

        //проверить на дисплее кнопку "Оформить заказ"
        assertTrue(mainPage.isCheckoutButtonDisplayed());
    }
}


