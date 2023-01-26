package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class NewsPageTest extends BeforeTestLogin {
    @Before
    @Step("Открыть страницу новости")
    public void openNewsPage() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
    }

    @Description("Страница Новости содержит поля ...")
    @Story("Проверка Страницы Новости")
    @Step("п245,246 На странице Новости в заголовке блока есть ...")
    @Test
    public void shouldHaveRequiredElements(){
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
        NewsPage.titleNewsHeader.check(matches(withText("Новости")));
        NewsPage.filterButton.check(matches(isDisplayed()));
        NewsPage.filterButton.check(matches(isClickable()));
        NewsPage.sorterButton.check(matches(isDisplayed()));
        NewsPage.sorterButton.check(matches(isClickable()));
        NewsPage.controlPanelButton.check(matches(isDisplayed()));
        NewsPage.controlPanelButton.check(matches(isDisplayed()));
        NewsPage.controlPanelButton.check(matches(isClickable()));

        onView(withIndex(withId(R.id.category_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(not(isDisplayed())));
    }

    @Description("При тапе по кнопке раскрыть новость, отображается описание новости")
    @Story("Проверка Страницы Новости")
    @Step("п249 При тапе по кнопке раскрыть новость, отображается описание новости")
    @Test
    public void shouldShowDescriptionWhenTapOnNews(){
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    @Description("Присутствует хедер")
    @Story("Проверка Страницы Новости")
    @Step("п253 Присутствует хедер, При скролле вверх новости прокручиваются, хедер закреплен")
    @Test
    public void shouldHaveHeader(){
        headerCheck();
        onView(withIndex(withId(R.id.news_item_title_text_view), 4)).perform(customSwipeUp());
        pauseShort();
        headerCheck();
    }

    @Description("При тапе по кнопке Редактровать открывается панель управления новостями")
    @Story("Проверка Страницы Новости")
    @Step("п254 При тапе по кнопке Редактровать открывается панель управления новостями")
    @Test
    public void shouldSwitchToControlPanelAndBack(){
        NewsPage.controlPanelButton.perform(click());
        pauseShort();
        NewsControlPage.controlPanelTitle.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Новости")
    @Step("п255,256 При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Test
    public void shouldOpenFilterPage(){
        NewsPage.filterButton.perform(click());
        pauseShort();
        NewsPage.filterBaseCheck();
        clickBack();
    }

    @Description("При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Новости")
    @Step("п257 При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Test
    public void shouldHaveCategories(){
        NewsPage.filterButton.perform(click());
        pauseShort();
        NewsPage.filterCategory.perform(click());
        NewsPage.filterCategory.perform(closeSoftKeyboard());
        pauseShort();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        pauseSSt();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Новости")
    @Step("п259,260 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        NewsPage.filterButton.perform(click());
        pauseShort();
        NewsPage.filterDateStart.perform(click());
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        AddNewNewsPage.timeOKButton.perform(click());
        pauseShort();
        NewsPage.filterDateEnd.perform(click());
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        pauseShort();
        AddNewNewsPage.timeOKButton.perform(click());
        clickBack();
    }
}
