package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.BasePage;

public class NewsPage extends BasePage {
    public static ViewInteraction titleNewsHeader = onView(withText("Новости"));
    public static ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction sorterButton = onView(withId(R.id.sort_news_material_button));
    public static ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));

    public static ViewInteraction addNewNewsButton = onView(withId(R.id.add_news_image_view));

    public static ViewInteraction filterTitle = onView(withId(R.id.filter_news_title_text_view));
    public static ViewInteraction filterCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction filterCategoryEnd = onView(withIndex(withId(R.id.text_input_end_icon), 0));
    public static ViewInteraction filterDateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction filterDateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction filterSubmitButton = onView(withId(R.id.filter_button));
    public static ViewInteraction filterCancelButton = onView(withId(R.id.cancel_button));

    public static void filterBaseCheck(){
        NewsPage.filterTitle.check(matches(isDisplayed()));
        NewsPage.filterTitle.check(matches(withText("Фильтровать новости")));
        NewsPage.filterCategory.check(matches(isDisplayed()));
        NewsPage.filterCategoryEnd.check(matches(isDisplayed()));
        NewsPage.filterDateStart.check(matches(isDisplayed()));
        NewsPage.filterDateEnd.check(matches(isDisplayed()));
        NewsPage.filterSubmitButton.check(matches(isDisplayed()));
        NewsPage.filterCancelButton.check(matches(isDisplayed()));

        NewsPage.filterCategory.check(matches(isClickable()));
        NewsPage.filterDateStart.check(matches(isClickable()));
        NewsPage.filterDateEnd.check(matches(isClickable()));
        NewsPage.filterSubmitButton.check(matches(isClickable()));
        NewsPage.filterCancelButton.check(matches(isClickable()));

        NewsPage.filterCategory.check(matches(withHint("Категория")));
        NewsPage.filterDateStart.check(matches(withHint("ДД.ММ.ГГГГ")));
        NewsPage.filterDateEnd.check(matches(withHint("ДД.ММ.ГГГГ")));
        NewsPage.filterSubmitButton.check(matches(withText("Фильтровать")));
        NewsPage.filterCancelButton.check(matches(withText("Отмена")));
    }
}
