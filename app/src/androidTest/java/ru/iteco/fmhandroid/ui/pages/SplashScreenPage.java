package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class SplashScreenPage extends BasePage {
    private static ViewInteraction imageId = onView(withId(R.id.splashscreen_image_view));
    private static ViewInteraction progressBarId = onView(withId(R.id.splash_screen_circular_progress_indicator));
    private static ViewInteraction textViewId = onView(withId(R.id.splashscreen_text_view));

    public static void screenSplashCheK(){
        imageId.check(matches(isDisplayed()));
        progressBarId.check(matches(isDisplayed()));
        textViewId.check(matches(isDisplayed()));
    }
}
