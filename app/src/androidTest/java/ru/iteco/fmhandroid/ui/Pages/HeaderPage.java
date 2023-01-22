package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class HeaderPage extends BasePage {
    public static ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction thematicButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction lkButton = onView(withId(R.id.authorization_image_button));
}
