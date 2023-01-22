package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class LoginPage {
    public static ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    public static ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    public static ViewInteraction loginButton = onView(withText("Войти"));
    public static ViewInteraction loginFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.login_text_input_layout))));
    public static ViewInteraction passwordFieldAsTextField = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.password_text_input_layout))));
    public static ViewInteraction titleTextElement = onView(withText("Авторизация"));
}
