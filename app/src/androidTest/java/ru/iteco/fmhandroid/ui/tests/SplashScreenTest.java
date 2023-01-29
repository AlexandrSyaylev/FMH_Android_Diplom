package ru.iteco.fmhandroid.ui.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.pages.BasePage;
import ru.iteco.fmhandroid.ui.pages.SplashScreenPage;

@RunWith(AllureAndroidJUnit4.class)
public class SplashScreenTest extends BasePage {
    @Description("На Стартовой странице представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @DisplayName("На Стартовой странице представлены необходимые элементы")
    @Test
    public void shouldHaveRequiredUIElements(){
        SplashScreenPage.screenSplashCheK();
    }
}
