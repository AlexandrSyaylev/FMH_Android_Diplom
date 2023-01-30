package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;

public class LkMenuPage extends BasePage{
    private static ViewInteraction logoutButton = onView(
            allOf(withId(android.R.id.title), withText("Выйти"),
                    isDisplayed()));

    @Step("Кнопка видна и кликабельна, текст соответстует")
    public static void logoutButtonCheck(){
        existNotClickableText(logoutButton, "Выйти");
    }
    @Step("Тап по кнопке Выйти")
    public static void logoutButtonClick(){
        waitUntilElement("Выйти");
        logoutButton.perform(click());
    }
}
