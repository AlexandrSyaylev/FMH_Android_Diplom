package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsControlPage extends NewsPage{
    public static ViewInteraction controlPanelTitle = onView(withText("Панель \n управления"));

    public static ViewInteraction filterActiveSwitch = onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction filterInactiveSwitch = onView(withId(R.id.filter_news_inactive_material_check_box));
}
