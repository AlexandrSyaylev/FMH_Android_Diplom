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
import ru.iteco.fmhandroid.ui.pages.NewsCard;
import ru.iteco.fmhandroid.ui.pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class NewsControlPageTest extends BeforeTestLogin {
    @Before
    public void openControlPage(){
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
        NewsPage.controlPanelButtonClick();
    }

    @Description("На странице в заголовке блока есть текст \"Панель управления\"...")
    @Story("Проверка Страницы Панель Управления")
    @DisplayName("п267-269,271-275 На странице в заголовке блока есть текст \"Панель управления\"...")
    @Test
    public void shouldDisplayNewsFieldsForControlPanel(){
        NewsControlPage.controlPanelTitleCheck();
        NewsPage.addNewNewsButtonCheck();

        NewsCard.newsCardFullCheck();
        NewsCard.editButtonCheck();
        NewsCard.deleteButtonCheck();
        NewsCard.statusButtonCheck();

        NewsCard.newsCardFullDescriptionsCheck();
        NewsCard.newsCardFullClick();
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Панель Управления")
    @DisplayName("п278,279,286 При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Test
    public void shouldOpenFilterPage(){
        NewsPage.filterButtonClick();
        NewsPage.filterBaseCheck();
        NewsControlPage.filterActiveSwitchCheck();
        NewsControlPage.filterInactiveSwitchCheck();
        NewsControlPage.filterActiveChecked();
        NewsControlPage.filterInactiveSwitchChecked();
        clickBack();
    }

    @Description("При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Панель Управления")
    @DisplayName("п280 При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Test
    public void shouldHaveCategories(){
        NewsPage.filterButtonClick();
        NewsPage.filterCategoryClick();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Панель Управления")
    @DisplayName("п282, 283 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        NewsPage.filterButtonClick();
        NewsPage.filterDateStartClick();
        AddNewNewsPage.calendarBaseCheck();
        AddNewNewsPage.timeOKButtonClick();
        NewsPage.filterDateEndClick();
        AddNewNewsPage.calendarBaseCheck();
        AddNewNewsPage.timeOKButtonClick();
        clickBack();
    }

    @Description("При тапе по кнопке Добавить (+) открывается старница Создание новости")
    @Story("Проверка Страницы Панель Управления")
    @DisplayName("п292 При тапе по кнопке Добавить (+) открывается старница Создание новости")
    @Test
    public void shouldOpenAddNewNewsPAgeWhenTapOnButton(){
        NewsPage.addNewNewsButtonClick();
        AddNewNewsPage.titleCheck("Создание");
        clickBack();
    }
}
