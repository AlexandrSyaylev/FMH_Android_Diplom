package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NewsCard extends BasePage{
    public static ViewInteraction newsHeaderTextId = onView(withText("Новости"));
    public static ViewInteraction newsAllButton = onView(withIndex(withId(R.id.all_news_text_view), 0)); //контейнер с надписью
    public static ViewInteraction newsCategoryImage = onView(withIndex(withId(R.id.category_icon_image_view), 0));
    public static ViewInteraction newsTitle = onView(withIndex(withId(R.id.news_item_title_text_view), 0));
    public static ViewInteraction newsExpandButton = onView(withIndex(withId(R.id.view_news_item_image_view), 0));
    public static ViewInteraction newsDate = onView(withIndex(withId(R.id.news_item_date_text_view), 0));
    public static ViewInteraction newsDescription = onView(withIndex(withId(R.id.news_item_description_text_view), 0)); //view only on expand news

    //in control panel mode + newsCategoryImage + newsCategoryImage + newsTitle
    public static ViewInteraction newsPublishDate = onView(withIndex(withId(R.id.news_item_publication_text_view), 0));
    public static ViewInteraction newsPublishDateValue = onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0));
    public static ViewInteraction newsCreationDate = onView(withIndex(withId(R.id.news_item_creation_text_view), 0));
    public static ViewInteraction newsCreateDateValue = onView(withIndex(withId(R.id.news_item_create_date_text_view), 0));
    public static ViewInteraction newsAuthorTitle = onView(withIndex(withId(R.id.news_item_author_text_view), 0));
    public static ViewInteraction newsAuthorValue = onView(withIndex(withId(R.id.news_item_author_name_text_view), 0));
    public static ViewInteraction newsStatusIcon = onView(withIndex(withId(R.id.news_item_published_icon_image_view), 0));
    public static ViewInteraction newsStatusText = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
    public static ViewInteraction newsDeleteButton = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
    public static ViewInteraction newsEditButton = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
    public static ViewInteraction newsCollapseDescriptionButton = onView(withIndex(withId(R.id.view_news_item_image_view), 0)); //not clickable

    @Step("Проверка наличия кнопки")
    public static void deleteButtonCheck(){
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).check(matches(isClickable()));
    }
    @Step("Тап по кнопке")
    public static void deleteButtonClick(){
        onView(withIndex(withId(R.id.delete_news_item_image_view), 0)).perform(click());
    }
    @Step("Проверка наличия кнопки")
    public static void editButtonCheck(){
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).check(matches(isClickable()));
    }
    @Step("Тап по кнопке")
    public static void editButtonClick(){
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }
    @Step("Проверка наличия кнопки status change")
    public static void statusButtonCheck(){
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).check(matches(isDisplayed()));
    }
    @Step("Тап по кнопке")
    public static void statusButtonClick(){
        onView(withIndex(withId(R.id.view_news_item_image_view), 0)).perform(click());
    }
    @Step("Проверка содержимого карточки новости (свернутой)")
    public static void newsCardFullShortCheck(){
        newsTitle.check(matches(isDisplayed()));
        newsCategoryImage.check(matches(isDisplayed()));
        newsDate.check(matches(isDisplayed()));
        newsDescription.check(matches(not(isDisplayed())));
    }
    @Step("Проверка содержимого карточки новости (свернутой)")
    public static void newsCardFullCheck(){
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

        onView(withIndex(withId(R.id.news_item_publication_text_view), 0)).check(matches(withText("Дата публикации")));
        onView(withIndex(withId(R.id.news_item_creation_text_view), 0)).check(matches(withText("Дата создания")));
        onView(withIndex(withId(R.id.news_item_author_text_view), 0)).check(matches(withText("Автор")));
    }

    @Step("Проверка содержимого карточки новости (свернутой)")
    public static void newsCardFullDescriptionsCheck(){
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 0)).check(matches(isDisplayed()));
    }
    @Step("Тап по карточке")
    public static void newsCardFullClick(){
        waitUntilElement(R.id.news_item_title_text_view);
        onView(withIndex(withId(R.id.news_item_title_text_view), 0)).perform(click());
    }
}
