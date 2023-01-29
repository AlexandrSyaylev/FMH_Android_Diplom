package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class EditNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        pauseShort();
        NewsPage.controlPanelButtonClick();
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }

    @Description("Страница содержит заголовок \"Редактирование Новости\"")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п319,320, Страница содержит заголовок \"Редактирование Новости\"")
    @Test
    public void shouldHaveRequiredElements(){
        AddNewNewsPage.titleCheck("Редактирование");
        AddNewNewsPage.switcherCheck();
        AddNewNewsPage.fieldsCheck();
        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п322 Раскрывающийся список Категория содержит перечень категорий")
    @Test
    public void shouldHaveAllCategoriesInDropMenu(){
        AddNewNewsPage.categoryFieldClick();

        AddNewNewsPage.categoryFieldClear();
        AddNewNewsPage.categoryFieldClick();
        AddNewNewsPage.categoryFieldHide();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        pauseShort();
        AddNewNewsPage.cancelButtonClick();
        pauseSSt();
        AddNewNewsPage.noSaveChangesOkButtonClick();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п325,336 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewNewsPage.descriptionFieldClick();
        AddNewNewsPage.descriptionFieldClear();
        AddNewNewsPage.descriptionFieldHide();
        pauseShort();
        AddNewNewsPage.saveButtonClick();
        onView(withText(R.string.empty_fields)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Заполните пустые поля")));
        pauseShort();
        clickBack();
        pauseShort();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п327 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){ //!
        AddNewNewsPage.dateFieldClick();
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п329 При тапе по полю Время открываются часы")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewNewsPage.timeFieldClick();
        pauseShort();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }
}
