package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ClaimCard extends BasePage{
    private static ViewInteraction claimOneContainer = onView(withIndex(withId(R.id.claim_list_card), 0));
    private static ViewInteraction claimThemeTitle = onView(withIndex(withId(R.id.title_material_text_view), 0));
    private static ViewInteraction claimThemeTitleText = onView(withId(R.id.title_material_text_view));
    private static ViewInteraction claimThemeDescription = onView(withIndex(withId(R.id.description_material_text_view), 0));
    private static ViewInteraction claimExecutorTitle = onView(withIndex(withId(R.id.executor_name_label_material_text_view), 0));
    private static ViewInteraction claimExecutorName = onView(withIndex(withId(R.id.executor_name_material_text_view), 0));
    private static ViewInteraction claimDividerLine = onView(withIndex(withId(R.id.claim_middle_divider_image_view), 0));
    private static ViewInteraction claimDateTitle = onView(withIndex(withId(R.id.plan_date_label_material_text_view), 0));
    private static ViewInteraction claimDateValue = onView(withIndex(withId(R.id.plan_date_material_text_view), 0));
    private static ViewInteraction claimTimeValue = onView(withIndex(withId(R.id.plan_time_material_text_view), 0));

    //claim full view
    private static ViewInteraction claimThemeTitleFull = onView(withId(R.id.title_label_text_view));
    private static ViewInteraction claimThemeTitleTextFull = onView(withId(R.id.title_text_view));
    private static ViewInteraction claimExecutorTitleFull = onView(withId(R.id.executor_name_label_text_view));
    private static ViewInteraction claimExecutorNameFull = onView(withId(R.id.executor_name_text_view));
    private static ViewInteraction claimDateTitleFull = onView(withId(R.id.plane_date_label_text_view));
    private static ViewInteraction claimDateValueFull = onView(withId(R.id.plane_date_text_view));
    private static ViewInteraction claimTimeValueFull = onView(withId(R.id.plan_time_text_view));
    private static ViewInteraction claimStatusView = onView(withId(R.id.status_icon_image_view));
    private static ViewInteraction claimDescriptionText = onView(withId(R.id.description_text_view));
    private static ViewInteraction claimAuthorTitle = onView(withId(R.id.author_label_text_view));
    private static ViewInteraction claimAuthorValue = onView(withId(R.id.author_name_text_view));
    private static ViewInteraction claimCreateTitle = onView(withId(R.id.create_data_label_text_view));
    private static ViewInteraction claimCreateDate = onView(withId(R.id.create_data_text_view));
    private static ViewInteraction claimCreateTime = onView(withId(R.id.create_time_text_view));
    private static ViewInteraction claimCommentBlock = onView(withId(R.id.comments_material_card_view));
    private static ViewInteraction claimCommentAddButton = onView(withId(R.id.add_comment_image_button));
    private static ViewInteraction claimCloseButton = onView(withId(R.id.close_image_button));
    private static ViewInteraction claimStatusButton = onView(withId(R.id.status_processing_image_button));
    private static ViewInteraction claimEditButton = onView(withId(R.id.edit_processing_image_button));

    @Step("Проверка элементов в каротчке(свернутая)")
    public static void cardShortCheck(){
        waitUntilElement(R.id.title_material_text_view);
        claimThemeTitle.check(matches(isDisplayed()));
        claimThemeDescription.check(matches(isDisplayed()));
        claimExecutorTitle.check(matches(isDisplayed()));
        claimExecutorName.check(matches(isDisplayed()));
        claimDividerLine.check(matches(isDisplayed()));
        claimDateTitle.check(matches(isDisplayed()));
        claimDateValue.check(matches(isDisplayed()));
        claimTimeValue.check(matches(isDisplayed()));

        onView(withIndex(withId(R.id.title_material_text_view), 0)).check(matches(withText("Тема")));
        onView(withIndex(withId(R.id.executor_name_label_material_text_view), 0)).check(matches(withText("Исполнитель")));
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 0)).check(matches(withText("Плановая дата")));
    }
    @Step("Проврека заголовка")
    public static void claimThemeTitleFullCheck(){
        waitUntilElement(R.id.title_label_text_view);
        existText(claimThemeTitleFull, "Тема");
    }
    @Step("Проверка элементов в каротчке(развернуто)")
    public static void cardFullCheck() {
        claimThemeTitleFullCheck();
        existText(claimExecutorTitleFull, "Исполнитель");
        existText(claimDateTitleFull, "Плановая дата");
        existText(claimAuthorTitle, "Автор");
        existText(claimCreateTitle, "Создана");
        claimThemeTitleTextFull.check(matches(isDisplayed()));
        claimExecutorNameFull.check(matches(isDisplayed()));
        claimDateValueFull.check(matches(isDisplayed()));
        claimTimeValueFull.check(matches(isDisplayed()));
        claimStatusView.check(matches(isDisplayed()));
        claimDescriptionText.check(matches(isDisplayed()));
        claimAuthorValue.check(matches(isDisplayed()));
        claimCreateDate.check(matches(isDisplayed()));
        claimCreateTime.check(matches(isDisplayed()));
        claimCommentBlock.check(matches(isDisplayed()));
        claimCreateTime.perform(customSwipeUp());

        claimCommentAddButtonCheck();
        claimCloseButtonCheck();
        claimStatusButtonCheck();
        claimEditButtonCheck();
    }
    @Step("Тап по кнопке")
    public static void claimCommentAddButtonClick(){
        claimCommentAddButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void claimCommentAddButtonCheck(){
        existClickable(claimCommentAddButton);
    }
    @Step("Тап по кнопке")
    public static void claimCloseButtonClick(){
        claimCloseButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void claimCloseButtonCheck(){
        existClickable(claimCloseButton);
    }
    @Step("Тап по кнопке")
    public static void claimStatusButtonClick(){
        claimStatusButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void claimStatusButtonCheck(){
        existClickable(claimStatusButton);
    }
    @Step("Тап по кнопке")
    public static void claimEditButtonClick(){
        claimEditButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void claimEditButtonCheck(){
        existClickable(claimEditButton);
    }
}
