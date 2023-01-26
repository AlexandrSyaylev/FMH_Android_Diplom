package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static io.qameta.allure.kotlin.Allure.step;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.SplashScreenPage;

@RunWith(AllureAndroidJUnit4.class)
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
