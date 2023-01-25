package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsCard;
import ru.iteco.fmhandroid.ui.Pages.NewsControlPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class NewsControlPageTest extends BeforeTestLogin{
    @Before
    public void openControlPage(){
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
        NewsPage.controlPanelButton.perform(click());
        pauseShort();
    }

    @Description("На странице в заголовке блока есть текст \"Панель управления\"...")
    @Story("Проверка Страницы Панель Управления")
    @Step("п267-269,271-275 На странице в заголовке блока есть текст \"Панель управления\"...")
    @Test
    public void shouldDisplayNewsFieldsForControlPanel(){
        NewsControlPage.controlPanelTitle.check(matches(isDisplayed()));
        NewsPage.addNewNewsButton.check(matches(isDisplayed()));
        NewsPage.addNewNewsButton.check(matches(isClickable()));

        onView(withIndex(withId(R.id.category_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_publication_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_creation_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_create_date_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_author_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_author_name_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_published_icon_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.news_item_published_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));

        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isClickable()));
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isClickable()));

        onView(withIndex(withId(R.id.news_item_publication_text_view), 0)).check(matches(withText("Дата публикации")));
        onView(withIndex(withId(R.id.news_item_creation_text_view), 0)).check(matches(withText("Дата создания")));
        onView(withIndex(withId(R.id.news_item_author_text_view), 0)).check(matches(withText("Автор")));

        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        NewsCard.newsDescription.check(matches(isDisplayed()));
        pauseShort();
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
    }

    @Description("При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Story("Проверка Страницы Панель Управления")
    @Step("п278,279,286 При тапе по кнопке Фильтр открывается модальное окно фильтра")
    @Test
    public void shouldOpenFilterPage(){
        NewsPage.filterButton.perform(click());
        pauseShort();
        NewsPage.filterBaseCheck();
        NewsControlPage.filterActiveSwitch.check(matches(isDisplayed()));
        NewsControlPage.filterInactiveSwitch.check(matches(isDisplayed()));
        NewsControlPage.filterActiveSwitch.check(matches(isChecked()));
        NewsControlPage.filterInactiveSwitch.check(matches(isChecked()));
        clickBack();
    }

    @Description("При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Story("Проверка Страницы Панель Управления")
    @Step("п280 При тапе по селектору \"Категория\" раскрывается выпадающий список с категориями")
    @Test
    public void shouldHaveCategories(){
        NewsPage.filterButton.perform(click());
        pauseShort();
        NewsPage.filterCategory.perform(click());
        NewsPage.filterCategory.perform(closeSoftKeyboard());
        pauseShort();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Панель Управления")
    @Step("п282, 283 При тапе по полю Дата открывается календарь на текущей дате")
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
        AddNewNewsPage.timeOKButton.perform(click());
        clickBack();
    }

    @Description("При тапе по кнопке Добавить (+) открывается старница Создание новости")
    @Story("Проверка Страницы Панель Управления")
    @Step("п292 При тапе по кнопке Добавить (+) открывается старница Создание новости")
    @Test
    public void shouldOpenAddNewNewsPAgeWhenTapOnButton(){
        NewsPage.addNewNewsButton.perform(click());
        pauseShort();
        AddNewNewsPage.titleHeader.check(matches(isDisplayed()));
        clickBack();
    }
}
