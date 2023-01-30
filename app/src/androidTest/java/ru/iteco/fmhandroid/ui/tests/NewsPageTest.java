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
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class NewsPageTest extends BeforeTestLogin {
    @Before
    @DisplayName("Открыть страницу новости")
    public void openNewsPage() {
        HeaderPage.mainMenuButtonClick();
        MainMenuPage.newsPageButtonClick();
    }

    @Description("Страница Новости содержит поля ...")
    @Story("Проверка Страницы Новости")
    @DisplayName("п245,246 На странице Новости в заголовке блока есть ...")
    @Test
    public void shouldHaveRequiredElements(){
        NewsPage.titleNewsHeaderCheck();
        NewsPage.filterButtonCheck();
        NewsPage.sorterButtonCheck();
        NewsPage.controlPanelButtonCheck();
        NewsPage.newsCardStdCheck();
    }

    @Description("При тапе по кнопке раскрыть новость, отображается описание новости")
    @Story("Проверка Страницы Новости")
    @DisplayName("п249 При тапе по кнопке раскрыть новость, отображается описание новости")
    @Test
    public void shouldShowDescriptionWhenTapOnNews(){
        NewsPage.newsCardDescriptionsCheck();
    }

    @Description("Присутствует хедер")
    @Story("Проверка Страницы Новости")
    @DisplayName("п253 Присутствует хедер, При скролле вверх новости прокручиваются, хедер закреплен")
    @Test
    public void shouldHaveHeader(){
        headerCheck();
        NewsPage.swipeUpNewsBlock();
        headerCheck();
    }

    @Description("При тапе по кнопке Редактровать открывается панель управления новостями")
    @Story("Проверка Страницы Новости")
    @DisplayName("п254 При тапе по кнопке Редактровать открывается панель управления новостями")
    @Test
    public void shouldSwitchToControlPanelAndBack(){
        NewsPage.controlPanelButtonClick();
        NewsControlPage.controlPanelTitleCheck();
        clickBack();
        NewsPage.titleNewsHeaderCheck();
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Новости")
    @DisplayName("п255,256 При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Test
    public void shouldOpenFilterPage(){
        NewsPage.filterButtonClick();
        NewsPage.filterBaseCheck();
        clickBack();
    }

    @Description("При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Новости")
    @DisplayName("п257 При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Test
    public void shouldHaveCategories(){
        NewsPage.filterButtonClick();
        NewsPage.filterCategoryClick();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Новости")
    @DisplayName("п259,260 При тапе по полю Дата открывается календарь на текущей дате")
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
}
