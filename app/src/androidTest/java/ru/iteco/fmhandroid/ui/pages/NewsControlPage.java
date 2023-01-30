package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NewsControlPage extends NewsPage{
    private static ViewInteraction controlPanelTitle = onView(withText("Панель \n управления"));

    private static ViewInteraction filterActiveSwitch = onView(withId(R.id.filter_news_active_material_check_box));
    private static ViewInteraction filterInactiveSwitch = onView(withId(R.id.filter_news_inactive_material_check_box));

    @Step("Отображается заголовок Панель Управления")
    public static void controlPanelTitleCheck(){
        waitUntilElement("Панель \n управления");
        existText(controlPanelTitle, "Панель \n управления");
    }
    @Step("Кнопка отображается и кликабельна")
    public static void filterActiveSwitchCheck(){
        existClickable(filterActiveSwitch);
    }
    @Step("Переключатель отображается и кликабельна")
    public static void filterInactiveSwitchCheck(){
        existClickable(filterInactiveSwitch);
    }
    @Step("Кнопка отображается и кликабельна")
    public static void filterActiveChecked(){
        filterActiveSwitch.check(matches(isChecked()));
    }
    @Step("Переключатель отображается и кликабельна")
    public static void filterInactiveSwitchChecked(){
        filterInactiveSwitch.check(matches(isChecked()));
    }
    @Step("Тап по кнопке edit")
    public static void editButtonClick(){
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }

}
