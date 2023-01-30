package ru.iteco.fmhandroid.ui.tests;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.pages.ClaimPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.LkMenuPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsCard;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

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
        MainPage.newsOneClickable();
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
        NewsPage.titleNewsHeaderCheck();
        clickBack();
        MainPage.claimBlockHeaderCheck();
    }

    @Description("При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Story("Проверка Главной страницы")
    @DisplayName("п60 При тапе по кнопке ВСЕ ЗАЯВКИ открывается страница Заявки")
    @Test
    public void shouldOpenPageClaimsWhenTapOnButtonAllClaims(){
        MainPage.claimShowAllButtonClick();
        ClaimPage.titleClaimHeaderCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();
    }

    @Description("При прокрутке Главного экрана Хедер не прокручивается")
    @Story("Проверка Главной страницы")
    @DisplayName("п28 При прокрутке Главного экрана Хедер не прокручивается")
    @Test
    public void shouldShowHeaderWhenSwipeUp(){
        MainPage.claimShowAllButtonSwipe();
        HeaderPage.logoCheck();
    }

    @Description("При тапе по кнопке + (добавить заявку)...")
    @Story("Проверка Главной страницы")
    @DisplayName("п66,67 При тапе по кнопке + (добавить заявку) открывается страница Создание заявки /n" +
            "При нажатии на странице Создания заявки системную кнопку НАЗАД, открывается Главная страница")
    @Test
    public void shouldOpenAddNewClaimPageWhenTapAddClaimButton(){
        MainPage.claimAddNewButtonClick();
        AddNewClaimPage.titleHeaderCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();
    }

}
