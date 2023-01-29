package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.LkMenuPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;
import ru.iteco.fmhandroid.ui.Pages.NewsCard;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class MainPageTest extends BeforeTestLogin {
    @Description("На Главной странице присутствует Хедер и он содержит ...")
    @Story("Проверка Главной страницы")
    @DisplayName("п22-27, 29 На главной странице отображается Раздел Новости")
    @Test
    public void headerHasRequiredElements() {
        headerCheck();
        MainPage.claimBlockHeaderSwipe();
        MainPage.claimShowAllButtonSwipe();
        HeaderPage.logoCheck();
        HeaderPage.lkButtonClick();
        LkMenuPage.logoutButtonCheck();
        clickBack();
    }

    @Description("На Главной странице отображается ...")
    @Story("Проверка Главной страницы")
    @DisplayName("п30,31,33,35,36-40, 48-50, 52-54,57, 59, На главной странице присутстует хедер... видимый при свайпе")
    @Test
    public void shouldHaveRequiredElements(){
        MainPage.containerNewsHeaderCheck();
        MainPage.newsContainerOneClickableCheck();
        MainPage.newsHeaderTitleCheck();

        MainPage.newsAllNewsButtonCheck();

        MainPage.countNewsIs(3);

        MainPage.newsHeaderTitleCheck();
        MainPage.newsCollapseButtonCheck();

        MainPage.newsContainerOneIsHidden();
        MainPage.newsAllNewsButtonNotCheck();
        MainPage.newsContainerClick();

        NewsCard.newsCardFullShortCheck();

        MainPage.claimBlockHeaderCheck();
        MainPage.claimBlockHeaderSwipe();
        MainPage.claimAddNewButtonCheck();
        MainPage.claimExpandButtonCheck();
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isClickable()));
        MainPage.claimShowAllButtonCheck();
    }

    @Description("На Главной странице отображается ...")
    @Story("Проверка Главной страницы")
    @DisplayName("п51 При Тапе по кнопке раскрывания подблока новостей, отображается описание")
    @Test
    public void shouldShowDescriptionFieldWhenTapNews(){
        MainPage.containerNewsHeaderClick();
    }

    @Description("При тапе по кнопке ВСЕ НОВОСТИ открывается страница новостей")
    @Story("Проверка Главной страницы")
    @DisplayName("п32 При тапе по кнопке ВСЕ НОВОСТИ открывается страница новостей")
    @Test
    public void shouldOpenPageNewsWhenTapOnButtonAllNews(){
        MainPage.newsAllNewsButtonClick();
        pauseShort();
        NewsPage.titleNewsHeaderCheck();
        clickBack();
        pauseShort();
        MainPage.claimBlockHeaderCheck();
    }

    @Description("При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Story("Проверка Главной страницы")
    @DisplayName("п60 При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Test
    public void shouldOpenPageClaimsWhenTapOnButtonAllClaims(){
        MainPage.claimShowAllButtonClick();
        pauseShort();
        ClaimPage.titleClaimHeaderCheck();
        clickBack();
        pauseShort();
        MainPage.newsHeaderTitleCheck();
    }

    @Description("При прокрутке Главного экрана Хедер не прокручивается")
    @Story("Проверка Главной страницы")
    @DisplayName("п28 При прокрутке Главного экрана Хедер не прокручивается")
    @Test
    public void shouldShowHeaderWhenSwipeUp(){
        MainPage.claimShowAllButtonSwipe();
        pauseShort();
        HeaderPage.logoCheck();
    }

    @Description("При тапе по кнопке + (добавить заявку)...")
    @Story("Проверка Главной страницы")
    @DisplayName("п66,67 При тапе по кнопке + (добавить заявку) открывается страница Создание заявки /n" +
            "При нажатии на странице Создания заявки системную кнопку НАЗАД, открывается Главная страница")
    @Test
    public void shouldOpenAddNewClaimPageWhenTapAddClaimButton(){
        MainPage.claimAddNewButtonClick();
        pauseShort();
        AddNewClaimPage.titleHeaderCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();
    }

}
