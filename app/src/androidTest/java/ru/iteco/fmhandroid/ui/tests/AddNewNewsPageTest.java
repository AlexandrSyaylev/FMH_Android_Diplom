package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class AddNewNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        pauseShort();
        NewsPage.controlPanelButtonClick();
        NewsPage.addNewNewsButtonClick();
        pauseShort();
    }

    @Description("Страница содержит заголовок \"Создание Новости\"")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п295,296,313 Страница содержит заголовок \"Создание Новости\"")
    @Test
    public void shouldHaveRequiredElements(){
        AddNewNewsPage.titleCheck("Создание");
        AddNewNewsPage.switcherCheck();
        AddNewNewsPage.fieldsCheck();
        AddNewNewsPage.placeholdersCheck();
        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п297 Раскрывающийся список Категория содержит перечень категорий")
    @Test
    public void shouldHaveAllCategoriesInDropMenu(){
        AddNewNewsPage.openDropList();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п301,316 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewNewsPage.saveButtonClick();
        onView(withText(R.string.empty_fields)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Заполните пустые поля")));
        pauseShort();
        clickBack();
        pauseShort();
    }

    @Description("Страница содержит заголовок \"Создание Новости\"")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п295 Страница содержит заголовок \"Создание Новости\"")
    @Test
    public void shouldOpenNewsPageCntrlPanelWhenTapOKOnPopup(){
        AddNewNewsPage.cancelButtonClick();
        AddNewNewsPage.noSaveChangesOkButtonClick();
        NewsControlPage.controlPanelTitleCheck();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п303 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        AddNewNewsPage.dateFieldClick();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п305 При тапе по полю Время открываются часы")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewNewsPage.timeFieldClick();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }
}
