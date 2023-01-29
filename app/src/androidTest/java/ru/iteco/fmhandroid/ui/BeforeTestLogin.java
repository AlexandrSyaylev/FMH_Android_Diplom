package ru.iteco.fmhandroid.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.pages.BasePage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.LkMenuPage;
import ru.iteco.fmhandroid.ui.pages.LoginPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;

@RunWith(AllureAndroidJUnit4.class)
public class BeforeTestLogin extends BasePage {
    @Before
    public void login() {
        pause();
        try{
            LoginPage.loginFieldAsTextFieldType("login2");
            LoginPage.passwordFieldAsTextFieldType("password2");
            LoginPage.loginButtonClick();
            pauseShort();

        }catch (androidx.test.espresso.PerformException e){
            System.out.println("Already login");
            pauseShort();
        }catch (androidx.test.espresso.NoMatchingViewException e){
            System.out.println("Already login");
            pauseShort();
        }
    }

    @After
    public void logout() {
        try {
            pauseSSt();
            HeaderPage.lkButtonClick();
            LkMenuPage.logoutButtonClick();
        }catch (androidx.test.espresso.PerformException e){
            System.out.println("Huston? We have a problem: ");
        }catch (androidx.test.espresso.NoMatchingViewException e){
            System.out.println("Gimme more pause to load :)");
        }

    }

    public static void headerCheck(){
        HeaderPage.mainMenuButtonCheck();
        HeaderPage.logoCheck();
        HeaderPage.thematicButtonCheck();
        HeaderPage.lkButtonCheck();
    }

    public static void menuContainCheck(){
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.menuConsist();
        clickBack();
    }
}
