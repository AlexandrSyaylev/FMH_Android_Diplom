package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AboutPage;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;
import ru.iteco.fmhandroid.ui.Pages.ThematicPage;

public class ThematicPageTest extends BeforeTestLogin {
    @Before
    public void openPage(){
        HeaderPage.thematicButton.perform(click());
        pauseShort();
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @Step("п92-100, 103, 104, 106-108 При тапе по кнопке Тематические цитаты открывается окно тематические цитаты")
    @Test
    public void shouldHaveRequiredElements(){
        ThematicPage.titleText.check(matches(isDisplayed()));
        HeaderPage.mainMenuButton.perform(click());
        clickBack();
        ThematicPage.titleText.check(matches(isDisplayed()));
        menuContainCheck();

        pauseShort();
        HeaderPage.mainMenuButton.perform(click()); //Main from tematick
        MainMenuPage.mainPageButton.perform(click());
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));
        clickBack();

        HeaderPage.mainMenuButton.perform(click());//News from tematick
        MainMenuPage.newsPageButton.perform(click());
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
        clickBack();

        HeaderPage.mainMenuButton.perform(click());//Claim from tematick
        MainMenuPage.claimPageButton.perform(click());
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
        clickBack();

        HeaderPage.mainMenuButton.perform(click());//About from claim
        MainMenuPage.aboutPageButton.perform(click());
        AboutPage.versionTitleId.check(matches(isDisplayed()));
        clickBack();

        headerCheck();

        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(not(isDisplayed())));
        ThematicPage.titleText.check(matches(withText("Главное - жить любя")));
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @Step("п105 При прокрутке цитат, если их больше видимого экрана Заголовок остается видимым (закреплен)")
    @Test
    public void shouldHaveHeaderAndHeaderShouldBeWhenSwipeUp(){
        headerCheck();
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 2)).perform(customSwipeUp());
        headerCheck();
        ThematicPage.titleText.check(matches(isDisplayed()));
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @Step("п99 При тапе по одному блоку блок раскрывается, отображается описание")
    @Test
    public void shouldShowDescriptionWhenTapOnCard(){
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).perform(click());
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
    }
}
