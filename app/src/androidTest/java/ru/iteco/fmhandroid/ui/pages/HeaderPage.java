package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class HeaderPage extends BasePage {
    private static ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    private static ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    private static ViewInteraction thematicButton = onView(withId(R.id.our_mission_image_button));
    private static ViewInteraction lkButton = onView(withId(R.id.authorization_image_button));

    @Step("Кнопка видна и кликабельна")
    public static void mainMenuButtonCheck(){
        waitUntilElement(R.id.main_menu_image_button);
        existClickable(mainMenuButton);
    }
    @Step("Кнопка видна и кликабельна")
    public static void thematicButtonCheck(){
        existClickable(thematicButton);
    }
    @Step("Кнопка видна и кликабельна")
    public static void lkButtonCheck(){
        existClickable(lkButton);
    }
    @Step("Лого присутствует и не кликабелен")
    public static void logoCheck(){
        waitUntilElement(R.id.trademark_image_view);
        existNotClickable(logoView);
    }

    @Step("Тап по кнопке")
    public static void mainMenuButtonClick(){
        waitUntilElement(R.id.main_menu_image_button);
        mainMenuButton.perform(click());
    }
    @Step("Тап по кнопке")
    public static void thematicButtonClick(){
        waitUntilElement(R.id.our_mission_image_button);
        thematicButton.perform(click());
    }
    @Step("Тап по кнопке")
    public static void lkButtonClick(){
        waitUntilElement(R.id.authorization_image_button);
        lkButton.perform(click());
    }

}
