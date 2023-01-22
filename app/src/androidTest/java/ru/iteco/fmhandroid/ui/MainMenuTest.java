package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Test;

import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;

public class MainMenuTest extends BeforeTestLogin{

    @Test
    public void menuShouldHaveRequiredElements() {
        HeaderPage.mainMenuButton.perform(click());

        MainMenuPage.mainPageButton.check(matches(isDisplayed()));
        MainMenuPage.mainPageButton.check(matches(withText(MainMenuPage.mainPageTextRu)));

        MainMenuPage.newsPageButton.check(matches(isDisplayed()));
        MainMenuPage.newsPageButton.check(matches(withText(MainMenuPage.NewsPageTextRu)));

        MainMenuPage.aboutPageButton.check(matches(isDisplayed()));
        MainMenuPage.aboutPageButton.check(matches(withText(MainMenuPage.aboutPageTextRu)));

        MainMenuPage.claimPageButton.check(matches(isDisplayed()));
        MainMenuPage.claimPageButton.check(matches(withText(MainMenuPage.claimPageTextRu)));

        clickBack();
    }
}
