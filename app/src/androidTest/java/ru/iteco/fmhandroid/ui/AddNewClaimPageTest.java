package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Before;
import org.junit.Test;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;

public class AddNewClaimPageTest extends BeforeTestLogin {
    @Before
    public void openNewNewsPage() {
        MainPage.claimAddNewButton.perform(click());
        pauseShort();
    }

    @Test
    public void shouldHaveRequiredElements(){
        AddNewClaimPage.titleHeader.check(matches(isDisplayed()));
        AddNewClaimPage.subTitleHeader.check(matches(isDisplayed()));
        AddNewClaimPage.titleField.check(matches(isDisplayed()));
        AddNewClaimPage.textCounter.check(matches(isDisplayed()));
        AddNewClaimPage.executorField.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.text_input_end_icon), 1)).check(matches(isDisplayed()));
        AddNewClaimPage.dateField.check(matches(isDisplayed()));
        AddNewClaimPage.timeField.check(matches(isDisplayed()));
        AddNewClaimPage.descriptionField.check(matches(isDisplayed()));
        AddNewClaimPage.saveButton.check(matches(isDisplayed()));
        AddNewClaimPage.cancelButton.check(matches(isDisplayed()));

        AddNewClaimPage.saveButton.check(matches(isClickable()));
        AddNewClaimPage.cancelButton.check(matches(isClickable()));

        AddNewClaimPage.saveButton.check(matches(withText("Сохранить")));
        AddNewClaimPage.cancelButton.check(matches(withText("Отмена")));

        AddNewClaimPage.titleHeader.check(matches(withText("Создание")));
        AddNewClaimPage.subTitleHeader.check(matches(withText("Заявки")));

        AddNewClaimPage.titleField.check(matches(withHint("Тема")));
        AddNewClaimPage.executorField.check(matches(withHint("Исполнитель")));
        AddNewClaimPage.dateField.check(matches(withHint("Дата")));
        AddNewClaimPage.timeField.check(matches(withHint("Время")));
        AddNewClaimPage.descriptionField.check(matches(withHint("Описание")));
    }

    @Test
    public void shouldOpenClaimPageWhenTapBack(){
        clickBack();
        pauseShort();
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowPopupWhenTapCancelButton(){
        AddNewClaimPage.cancelButton.perform(click());
        AddNewClaimPage.noSaveChangesMessage.check(matches(isDisplayed()));
        AddNewClaimPage.noSaveChangesMessage.check(matches(withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        AddNewClaimPage.noSaveChangesCancelButton.check(matches(isDisplayed()));
        AddNewClaimPage.noSaveChangesCancelButton.check(matches(withText("Отмена")));
        AddNewClaimPage.noSaveChangesCancelButton.check(matches(isClickable()));

        AddNewClaimPage.noSaveChangesOkButton.check(matches(isDisplayed()));
        AddNewClaimPage.noSaveChangesOkButton.check(matches(withText("OK")));
        AddNewClaimPage.noSaveChangesOkButton.check(matches(isClickable()));

        AddNewClaimPage.noSaveChangesCancelButton.perform(click());
        pauseShort();
        AddNewClaimPage.titleHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenMainPageIfTapOkButtonOnPopup(){
        AddNewClaimPage.cancelButton.perform(click());
        AddNewClaimPage.noSaveChangesOkButton.perform(click());
        pauseShort();
        MainPage.claimBlockHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        AddNewClaimPage.dateField.perform(click());
        pauseShort();
        AddNewClaimPage.calendarView.check(matches(isDisplayed()));
        AddNewClaimPage.calendarCancelButton.check(matches(isDisplayed()));
        AddNewClaimPage.calendarOkButton.check(matches(isDisplayed()));
        AddNewClaimPage.calendarCancelButton.check(matches(isClickable()));
        AddNewClaimPage.calendarOkButton.check(matches(isClickable()));
    }

    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewClaimPage.timeField.perform(click());
        pauseShort();
        AddNewClaimPage.timeHeader.check(matches(isDisplayed()));
        AddNewClaimPage.timeCancelButton.check(matches(isDisplayed()));
        AddNewClaimPage.timeOKButton.check(matches(isDisplayed()));
        AddNewClaimPage.timeOKButton.check(matches(isClickable()));
        AddNewClaimPage.timeCancelButton.check(matches(isClickable()));
    }
}
