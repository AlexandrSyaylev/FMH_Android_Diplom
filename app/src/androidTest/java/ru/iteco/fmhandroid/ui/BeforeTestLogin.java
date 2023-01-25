package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static ru.iteco.fmhandroid.ui.Pages.HeaderPage.lkButton;
import static ru.iteco.fmhandroid.ui.Pages.LkMenuPage.logoutButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginFieldAsTextField;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.passwordFieldAsTextField;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;

@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)
public class BeforeTestLogin extends BasePage {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void login() {
        pause();
        loginFieldAsTextField.perform(typeText("login2"));
        pauseShort();
        passwordFieldAsTextField.perform(typeText("password2"));
        loginButton.perform(click());
        onView(isRoot()).perform(waitFor(2000));
    }

    @After
    public void logout() {
        lkButton.perform(click());
        logoutButton.perform(click());
    }

    public static void headerCheck(){
        HeaderPage.mainMenuButton.check(matches(isDisplayed()));
        HeaderPage.logoView.check(matches(isDisplayed()));
        HeaderPage.thematicButton.check(matches(isDisplayed()));
        lkButton.check(matches(isDisplayed()));

        HeaderPage.mainMenuButton.check(matches(isClickable()));
        HeaderPage.logoView.check(matches(not(isClickable())));
        HeaderPage.thematicButton.check(matches(isClickable()));
        lkButton.check(matches(isClickable()));
    }

    public static void menuContainCheck(){
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.check(matches(isDisplayed()));
        MainMenuPage.mainPageButton.check(matches(withText(MainMenuPage.mainPageTextRu)));
        MainMenuPage.newsPageButton.check(matches(isDisplayed()));
        MainMenuPage.newsPageButton.check(matches(withText(MainMenuPage.NewsPageTextRu)));
        MainMenuPage.aboutPageButton.check(matches(isDisplayed()));
        MainMenuPage.aboutPageButton.check(matches(withText(MainMenuPage.aboutPageTextRu)));
        MainMenuPage.claimPageButton.check(matches(isDisplayed()));
        MainMenuPage.claimPageButton.check(matches(withText(MainMenuPage.claimPageTextRu)));
        clickBack();
    }
}
