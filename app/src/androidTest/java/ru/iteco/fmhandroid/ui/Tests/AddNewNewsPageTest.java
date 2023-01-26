package ru.iteco.fmhandroid.ui.Tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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

public class AddNewNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
        NewsPage.controlPanelButton.perform(click());
        NewsPage.addNewNewsButton.perform(click());
        pauseShort();
    }

    @Description("Страница содержит заголовок \"Создание Новости\"")
    @Story("Проверка Страницы Создание Новости")
    @Step("п295,296,313 Страница содержит заголовок \"Создание Новости\"")
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

        AddNewNewsPage.switcherButton.check(matches(isChecked()));
        AddNewNewsPage.switcherButton.check(matches(withText("Активна")));

        AddNewNewsPage.saveButton.check(matches(withText("Сохранить")));
        AddNewNewsPage.cancelButton.check(matches(withText("Отмена")));

        AddNewNewsPage.titleHeader.check(matches(withText("Создание")));
        AddNewNewsPage.subTitleHeader.check(matches(withText("Новости")));

        AddNewNewsPage.categoryField.check(matches(withHint("Категория")));
        AddNewNewsPage.titleField.check(matches(withHint("Заголовок")));
        AddNewNewsPage.dateField.check(matches(withHint("Дата публикации")));
        AddNewNewsPage.timeField.check(matches(withHint("Время")));
        AddNewNewsPage.descriptionField.check(matches(withHint("Описание")));
        AddNewNewsPage.switcherButton.check(matches(isChecked()));
        clickBack();
    }

    @Description("Раскрывающийся список Категория содержит перечень категорий")
    @Story("Проверка Страницы Создание Новости")
    @Step("п297 Раскрывающийся список Категория содержит перечень категорий")
    @Test
    public void shouldHaveAllCategoriesInDropMenu(){
        AddNewNewsPage.categoryField.perform(click());
        AddNewNewsPage.categoryField.perform(closeSoftKeyboard());
        pauseShort();
        AddNewNewsPage.categoryDropListCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание Новости")
    @Step("п301,316 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewNewsPage.saveButton.perform(click());
        onView(withText(R.string.empty_fields)).inRoot(new BeforeTestLogin.ToastMatcher())
                .check(matches(withText("Заполните пустые поля")));
        pauseShort();
        clickBack();
        pauseShort();
    }

    @Description("Страница содержит заголовок \"Создание Новости\"")
    @Story("Проверка Страницы Создание Новости")
    @Step("п295 Страница содержит заголовок \"Создание Новости\"")
    @Test
    public void shouldOpenNewsPageCntrlPanelWhenTapOKOnPopup(){
        AddNewNewsPage.cancelButton.perform(click());
        AddNewNewsPage.noSaveChangesOkButton.perform(click());
        NewsControlPage.controlPanelTitle.check(matches(isDisplayed()));
    }

    @Description("При тапе по полю Дата открывается календарь на текущей дате")
    @Story("Проверка Страницы Создание Новости")
    @Step("п303 При тапе по полю Дата открывается календарь на текущей дате")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        AddNewNewsPage.dateField.perform(click());
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        pauseShort();
        clickBack();
    }

    @Description("При тапе по полю Время открываются часы")
    @Story("Проверка Страницы Создание Новости")
    @Step("п305 При тапе по полю Время открываются часы")
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
