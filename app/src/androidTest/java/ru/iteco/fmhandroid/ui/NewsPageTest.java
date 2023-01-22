package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class NewsPageTest extends BeforeTestLogin{
    @Before
    public void openNewsPage() {
//        login();
        pause();
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
    }
    @After
    public void exit(){
//        logout();
    }

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

    @Test
    public void shouldShowDescriptionWhenTapOnNews(){
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayNewsFieldsForControlPanel(){
        NewsPage.controlPanelButton.perform(click());
        NewsPage.controlPanelTitle.check(matches(isDisplayed()));
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
    }

    @Test
    public void shouldSwitchToControlPanelAndBack(){
        NewsPage.controlPanelButton.perform(click());
        NewsPage.controlPanelTitle.check(matches(isDisplayed()));
        clickBack();
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldHaveHeader(){
        headerCheck();
    }
}
