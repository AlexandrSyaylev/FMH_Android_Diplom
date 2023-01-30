package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.ClaimPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.ThematicPage;

public class ThematicPageTest extends BeforeTestLogin {
    @Before
    public void openPage(){
        HeaderPage.thematicButtonClick();
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @DisplayName("п92-100, 103, 104, 106-108 При тапе по кнопке Тематические цитаты открывается окно тематические цитаты")
    @Test
    public void shouldHaveRequiredElements(){
        HeaderPage.mainMenuButtonClick();
        clickBack();
        ThematicPage.titleTextCheck();
        menuContainCheck();

        HeaderPage.mainMenuButtonClick(); //Main from tematick
        MainMenuPage.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();//News from tematick
        MainMenuPage.newsPageButtonClick();
        NewsPage.titleNewsHeaderCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();//Claim from tematick
        MainMenuPage.claimPageButtonClick();
        ClaimPage.titleClaimHeaderCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick();//About from claim
        MainMenuPage.aboutPageButtonClick();
        AboutPage.versionTitleIdCheck();
        clickBack();

        headerCheck();

        ThematicPage.thematicBlockOneCheck();
        ThematicPage.titleTextCheck();
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @DisplayName("п105 При прокрутке цитат, если их больше видимого экрана Заголовок остается видимым (закреплен)")
    @Test
    public void shouldHaveHeaderAndHeaderShouldBeWhenSwipeUp(){
        headerCheck();
        ThematicPage.swipeUp();
        headerCheck();
        ThematicPage.titleCheck();
    }

    @Description("На странице Тематические Цитаты представлены необходимые элементы")
    @Story("Проверка Страницы Тематические Цитаты")
    @DisplayName("п99 При тапе по одному блоку блок раскрывается, отображается описание")
    @Test
    public void shouldShowDescriptionWhenTapOnCard(){
        ThematicPage.descriptionCheck();
    }
}
