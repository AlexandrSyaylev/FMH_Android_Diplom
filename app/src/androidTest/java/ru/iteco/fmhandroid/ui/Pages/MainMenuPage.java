package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class MainMenuPage extends BasePage{

    public static String mainPageTextRu = "Главная";
    public static String claimPageTextRu = "Заявки";
    public static String NewsPageTextRu = "Новости";
    public static String aboutPageTextRu = "О приложении";

    public static ViewInteraction mainPageButton = onView(withText("Главная")).inRoot(isPopupWindow());
    public static ViewInteraction claimPageButton = onView(withText("Заявки")).inRoot(isPopupWindow());
    public static ViewInteraction newsPageButton = onView(withText("Новости")).inRoot(isPopupWindow());
    public static ViewInteraction aboutPageButton = onView(withText("О приложении")).inRoot(isPopupWindow());

    public static ViewInteraction mainMenuIcon = onView(withContentDescription("Главное меню")).inRoot(isPopupWindow());
}
