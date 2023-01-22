package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.BasePage;

public class SplashScreenPage extends BasePage {
    public static ViewInteraction imageId = onView(withId(R.id.splashscreen_image_view));
    public static ViewInteraction progressBarId = onView(withId(R.id.splash_screen_circular_progress_indicator));
    public static ViewInteraction textViewId = onView(withId(R.id.splashscreen_text_view));
}
