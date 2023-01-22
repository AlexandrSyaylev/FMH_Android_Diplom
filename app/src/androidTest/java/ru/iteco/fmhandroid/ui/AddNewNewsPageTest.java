package ru.iteco.fmhandroid.ui;

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

import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;

public class AddNewNewsPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
        NewsPage.controlPanelButton.perform(click());
        NewsPage.addNewNewsButton.perform(click());
    }

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
    }

    @Test
    public void shouldHaveAllCategoriesInDropMenu(){
        AddNewNewsPage.categoryField.perform(click());
        AddNewNewsPage.categoryField.perform(closeSoftKeyboard());
        pauseShort();

        AddNewNewsPage.categoryDropDownA.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownB.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownC.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownD.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownE.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownF.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownG.check(matches(isDisplayed()));
        AddNewNewsPage.categoryDropDownH.check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowMessageWhenClosePage(){
        AddNewNewsPage.cancelButton.perform(click());
        AddNewNewsPage.noSaveChangesMessage.check(matches(isDisplayed()));
        AddNewNewsPage.noSaveChangesMessage.check(matches(withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        AddNewNewsPage.noSaveChangesCancelButton.check(matches(isDisplayed()));
        AddNewNewsPage.noSaveChangesCancelButton.check(matches(withText("Отмена")));
        AddNewNewsPage.noSaveChangesCancelButton.check(matches(isClickable()));

        AddNewNewsPage.noSaveChangesOkButton.check(matches(isDisplayed()));
        AddNewNewsPage.noSaveChangesOkButton.check(matches(withText("OK")));
        AddNewNewsPage.noSaveChangesOkButton.check(matches(isClickable()));

        AddNewNewsPage.noSaveChangesCancelButton.perform(click());
        pauseShort();
        AddNewNewsPage.titleHeader.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        NewsPage.controlPanelTitle.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenNewsPageCNTRLPalnelWhenClickBackWOChanges(){
        clickBack();
        pauseShort();
        NewsPage.controlPanelTitle.check(matches(isDisplayed()));
    }

    @Test
    public void shouldClosePopupWhenTapCancel(){
        AddNewNewsPage.cancelButton.perform(click());
        AddNewNewsPage.noSaveChangesCancelButton.perform(click());
        pauseShort();
        AddNewNewsPage.titleHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenNewsPageCntrlPanelWhenTapOKOnPopup(){
        AddNewNewsPage.cancelButton.perform(click());
        AddNewNewsPage.noSaveChangesOkButton.perform(click());
        NewsPage.controlPanelTitle.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        AddNewNewsPage.dateField.perform(click());
        pauseShort();
        AddNewNewsPage.calendarView.check(matches(isDisplayed()));
        AddNewNewsPage.calendarCancelButton.check(matches(isDisplayed()));
        AddNewNewsPage.calendarOkButton.check(matches(isDisplayed()));
        AddNewNewsPage.calendarCancelButton.check(matches(isClickable()));
        AddNewNewsPage.calendarOkButton.check(matches(isClickable()));
    }

    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewNewsPage.timeField.perform(click());
        pauseShort();
        AddNewNewsPage.timeHeader.check(matches(isDisplayed()));
        AddNewNewsPage.timeCancelButton.check(matches(isDisplayed()));
        AddNewNewsPage.timeOKButton.check(matches(isDisplayed()));
        AddNewNewsPage.timeOKButton.check(matches(isClickable()));
        AddNewNewsPage.timeCancelButton.check(matches(isClickable()));
    }
}
