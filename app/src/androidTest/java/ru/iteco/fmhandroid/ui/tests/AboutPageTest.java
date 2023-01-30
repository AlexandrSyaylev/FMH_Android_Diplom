package ru.iteco.fmhandroid.ui.tests;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;

public class AboutPageTest extends BeforeTestLogin {
    @Description("На странице О приложении представлены необходимые элементы")
    @Story("Проверка Страницы о Приложении")
    @DisplayName("п124 - 129, 132,133, 137 На странице О приложении представлен Хедер \n -" +
            "На странице представлен текст (знак копирайт)\"Айтеко , 2022\"")
    @Test
    public void shouldHaveRequiredUIElements(){
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.aboutPageButtonClick();
        AboutPage.versionTitleIdCheck();
        AboutPage.backButtonCheck();
        AboutPage.logoCheck();
        AboutPage.versionTextIdCheck();
        AboutPage.policyTextIdCheck();
        AboutPage.policyLinkIdCheck();
        AboutPage.userAgreementTextIdCheck();
        AboutPage.userAgreementLinkIdCheck();
        AboutPage.companyIdCheck();
        AboutPage.backButtonClick();
    }
}
