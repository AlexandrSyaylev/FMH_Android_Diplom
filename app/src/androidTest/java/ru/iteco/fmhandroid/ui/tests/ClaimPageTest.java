package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.pages.ClaimCard;
import ru.iteco.fmhandroid.ui.pages.ClaimPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;

public class ClaimPageTest extends BeforeTestLogin {
    @Before
    public void openClaimPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.claimPageButtonClick();
    }

    @Description("Проверка страницы Заявки")
    @Story("Проверка страницы Заявки")
    @DisplayName("п141-146, 148,150 На странице Заявки представлен заголовок Заявки")
    @Test
    public void shouldHaveRequiredElements(){
        ClaimPage.titleClaimHeaderCheck();
        ClaimPage.filterButtonCheck();
        ClaimPage.addNewClaimButtonCheck();
       ClaimCard.cardShortCheck();
    }

    @Description("Проверка страницы Заявки")
    @Story("Проверка страницы Заявки")
    @DisplayName("п70,71,73,74 При нажатии на икноку меню на Главной Странице появляется ракрывающееся меню")
    @Test
    public void shouldOpenClaimCardWenTapClaim(){
        onView(withIndex(withId(R.id.claim_list_card), 0)).perform(click());
        pauseShort();
        ClaimCard.claimThemeTitleFullCheck();
    }

    @Description("Страница информации о заявке")
    @Story("Страница информации о заявке")
    @DisplayName("п163-165, 167-173, 177-179 При тапе по конкретной заявке на странице Заявки открывается страница информации о заявке")
    @Test
    public void cardClaimShouldHaveRequiredFields(){
        //открываем заявку без комментариев
        ClaimPage.openCardWithoutComment();
        ClaimCard.cardFullCheck();
        clickBack();
    }

    @Description("При тапе по кнопке фильтра открывается попап меню Фильтрация")
    @Story("Проверка страницы Заявки")
    @DisplayName("п153-156 При тапе по кнопке фильтра открывается попап меню Фильтрация")
    @Test
    public void shouldOpenPopupFilter(){
        ClaimPage.filterButtonClick();
        ClaimPage.filterViewCheck();
        ClaimPage.filterTitleCheck();
        ClaimPage.filterCheck();
        clickBack();
    }

    @Description("На странице Заявки отображается хедер")
    @Story("Проверка страницы Заявки")
    @DisplayName("п138-140 На странице Заявки отображается хедер")
    @Test
    public void shouldHaveHeader(){
        headerCheck();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseShort();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        headerCheck();
    }

    @Description("При тапе по кнопке + (добавить заявку) открывается страница Создание заявки")
    @Story("Проверка страницы Заявки")
    @DisplayName("п152 При тапе по кнопке + (добавить заявку) открывается страница Создание заявки + \n" +
            "п162 При нажатии на странице Создания заявки системную кнопку НАЗАД, открывается страница Заявки")
    @Test
    public void shouldOpenAddNewClaimPage(){
        ClaimPage.addNewClaimButtonClick();
        pauseShort();
        AddNewClaimPage.titleHeaderCheck();
        clickBack();
        pauseShort();
        ClaimPage.titleClaimHeaderCheck();
    }
}
