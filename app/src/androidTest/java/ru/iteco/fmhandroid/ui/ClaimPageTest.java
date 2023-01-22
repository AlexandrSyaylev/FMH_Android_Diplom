package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.ClaimCard;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;

public class ClaimPageTest extends BeforeTestLogin{
    @Before
    public void openClaimPage() {
//        login();
        pause();
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.perform(click());
        pauseShort();
    }

    @Test
    public void shouldHaveRequiredElements(){
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
        ClaimPage.titleClaimHeader.check(matches(withText("Заявки")));
        ClaimPage.filterButton.check(matches(isDisplayed()));
        ClaimPage.filterButton.check(matches(isClickable()));
        ClaimPage.addNewClaimButton.check(matches(isDisplayed()));
        ClaimPage.addNewClaimButton.check(matches(isClickable()));

        ClaimCard.claimThemeTitle.check(matches(isDisplayed()));
        ClaimCard.claimThemeDescription.check(matches(isDisplayed()));
        ClaimCard.claimExecutorTitle.check(matches(isDisplayed()));
        ClaimCard.claimExecutorName.check(matches(isDisplayed()));
        ClaimCard.claimDividerLine.check(matches(isDisplayed()));
        ClaimCard.claimDateTitle.check(matches(isDisplayed()));
        ClaimCard.claimDateValue.check(matches(isDisplayed()));
        ClaimCard.claimTimeValue.check(matches(isDisplayed()));

        onView(withIndex(withId(R.id.title_material_text_view), 0)).check(matches(withText("Тема")));
        onView(withIndex(withId(R.id.executor_name_label_material_text_view), 0)).check(matches(withText("Исполнитель")));
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 0)).check(matches(withText("Плановая дата")));
    }

    @Test
    public void shouldOpenClaimCardWenTapClaim(){
        onView(withIndex(withId(R.id.claim_list_card), 0)).perform(click());
        pauseShort();
        ClaimCard.claimThemeTitleFull.check(matches(isDisplayed()));
    }

    @Test
    public void cardClaimShouldHaveRequiredFields(){
        onView(withIndex(withId(R.id.claim_list_card), 0)).perform(click());
        pauseShort();
        ClaimCard.claimThemeTitleFull.check(matches(isDisplayed()));
        ClaimCard.claimThemeTitleTextFull.check(matches(isDisplayed()));
        ClaimCard.claimExecutorTitleFull.check(matches(isDisplayed()));
        ClaimCard.claimExecutorNameFull.check(matches(isDisplayed()));
        ClaimCard.claimDateTitleFull.check(matches(isDisplayed()));
        ClaimCard.claimDateValueFull.check(matches(isDisplayed()));
        ClaimCard.claimTimeValueFull.check(matches(isDisplayed()));
        ClaimCard.claimStatusView.check(matches(isDisplayed()));
        ClaimCard.claimDescriptionText.check(matches(isDisplayed()));
        ClaimCard.claimAuthorTitle.check(matches(isDisplayed()));
        ClaimCard.claimAuthorValue.check(matches(isDisplayed()));
        ClaimCard.claimCreateTitle.check(matches(isDisplayed()));
        ClaimCard.claimCreateDate.check(matches(isDisplayed()));
        ClaimCard.claimCreateTime.check(matches(isDisplayed()));
        ClaimCard.claimCommentBlock.check(matches(isDisplayed()));
        ClaimCard.claimCommentAddButton.check(matches(isDisplayed()));
        ClaimCard.claimCloseButton.check(matches(isDisplayed()));
        ClaimCard.claimStatusButton.check(matches(isDisplayed()));
        ClaimCard.claimEditButton.check(matches(isDisplayed()));

        ClaimCard.claimCloseButton.check(matches(isClickable()));
        ClaimCard.claimStatusButton.check(matches(isClickable()));

        ClaimCard.claimThemeTitleFull.check(matches(withText("Тема")));
        ClaimCard.claimExecutorTitleFull.check(matches(withText("Исполнитель")));
        ClaimCard.claimDateTitleFull.check(matches(withText("Плановая дата")));
        ClaimCard.claimAuthorTitle.check(matches(withText("Автор")));
        ClaimCard.claimCreateTitle.check(matches(withText("Создана")));
    }

    @Test
    public void shouldOpenPopupFilter(){
        ClaimPage.filterButton.perform(click());
        ClaimPage.filterView.check(matches(isDisplayed()));
        ClaimPage.filterTitle.check(matches(isDisplayed()));
        ClaimPage.statusOpen.check(matches(isDisplayed()));
        ClaimPage.statusInProgress.check(matches(isDisplayed()));
        ClaimPage.statusExecuted.check(matches(isDisplayed()));
        ClaimPage.statusCancelled.check(matches(isDisplayed()));
        ClaimPage.filterOkButton.check(matches(isDisplayed()));
        ClaimPage.filterCancelButton.check(matches(isDisplayed()));

        ClaimPage.filterTitle.check(matches(withText("Фильтрация")));
        ClaimPage.statusOpen.check(matches(withText("Открыта")));
        ClaimPage.statusInProgress.check(matches(withText("В работе")));
        ClaimPage.statusExecuted.check(matches(withText("Выполнена")));
        ClaimPage.statusCancelled.check(matches(withText("Отмененные")));
        ClaimPage.filterOkButton.check(matches(withText("ОК")));
        ClaimPage.filterCancelButton.check(matches(withText("Отмена")));

        ClaimPage.statusOpen.check(matches(isClickable()));
        ClaimPage.statusInProgress.check(matches(isClickable()));
        ClaimPage.statusExecuted.check(matches(isClickable()));
        ClaimPage.statusCancelled.check(matches(isClickable()));
        ClaimPage.filterOkButton.check(matches(isClickable()));
        ClaimPage.filterCancelButton.check(matches(isClickable()));
    }
}
