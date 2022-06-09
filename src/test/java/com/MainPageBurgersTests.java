package com;

import com.codeborne.selenide.Configuration;
import com.pageobject.*;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.pageobject.MainPageBurgers.HOME_PAGE_BURGERS;
import static org.junit.Assert.assertTrue;

public class MainPageBurgersTests {

    @Before
    public void setup() {
        //открыть браузер в максимальном разрешении
        Configuration.startMaximized = true;

    }

    @After
    public void tearDown() {
        //закрыть браузер
        closeWebDriver();
    }

    @Test
    @Description("Переход к разделу «Булки» работает")
    public void checkSpanBunsConstructorIsAvailable() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);
        //проскроллить до начинки
        mainPage.scrollToFillings();
        //кликнуть на "Булки"
        mainPage.clickByBuns();
        //проверить, что элементы булок отображены
        assertTrue(mainPage.isDisplayedBuns());
    }

    @Test
    @Description("Переход к разделу «Соусы» работает")
    public void checkSpanSaucesConstructorIsAvailable() {
        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);
        //кликнуть на "Соусы"
        mainPage.clickBySauces();
        //проверить, что элементы соусов отображены
        assertTrue(mainPage.isDisplayedSauces());
    }

    @Test
    @Description("Переход к разделу «Начинки» работает")
    public void checkSpanMeatsConstructorIsAvailable() {
        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);
        //кликнуть на "Начинки"
        mainPage.clickByFillings();
        //проверить, что элементы начинок отображены
        assertTrue(mainPage.isDisplayedMeats());
    }
}
