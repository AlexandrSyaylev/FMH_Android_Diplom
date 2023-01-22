package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
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

    public static ViewInteraction controlPanelTitle = onView(withText("Панель \n управления"));
}
