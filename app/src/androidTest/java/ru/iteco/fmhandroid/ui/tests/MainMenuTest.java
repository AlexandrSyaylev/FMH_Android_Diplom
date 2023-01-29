package ru.iteco.fmhandroid.ui.tests;


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

public class MainMenuTest extends BeforeTestLogin {

    @Description("Проверка раскрывающегося меню (навигации)")
    @Story("Проверка Раскрывающегося Меню")
    @DisplayName("п70,71,73,74 При нажатии на икноку меню на Главной Странице появляется ракрывающееся меню")
    @Test
    public void menuShouldHaveRequiredElements() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.mainPageButtonCheck();
        clickBack();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.mainPageButtonNotClickCheck();

        MainMenuPage.newsPageButtonCheck();
        MainMenuPage.aboutPageButtonCheck();
        MainMenuPage.claimPageButtonCheck();
        clickBack();
    }

    @Description("Проверка раскрывающегося меню (навигации)")
    @Story("Проверка Раскрывающегося Меню")
    @DisplayName("п76,77, 79-81, 83- Если авторизованным пользователем нажать выход, при повторном запуске отображается страница Авторизации")
    @Test
    public void shouldOpenCascadePageA() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        NewsPage.titleNewsHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonNotClickCheck();
        clickBack(); //close menu
        clickBack(); //step from checklist
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.claimPageButtonClick();
        ClaimPage.titleClaimHeaderCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.claimPageButtonNotClickCheck();
        clickBack(); //close menu
        clickBack(); //step from checklist p83
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.aboutPageButtonClick();
        AboutPage.versionTitleIdCheck();

        clickBack(); //step from checklist p86
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick();
        MainMenuPage.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick(); //NEWS from claim
        MainMenuPage.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        NewsPage.titleNewsHeaderCheck();

        HeaderPage.mainMenuButtonClick(); //about from claim
        MainMenuPage.claimPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.aboutPageButtonClick();
        AboutPage.versionTitleIdCheck();
        clickBack();

        HeaderPage.mainMenuButtonClick(); //Main from news
        MainMenuPage.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.mainPageButtonClick();
        MainPage.newsHeaderTitleCheck();

        HeaderPage.mainMenuButtonClick(); //Claim from news
        MainMenuPage.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.claimPageButtonClick();
        ClaimPage.titleClaimHeaderCheck();

        HeaderPage.mainMenuButtonClick(); //about from news
        MainMenuPage.newsPageButtonClick();
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.aboutPageButtonClick();
        AboutPage.versionTitleIdCheck();
        clickBack();
    }
}
