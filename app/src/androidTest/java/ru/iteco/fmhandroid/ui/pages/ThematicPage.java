package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ThematicPage extends BasePage{

    private static ViewInteraction titleText = onView(withId(R.id.our_mission_title_text_view));
    private static ViewInteraction missionOneContainerClickable = onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0));
    private static ViewInteraction missionImage = onView(withIndex(withId(R.id.our_mission_item_image_view), 0));
    private static ViewInteraction missionCollapseButton = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    private static ViewInteraction missionTitle = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    private static ViewInteraction missionDescription = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));

    @Step("Проверка отображения всех полей")
    public static void thematicBlockOneCheck(){
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(not(isDisplayed())));
    }
    @Step("Проверка отображения поля Описание при Тапе")
    public static void descriptionCheck(){
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).perform(click());
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
    }
    @Step("Проверка наличия заголовка")
    public static void titleCheck(){
        titleText.check(matches(isDisplayed()));
    }
    @Step("Проверка наличия заголовка")
    public static void titleTextCheck(){
        existText(titleText,"Главное - жить любя");
    }
    @Step("Свайп блока вверх")
    public static void swipeUp(){
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 2)).perform(customSwipeUp());
    }
}
