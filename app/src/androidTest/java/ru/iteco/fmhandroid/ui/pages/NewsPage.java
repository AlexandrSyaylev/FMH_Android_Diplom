package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NewsPage extends BasePage {
    private static ViewInteraction titleNewsHeader = onView(withText("Новости"));
    private static ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    private static ViewInteraction sorterButton = onView(withId(R.id.sort_news_material_button));
    private static ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));

    private static ViewInteraction addNewNewsButton = onView(withId(R.id.add_news_image_view));

    private static ViewInteraction filterTitle = onView(withId(R.id.filter_news_title_text_view));
    private static ViewInteraction filterCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private static ViewInteraction filterCategoryEnd = onView(withIndex(withId(R.id.text_input_end_icon), 0));
    private static ViewInteraction filterDateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private static ViewInteraction filterDateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private static ViewInteraction filterSubmitButton = onView(withId(R.id.filter_button));
    private static ViewInteraction filterCancelButton = onView(withId(R.id.cancel_button));

    @Step
    public static void titleNewsHeaderCheck(){
        waitUntilElement("Новости");
        existText(titleNewsHeader, "Новости");
    }
    @Step("Проверка кнопки")
    public static void filterButtonCheck(){
        existClickable(filterButton);
    }
    @Step("Тап по кнопке")
    public static void filterButtonClick(){
        waitUntilElement(R.id.filter_news_material_button);
        filterButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void sorterButtonCheck(){
        existClickable(sorterButton);
    }
    @Step("Тап по кнопке")
    public static void sorterButtonClick(){
        sorterButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void controlPanelButtonCheck(){
        waitUntilElement(R.id.edit_news_material_button);
        existClickable(controlPanelButton);
    }
    @Step("Тап по кнопке")
    public static void controlPanelButtonClick(){
        waitUntilElement(R.id.edit_news_material_button);
        controlPanelButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void addNewNewsButtonCheck(){
        existClickable(addNewNewsButton);
    }
    @Step("Тап по кнопке")
    public static void addNewNewsButtonClick(){
        addNewNewsButton.perform(click());
    }
    @Step("Тап по полю Date")
    public static void filterDateEndClick(){
        waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        filterDateEnd.perform(click());
    }
    @Step("Тап по полю Date")
    public static void filterDateStartClick(){
        waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        filterDateStart.perform(click());
    }
    @Step("Swipe up")
    public static void swipeUpNewsBlock(){
        onView(withIndex(withId(R.id.news_item_title_text_view), 4)).perform(customSwipeUp());
    }
    @Step("Тап по полю Категория")
    public static void filterCategoryClick(){
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        filterCategory.perform(click());
        pauseSSt();
        filterCategory.perform(closeSoftKeyboard());
    }
    public static void filterBaseCheck(){
        waitUntilElement(R.id.filter_news_title_text_view);
        filterTitle.check(matches(isDisplayed()));
        filterTitle.check(matches(withText("Фильтровать новости")));
        filterCategory.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.text_input_end_icon), 0)).check(matches(isDisplayed()));
        filterDateStart.check(matches(isDisplayed()));
        filterDateEnd.check(matches(isDisplayed()));
        filterSubmitButton.check(matches(isDisplayed()));
        filterCancelButton.check(matches(isDisplayed()));

        filterCategory.check(matches(isClickable()));
        filterDateStart.check(matches(isClickable()));
        filterDateEnd.check(matches(isClickable()));
        filterSubmitButton.check(matches(isClickable()));
        filterCancelButton.check(matches(isClickable()));

        filterCategory.check(matches(withHint("Категория")));
        filterDateStart.check(matches(withHint("ДД.ММ.ГГГГ")));
        filterDateEnd.check(matches(withHint("ДД.ММ.ГГГГ")));
        filterSubmitButton.check(matches(withText("Фильтровать")));
        filterCancelButton.check(matches(withText("Отмена")));
    }

    @Step("Проверка содержимого карточки новости (свернутой)")
    public static void newsCardStdCheck(){
        onView(withIndex(withId(R.id.category_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(not(isDisplayed())));
    }

    @Step("Проверка содержимого карточки новости (свернутой)")
    public static void newsCardDescriptionsCheck(){
        waitUntilElement(R.id.news_item_title_text_view);
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        waitUntilElement(R.id.news_item_description_text_view);
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
}
