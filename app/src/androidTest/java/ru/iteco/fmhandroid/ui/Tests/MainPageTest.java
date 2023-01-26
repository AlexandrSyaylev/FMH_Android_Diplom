package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.LkMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;
import ru.iteco.fmhandroid.ui.Pages.NewsCard;

public class MainPageTest extends BeforeTestLogin {
    @Description("На Главной странице присутствует Хедер и он содержит ...")
    @Story("Проверка Главной страницы")
    @Step("п22-27, 29 На главной странице отображается Раздел Новости")
    @Test
    public void headerHasRequiredElements() {
        headerCheck();
        MainPage.claimBlockHeader.perform(swipeUp());
        MainPage.claimShowAllButton.perform(swipeUp());
        HeaderPage.logoView.check(matches(isDisplayed()));
        HeaderPage.lkButton.perform(click());
        LkMenuPage.logoutButton.check(matches(isDisplayed()));
        clickBack();
    }

    @Description("На Главной странице отображается ...")
    @Story("Проверка Главной страницы")
    @Step("п30,31,33,35,36-40, 48-50, 52-54,57, 59, На главной странице присутстует хедер... видимый при свайпе")
    @Test
    public void shouldHaveRequiredElements(){
        MainPage.containerNewsHeader.check(matches(isDisplayed()));
        MainPage.newsContainerOneClickable.check(matches(isDisplayed()));
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));

        MainPage.newsAllNewsButton.check(matches(isDisplayed()));
        MainPage.newsAllNewsButton.check(matches(withText("ВСЕ НОВОСТИ")));

        MainPage.countNewsIs(3);

        MainPage.newsHeaderTitle.check(matches(withText("Новости")));
        MainPage.newsCollapseButton.check(matches(isDisplayed()));

        MainPage.newsContainerOneIsHidden();
        MainPage.newsAllNewsButton.check(matches(not(isDisplayed())));
        MainPage.newsContainerClick();

        NewsCard.newsTitle.check(matches(isDisplayed()));
        NewsCard.newsCategoryImage.check(matches(isDisplayed()));
        NewsCard.newsDate.check(matches(isDisplayed()));
        NewsCard.newsDescription.check(matches(not(isDisplayed())));

        MainPage.claimBlockHeader.check(matches(isDisplayed()));
        MainPage.claimBlockHeader.check(matches(withText("Заявки")));
        MainPage.claimBlockHeader.perform(swipeUp());
        MainPage.claimAddNewButton.check(matches(isDisplayed()));
        MainPage.claimExpandButton.check(matches(isDisplayed()));
        MainPage.claimShowAllButton.check(matches(isDisplayed()));
        MainPage.claimAddNewButton.check(matches(isClickable()));
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isClickable()));
        MainPage.claimShowAllButton.check(matches(isClickable()));
        MainPage.claimShowAllButton.check(matches(withText("ВСЕ ЗАЯВКИ")));
    }

    @Description("На Главной странице отображается ...")
    @Story("Проверка Главной страницы")
    @Step("п51 При Тапе по кнопке раскрывания подблока новостей, отображается описание")
    @Test
    public void shouldShowDescriptionFieldWhenTapNews(){
        MainPage.containerNewsHeader.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 1)).check(matches(isDisplayed()));
    }

    @Description("При тапе по кнопке ВСЕ НОВОСТИ открывается страница новостей")
    @Story("Проверка Главной страницы")
    @Step("п32 При тапе по кнопке ВСЕ НОВОСТИ открывается страница новостей")
    @Test
    public void shouldOpenPageNewsWhenTapOnButtonAllNews(){
        MainPage.newsAllNewsButton.perform(click());
        pauseShort();
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        MainPage.claimBlockHeader.check(matches(isDisplayed()));
    }

    @Description("При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Story("Проверка Главной страницы")
    @Step("п60 При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Test
    public void shouldOpenPageClaimsWhenTapOnButtonAllClaims(){
        MainPage.claimShowAllButton.perform(click());
        pauseShort();
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));
    }

    @Description("При прокрутке Главного экрана Хедер не прокручивается")
    @Story("Проверка Главной страницы")
    @Step("п28 При прокрутке Главного экрана Хедер не прокручивается")
    @Test
    public void shouldShowHeaderWhenSwipeUp(){
        MainPage.claimShowAllButton.perform(customSwipeUp());
        pauseShort();
        HeaderPage.logoView.check(matches(isDisplayed()));
    }

    @Description("При тапе по кнопке + (добавить заявку)...")
    @Story("Проверка Главной страницы")
    @Step("п66,67 При тапе по кнопке + (добавить заявку) открывается страница Создание заявки /n" +
            "При нажатии на странице Создания заявки системную кнопку НАЗАД, открывается Главная страница")
    @Test
    public void shouldOpenAddNewClaimPageWhenTapAddClaimButton(){
        MainPage.claimAddNewButton.perform(click());
        pauseShort();
        AddNewClaimPage.titleHeader.check(matches(isDisplayed()));
        clickBack();
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));
    }

}
