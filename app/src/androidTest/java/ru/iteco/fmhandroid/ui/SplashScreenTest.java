package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static io.qameta.allure.kotlin.Allure.step;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.SplashScreenPage;

public class SplashScreenTest extends BasePage {
    @Description("На Стартовой странице представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @Test
    public void shouldHaveRequiredUIElements(){
        SplashScreenPage.imageId.check(matches(isDisplayed()));
        SplashScreenPage.progressBarId.check(matches(isDisplayed()));
        SplashScreenPage.textViewId.check(matches(isDisplayed()));
    }
}
