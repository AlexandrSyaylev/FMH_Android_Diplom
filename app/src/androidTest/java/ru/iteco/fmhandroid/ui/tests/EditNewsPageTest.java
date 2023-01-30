package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.pages.HeaderPage;
import ru.iteco.fmhandroid.ui.pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class EditNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        NewsPage.controlPanelButtonClick();
        NewsControlPage.editButtonClick();
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
        waitUntilKeyboardHide();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        AddNewNewsPage.cancelButtonClick();
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
        AddNewNewsPage.saveButtonClick();
        AddNewNewsPage.errorFillEmptyFieldsCheck();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п327 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){ //!
        AddNewNewsPage.dateFieldClick();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        AddNewNewsPage.newsAddEditPageLoadWaits();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Редактирование Новости")
    @DisplayName("п329 При тапе по полю Время открываются часы")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewNewsPage.timeFieldClick();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        AddNewNewsPage.newsAddEditPageLoadWaits();
        clickBack();
    }
}
