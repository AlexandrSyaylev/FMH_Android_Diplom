package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.Pages.AboutPage;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class MainMenuTest extends BeforeTestLogin{

    @Description("Проверка раскрывающегося меню (навигации)")
    @Story("Проверка Раскрывающегося Меню")
    @Step("п70,71,73,74 При нажатии на икноку меню на Главной Странице появляется ракрывающееся меню")
    @Test
    public void menuShouldHaveRequiredElements() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.check(matches(isDisplayed()));
        clickBack();
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.check(matches(isDisplayed()));
        MainMenuPage.mainPageButton.check(matches(withText(MainMenuPage.mainPageTextRu)));
        MainMenuPage.mainPageButton.check(matches(not(isClickable())));

        MainMenuPage.newsPageButton.check(matches(isDisplayed()));
        MainMenuPage.newsPageButton.check(matches(withText(MainMenuPage.NewsPageTextRu)));

        MainMenuPage.aboutPageButton.check(matches(isDisplayed()));
        MainMenuPage.aboutPageButton.check(matches(withText(MainMenuPage.aboutPageTextRu)));

        MainMenuPage.claimPageButton.check(matches(isDisplayed()));
        MainMenuPage.claimPageButton.check(matches(withText(MainMenuPage.claimPageTextRu)));

        clickBack();
    }

    @Description("Проверка раскрывающегося меню (навигации)")
    @Story("Проверка Раскрывающегося Меню")
    @Step("п76,77, 79-81, 83- Если авторизованным пользователем нажать выход, при повторном запуске отображается страница Авторизации")
    @Test
    public void shouldOpenCascadePageA() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.check(matches(not(isClickable())));
        clickBack(); //close menu
        clickBack(); //step from checklist
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.perform(click());
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.check(matches(not(isClickable())));
        clickBack(); //close menu
        clickBack(); //step from checklist p83
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.aboutPageButton.perform(click());
        AboutPage.versionTitleId.check(matches(isDisplayed()));

        clickBack(); //step from checklist p86
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.perform(click());
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click()); //NEWS from claim
        MainMenuPage.claimPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click()); //about from claim
        MainMenuPage.claimPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.aboutPageButton.perform(click());
        AboutPage.versionTitleId.check(matches(isDisplayed()));
        clickBack();

        HeaderPage.mainMenuButton.perform(click()); //Main from news
        MainMenuPage.newsPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.perform(click());
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click()); //Claim from news
        MainMenuPage.newsPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.perform(click());
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.perform(click()); //about from news
        MainMenuPage.newsPageButton.perform(click());
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.aboutPageButton.perform(click());
        AboutPage.versionTitleId.check(matches(isDisplayed()));
        clickBack();
    }
}
