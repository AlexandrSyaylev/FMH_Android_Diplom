package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.iteco.fmhandroid.ui.Pages.HeaderPage.lkButton;
import static ru.iteco.fmhandroid.ui.Pages.LkMenuPage.logoutButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginButton;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.loginFieldAsTextField;
import static ru.iteco.fmhandroid.ui.Pages.LoginPage.passwordFieldAsTextField;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.LoginPage;
import ru.iteco.fmhandroid.ui.Pages.SplashScreenPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AllureAndroidJUnit4.class)
public class LoginPageTest extends BasePage {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public void login() {
        pause();
        loginFieldAsTextField.perform(typeText("login2"));
        passwordFieldAsTextField.perform(typeText("password2"));
        loginButton.perform(click());
        onView(isRoot()).perform(waitFor(2000));
    }

    public void logout() {
        lkButton.perform(click());
        logoutButton.perform(click());
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
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

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка страницы Авторизации")
    @Step("п7,8,9,10 Убедиться, что при пустых полях при тапе по кнопке Войти действий не происходит \n" +
            "- Убедится, что при нажатии на кнопку назад (скрыть клавиатуру) клавиатура скрывается, \n" +
            "при повторном тапе по полю, клавиатура появляется")
    @Test
    public void B_shouldShowErrorWithEmptyFields() {
        pause();
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
        LoginPage.loginFieldAsTextField.perform(click());
        assertTrue(isKeyboardOpenedShellCheck());
        pauseShort();
        LoginPage.passwordFieldAsTextField.perform(click());
        assertTrue(isKeyboardOpenedShellCheck());
        clickBack();
        pauseShort();
        assertFalse(isKeyboardOpenedShellCheck());
    }

    @Description("При пустом поле появляется сообщение об ошибке")
    @Story("Проверка страницы Авторизации")
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

    @Description("При вводе произвольных логин пароль не входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Step("п11,12 При вводе неверных пар логин- пароль появляется поп-ап с текстом \"Неверный логин или пароль\"")
    @Test
    public void D_shouldShowErrorWithWrongValues() {
        pause();
        LoginPage.loginFieldAsTextField.perform(typeText("login"));
        LoginPage.passwordFieldAsTextField.perform(typeText("password"));
        LoginPage.loginButton.perform(click());
        onView(withText(R.string.wrong_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Неверный логин или пароль")));
    }

    @Description("При вводе валидных логин пароль входит в приложение")
    @Story("Проверка страницы Авторизации")
    @Step("п13,14,17 Ввод валидных логин пароль, нажать на Войти")
    @Test
    public void E_shouldLogin(){
        pause();
        LoginPage.titleTextElement.check(matches(isDisplayed()));
        LoginPage.loginFieldAsTextField.perform(typeText("login2"));
        LoginPage.passwordFieldAsTextField.perform(typeText("password2"));
        LoginPage.loginButton.perform(click());
        pauseShort();
        HeaderPage.logoView.check(matches(isDisplayed()));
    }

    @Description("После авторизации пользователя при перезапуске отображается страница загрузки")
    @Story("Проверка Главной страницы")
    @Step("п19 При повторном запуске приложения после авторизации пользователя отображается экран загрузки с прогресс баром и текстом высказывания")
    @Test
    public void F_shouldAppStartOnSplashScreenPageWhenUserLogin(){
        SplashScreenPage.imageId.check(matches(isDisplayed()));
        SplashScreenPage.progressBarId.check(matches(isDisplayed()));
        SplashScreenPage.textViewId.check(matches(isDisplayed()));
        pause();
    }

    @Description("После авторизации пользователя при перезапуске открывается Главная страница")
    @Story("Проверка Главной страницы")
    @Step("п18 Открывается главная страница")
    @Test
    public void G_shouldAppStartOnAutorizationPageWhenUserLogOut(){
        pause();
        HeaderPage.logoView.check(matches(isDisplayed()));
        logout();
    }

    @Description("После выхода пользователя при перезапуске открывается страница Авторизации")
    @Story("Проверка Главной страницы")
    @Step("п21 Если авторизованным пользователем нажать выход, при повторном запуске отображается страница Авторизации")
    @Test
    public void H_shouldAppStartOnAutorizationPageWhenUserLogOut(){
        pause();
        LoginPage.titleTextElement.check(matches(isDisplayed()));
        LoginPage.titleTextElement.check(matches(withText("Авторизация")));
        login();
    }

    @Description("запуск авторизованным пользователем при перезапуске приложенияч авторизванным пользователем")
    @Story("Проверка Главной страницы")
    @Step("п20 При повторном запуске приложения после авторизации пользователя приложение запускается под авторизованным пользователем")
    @Test
    public void I_shouldStartAppOnMainPageWhenAutorized(){
        pause();
        HeaderPage.mainMenuButton.check(matches(isDisplayed()));
        logout();
    }
}
