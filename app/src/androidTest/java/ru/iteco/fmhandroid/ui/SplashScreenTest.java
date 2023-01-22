package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import org.junit.Test;

import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.SplashScreenPage;

public class SplashScreenTest extends BasePage {
    @Test
    public void shouldHaveRequiredUIElements(){
        SplashScreenPage.imageId.check(matches(isDisplayed()));
        SplashScreenPage.progressBarId.check(matches(isDisplayed()));
        SplashScreenPage.textViewId.check(matches(isDisplayed()));
    }
}
