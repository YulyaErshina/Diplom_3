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
    @Description("Клик на раздел Начинки")
    public void checkClickFillingsTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на раздел "Начинки"
        mainPage.clickFilling();

        //Проверить на дисплее после перехода в раздел "Начинки"
        assertTrue("Нахождение не в разделе 'Начинки'", mainPage.isHeaderFillingVisible());
    }

    @Test
    @Description("Клик на раздел Булки")
    public void checkClickBunsTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //проверить на дисплее заголовок "Булки"
        assertTrue(mainPage.isHeaderBunsVisible());
    }

    @Test
    @Description("Клик на раздел Соусы")
    public void checkClickSaucesTest() {

        //перейти на страницу тестового стенда
        MainPageBurgers mainPage = open(HOME_PAGE_BURGERS, MainPageBurgers.class);

        //кликнуть на раздел "Соусы"
        mainPage.clickSauces();

        //проверить на дисплее после перехода в раздел "Начинки"
        assertTrue("Нахождение не в разделе 'Соусы'", mainPage.isHeaderSaucesVisible());
    }
}
