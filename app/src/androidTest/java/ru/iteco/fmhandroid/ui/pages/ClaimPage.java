package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ClaimPage extends BasePage {
    private static ViewInteraction titleClaimHeader = onView(withText("Заявки"));
    private static ViewInteraction filterButton = onView(withId(R.id.filters_material_button));
    private static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));

    //popup filter
    private static ViewInteraction filterView = onView(withId(R.id.customPanel));
    private static ViewInteraction filterTitle = onView(withId(R.id.claim_filter_dialog_title));
    private static ViewInteraction statusOpen = onView(withId(R.id.item_filter_open));
    private static ViewInteraction statusInProgress = onView(withId(R.id.item_filter_in_progress));
    private static ViewInteraction statusExecuted = onView(withId(R.id.item_filter_executed));
    private static ViewInteraction statusCancelled = onView(withId(R.id.item_filter_cancelled));
    private static ViewInteraction filterOkButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    private static ViewInteraction filterCancelButton = onView(withId(R.id.claim_filter_cancel_material_button));

    @Step
    public static void titleClaimHeaderCheck(){
        waitUntilElement("Заявки");
        existText(titleClaimHeader,"Заявки");
    }
    @Step("Тап по кнопке filter")
    public static void filterButtonClick(){
        filterButton.perform(click());
    }
    @Step("Проверка кнопки filter")
    public static void filterButtonCheck(){
        existClickable(filterButton);
    }
    @Step("Тап по кнопке +")
    public static void addNewClaimButtonClick(){
        addNewClaimButton.perform(click());
    }
    @Step("Проверка кнопки +")
    public static void addNewClaimButtonCheck(){
        existClickable(addNewClaimButton);
    }
    @Step("Проверка окна фильтра")
    public static void filterViewCheck(){
        exist(filterView);
    }
    @Step("Проверка текста Заголовка")
    public static void filterTitleCheck(){
        existText(filterTitle,"Фильтрация");
    }
    @Step("Проверка элементов в фильтре")
    public static void filterCheck() {
        waitUntilElement(R.id.item_filter_open);
        existClickableText(statusOpen, "Открыта");
        existClickableText(statusInProgress, "В работе");
        existClickableText(statusExecuted, "Выполнена");
        existClickableText(statusCancelled, "Отмененные");
        existClickableText(filterOkButton, "ОК");
        existClickableText(filterCancelButton, "Отмена");
    }
    @Step("Тап по кнопке OK")
    public static void filterOkButtonClick(){
        filterOkButton.perform(click());
    }
    @Step("Тап по кнопке Cancel")
    public static void editButtonClick(){
        filterCancelButton.perform(click());
    }
    @Step("Открываем заявку без комментариев (в данной реализации наугад 3ю карточку)")
    public static void openCardWithoutComment(){
        ClaimPage.filterButton.perform(click());
        onView(withText("Открыта")).perform(click());
        onView(withText("В работе")).perform(click());
        onView(withText("Отмененные")).perform(click());
        onView(withId(R.id.claim_list_filter_ok_material_button)).perform(click());
        waitUntilElement(R.id.claim_list_card);
        onView(withIndex(withId(R.id.claim_list_card), 2)).perform(click());
    }
    @Step("swipe up cards")
    public static void claimsSwipeUp(){
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
        onView(withIndex(withId(R.id.plan_date_label_material_text_view), 2)).perform(customSwipeUp());
        pauseSSt();
    }
    @Step("Тап по заявке")
    public static void claimTap(){
        onView(withIndex(withId(R.id.claim_list_card), 0)).perform(click());
    }
}
