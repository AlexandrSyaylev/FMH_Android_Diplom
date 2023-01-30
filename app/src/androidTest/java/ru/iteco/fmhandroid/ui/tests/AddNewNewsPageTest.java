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

public class AddNewNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        NewsPage.titleNewsHeaderCheck();
        NewsPage.controlPanelButtonClick();
        NewsPage.addNewNewsButtonClick();
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
        AddNewNewsPage.saveButtonCheck();
        clickBack();
        NewsControlPage.controlPanelTitleCheck();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание Новости")
    @DisplayName("п301,316 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewNewsPage.saveButtonClick();
        AddNewNewsPage.errorFillEmptyFieldsCheck();
        clickBack();
        NewsControlPage.controlPanelTitleCheck();
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
        AddNewNewsPage.saveButtonCheck();
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
        AddNewNewsPage.saveButtonCheck();
        clickBack();
    }
}
