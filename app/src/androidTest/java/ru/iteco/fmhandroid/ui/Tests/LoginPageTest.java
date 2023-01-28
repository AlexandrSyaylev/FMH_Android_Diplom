package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.LkMenuPage;
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
        LoginPage.loginFieldAsTextFieldType("login2");
        LoginPage.passwordFieldAsTextFieldType("password2");
        LoginPage.loginButtonClick();
        pauseShort();
    }

    public void logout() {
        HeaderPage.lkButtonClick();
        LkMenuPage.logoutButtonClick();
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка Стартовой Страницы")
    @DisplayName("На странице Авторизации представлены необходимые элементы")
    @Test
    public void A_loginPageUITest() {
        pause();
        LoginPage.fieldsCheck();
    }

    @Description("На странице Авторизации представлены необходимые элементы")
    @Story("Проверка страницы Авторизации")
    @DisplayName("п7,8,9,10 Убедиться, что при пустых полях при тапе по кнопке Войти действий не происходит \n" +
            "- Убедится, что при нажатии на кнопку назад (скрыть клавиатуру) клавиатура скрывается, \n" +
            "при повторном тапе по полю, клавиатура появляется")
    @Test
    public void B_shouldShowErrorWithEmptyFields() {
        pause();
        LoginPage.loginButtonClick();
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
        LoginPage.loginFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        pauseShort();
        LoginPage.passwordFieldAsTextFieldClick();
        assertTrue(isKeyboardOpenedShellCheck());
        clickBack();
        pauseShort();
        assertFalse(isKeyboardOpenedShellCheck());
    }

    @Description("При пустом поле появляется сообщение об ошибке")
    @Story("Проверка страницы Авторизации")
    @DisplayName("При пустом поле появляется сообщение об ошибке")
    @Test
    public void C_shouldShowErrorWithOneEmptyField() {
        pause();
        LoginPage.loginFieldAsTextFieldType("login");
        LoginPage.loginButtonClick();
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));

        LoginPage.loginFieldAsTextFieldClear();
        LoginPage.passwordFieldAsTextFieldType("password");
        LoginPage.loginButtonClick();
        onView(withText(R.string.empty_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Логин и пароль не могут быть пустыми")));
        LoginPage.passwordFieldAsTextFieldClear();
    }

    @Description("При вводе произвольных логин пароль не входит в приложение")
    @Story("Проверка страницы Авторизации")
    @DisplayName("п11,12 При вводе неверных пар логин- пароль появляется поп-ап с текстом \"Неверный логин или пароль\"")
    @Test
    public void D_shouldShowErrorWithWrongValues() {
        pause();
        LoginPage.loginFieldAsTextFieldType("login");
        LoginPage.passwordFieldAsTextFieldType("password");
        LoginPage.loginButtonClick();
        onView(withText(R.string.wrong_login_or_password)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Неверный логин или пароль")));
    }

    @Description("При вводе валидных логин пароль входит в приложение")
    @Story("Проверка страницы Авторизации")
    @DisplayName("п13,14,17 Ввод валидных логин пароль, нажать на Войти")
    @Test
    public void E_shouldLogin(){
        pause();
        LoginPage.titleTextElementCheck();
        LoginPage.loginFieldAsTextFieldType("login2");
        LoginPage.passwordFieldAsTextFieldType("password2");
        LoginPage.loginButtonClick();
        pauseShort();
        HeaderPage.logoCheck();
    }

    @Description("После авторизации пользователя при перезапуске отображается страница загрузки")
    @Story("Проверка Главной страницы")
    @DisplayName("п19 При повторном запуске приложения после авторизации пользователя отображается экран загрузки с прогресс баром и текстом высказывания")
    @Test
    public void F_shouldAppStartOnSplashScreenPageWhenUserLogin(){
        SplashScreenPage.screenSplashCheK();
        pause();
    }

    @Description("После авторизации пользователя при перезапуске открывается Главная страница")
    @Story("Проверка Главной страницы")
    @DisplayName("п18 Открывается главная страница")
    @Test
    public void G_shouldAppStartOnAutorizationPageWhenUserLogOut(){
        pause();
        HeaderPage.logoCheck();
        logout();
    }

    @Description("После выхода пользователя при перезапуске открывается страница Авторизации")
    @Story("Проверка Главной страницы")
    @DisplayName("п21 Если авторизованным пользователем нажать выход, при повторном запуске отображается страница Авторизации")
    @Test
    public void H_shouldAppStartOnAutorizationPageWhenUserLogOut(){
        pause();
        LoginPage.titleTextElementCheck();
        login();
    }

    @Description("запуск авторизованным пользователем при перезапуске приложенияч авторизванным пользователем")
    @Story("Проверка Главной страницы")
    @DisplayName("п20 При повторном запуске приложения после авторизации пользователя приложение запускается под авторизованным пользователем")
    @Test
    public void I_shouldStartAppOnMainPageWhenAutorized(){
        pause();
        HeaderPage.mainMenuButtonCheck();
        logout();
    }
}
