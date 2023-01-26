package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.qameta.allure.kotlin.Attachment;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class EditNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
        NewsPage.controlPanelButton.perform(click());
        onView(withIndex(withId(R.id.edit_news_item_image_view), 0)).perform(click());
    }

    @Description("Страница содержит заголовок \"Редактирование Новости\"")
    @Story("Проверка Страницы Редактирование Новости")
    @Step("п319,320, Страница содержит заголовок \"Редактирование Новости\"")
    @Test
    public void shouldHaveRequiredElements(){
        AddNewNewsPage.titleHeader.check(matches(isDisplayed()));
        AddNewNewsPage.subTitleHeader.check(matches(isDisplayed()));
        AddNewNewsPage.categoryField.check(matches(isDisplayed()));
        AddNewNewsPage.categoryFieldIconDropDown.check(matches(isDisplayed()));
        AddNewNewsPage.titleField.check(matches(isDisplayed()));
        AddNewNewsPage.dateField.check(matches(isDisplayed()));
        AddNewNewsPage.timeField.check(matches(isDisplayed()));
        AddNewNewsPage.descriptionField.check(matches(isDisplayed()));
        AddNewNewsPage.switcherButton.check(matches(isDisplayed()));
        AddNewNewsPage.saveButton.check(matches(isDisplayed()));
        AddNewNewsPage.cancelButton.check(matches(isDisplayed()));

        AddNewNewsPage.switcherButton.check(matches(isClickable()));
        AddNewNewsPage.saveButton.check(matches(isClickable()));
        AddNewNewsPage.cancelButton.check(matches(isClickable()));
        AddNewNewsPage.categoryField.check(matches(isClickable()));

        AddNewNewsPage.switcherButton.check(matches(withText("Активна")));

        AddNewNewsPage.saveButton.check(matches(withText("Сохранить")));
        AddNewNewsPage.cancelButton.check(matches(withText("Отмена")));

        AddNewNewsPage.titleHeader.check(matches(withText("Редактирование")));
        AddNewNewsPage.subTitleHeader.check(matches(withText("Новости")));

        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Редактирование Новости")
    @Step("п322 Раскрывающийся список Категория содержит перечень категорий")
    @Test
    public void shouldHaveAllCategoriesInDropMenu(){
        AddNewNewsPage.categoryField.perform(click());
        pauseSSt();
        AddNewNewsPage.categoryField.perform(clearText());
        pauseSSt();
        AddNewNewsPage.categoryField.perform(click());
        pauseSSt();
        AddNewNewsPage.categoryField.perform(closeSoftKeyboard());
        pauseShort();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        pauseShort();
        AddNewNewsPage.cancelButton.perform(click());
        pauseSSt();
        AddNewNewsPage.noSaveChangesOkButton.perform(click());
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Редактирование Новости")
    @Step("п325,336 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewNewsPage.descriptionField.perform(click());
        AddNewNewsPage.descriptionField.perform(clearText());
        AddNewNewsPage.descriptionField.perform(closeSoftKeyboard());
        pauseShort();
        AddNewNewsPage.saveButton.perform(click());
        onView(withText(R.string.empty_fields)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Заполните пустые поля")));
        pauseShort();
        clickBack();
        pauseShort();
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Редактирование Новости")
    @Step("п327 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){ //!
        AddNewNewsPage.dateField.perform(click());
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Редактирование Новости")
    @Step("п329 При тапе по полю Время открываются часы")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewNewsPage.timeField.perform(click());
        pauseShort();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }
}
