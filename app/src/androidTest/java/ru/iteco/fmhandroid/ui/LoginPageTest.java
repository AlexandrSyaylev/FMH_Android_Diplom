package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest extends BasePage {
    @Test
    public void A_loginPageUITest() {
        pause();
        LoginPage.titleTextElement.check(matches(isDisplayed()));
        LoginPage.titleTextElement.check(matches(withText("Авторизация")));

        LoginPage.loginField.check(matches(isDisplayed()));
        LoginPage.passwordField.check(matches(isDisplayed()));
        LoginPage.loginButton.check(matches(isDisplayed()));

        LoginPage.loginField.check(matches(hasTextInputLayout("Логин")));
        LoginPage.passwordField.check(matches(hasTextInputLayout("Пароль")));
        LoginPage.loginButton.check(matches((withText("Войти"))));
    }

    @Test
    public void B_shouldShowErrorWithEmptyFields() {
        pause();
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
    }

    @Test
    public void C_shouldShowErrorWithOneEmptyField() {
        pause();
        LoginPage.loginFieldAsTextField.perform(typeText("login"));
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));

        LoginPage.loginFieldAsTextField.perform(clearText());
        LoginPage.passwordFieldAsTextField.perform(typeText("password"));
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
        LoginPage.passwordFieldAsTextField.perform(clearText());
    }

    @Test
    public void D_shouldShowErrorWithWrongValues() {
        pause();
        LoginPage.loginFieldAsTextField.perform(typeText("login"));
        LoginPage.passwordFieldAsTextField.perform(typeText("password"));
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.wrong_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Неверный логин или пароль")));
    }

    @Test
    public void E_shouldLogin(){
        pause();
        LoginPage.titleTextElement.check(matches(isDisplayed()));
        LoginPage.loginFieldAsTextField.perform(typeText("login2"));
        LoginPage.passwordFieldAsTextField.perform(typeText("password2"));
        LoginPage.loginButton.perform(click());

        pause();
        HeaderPage.logoView.check(matches(isDisplayed()));
        BeforeTestLogin.logout();
    }

    @Test
    public void F_shouldAppStartOnAutorizationPageWhenUserLogOut(){
        pause();
        LoginPage.titleTextElement.check(matches(isDisplayed()));
        LoginPage.titleTextElement.check(matches(withText("Авторизация")));
        BeforeTestLogin.login();
    }

    @Test
    public void G_shouldStartAppOnMainPageWhenAutorized(){
        pause();
        HeaderPage.mainMenuButton.check(matches(isDisplayed()));
        BeforeTestLogin.logout();
    }

}
