package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.Pages.HeaderPage.lkButton;
import static ru.iteco.fmhandroid.ui.Pages.LkMenuPage.logoutButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginFieldAsTextField;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.passwordFieldAsTextField;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.Pages.BasePage;

@RunWith(AndroidJUnit4.class)
public class BeforeTestLogin extends BasePage {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

//    @BeforeClass
    public static void login() {
        pause();
        loginFieldAsTextField.perform(typeText("login2"));
        passwordFieldAsTextField.perform(typeText("password2"));
        loginButton.perform(click());
        onView(isRoot()).perform(waitFor(2000));
    }

//    @AfterClass
    public static void logout() {
        lkButton.perform(click());
        logoutButton.perform(click());
    }
}
