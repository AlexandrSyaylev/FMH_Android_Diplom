package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.Pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;

public class AddNewClaimPageTest extends BeforeTestLogin {
    @Step("п219 При тапе по кнопке Добавить Заявку (+) на странице Заяки открывается страница Создание заявки ")
    public void openNewClaimPage() {
        MainPage.claimAddNewButton.perform(click());
        pauseShort();
    }

    @Description("Страница содержит поля ...")
    @Story("Проверка Страницы Создание заявки")
    @Step("п220-223,229 Страница содержит поля ...")
    @Test
    public void shouldHaveRequiredElements(){
        openNewClaimPage();
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
        clickBack();
    }

    @Description("Появляется модальное окно с иформацией о несохраненных действиях и кнопками \"Отмена\" и \"ОК\"")
    @Story("Проверка Страницы Создание заявки")
    @Step("п225, 226 Появляется модальное окно с иформацией о несохраненных действиях и кнопками \n" +
            " \"Отмена\" и \"ОК\" при тапе \"Отмена\" при наличии изменений")
    @Test
    public void shouldShowPopupWhenTapCancelButton(){
        openNewClaimPage();
        AddNewClaimPage.titleField.perform(click());
        AddNewClaimPage.titleField.perform(closeSoftKeyboard());
        pauseShort();
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
        clickBack();
    }

    @Description("При тапе по кнопке \"Отмена\" на странице создания заявки модальное окно закрывается")
    @Story("Проверка Страницы Создание заявки")
    @Step("п227 При тапе по кнопке \"Отмена\" на странице создания заявки модальное окно закрывается, пользоавтель остается на странице Создания заявки")
    @Test
    public void shouldOpenMainPageIfTapOkButtonOnPopup(){
        openNewClaimPage();
        AddNewClaimPage.cancelButton.perform(click());
        AddNewClaimPage.noSaveChangesOkButton.perform(click());
        pauseShort();
        MainPage.claimBlockHeader.check(matches(isDisplayed()));
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание заявки")
    @Step("п301 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        openNewClaimPage();
        AddNewClaimPage.saveButton.perform(click());
        AddNewClaimPage.emptyFieldMessageCheck();
        AddNewClaimPage.emptyFieldOkButton.perform(click());
        pauseShort();
        clickBack();
        pauseShort();
    }

    @Description("При тапе по полю Дата открывается календарь")
    @Story("Проверка Страницы Создание заявки")
    @Step("п233 При тапе по полю Дата открывается календарь")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        openNewClaimPage();
        AddNewClaimPage.dateField.perform(click());
        pauseShort();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Время открывается интерактивное окно с часами")
    @Story("Проверка Страницы Создание заявки")
    @Step("п235 При тапе по полю Время открывается интерактивное окно с часами")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        openNewClaimPage();
        AddNewClaimPage.timeField.perform(click());
        pauseShort();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("Нельзя создать завку с пустым полем Комментарий, или комментарием из произвольного количества пробелов")
    @Story("Проверка Страницы Создание заявки")
    @Step("п241 Нельзя создать завку с пустым полем Комментарий, или комментарием из произвольного количества пробелов")
    @Test
    public void shouldShowErrorWithSpacesInCommentFields(){
        openNewClaimPage();
        AddNewClaimPage.titleField.perform(typeText("login2"));
        AddNewClaimPage.dateField.perform(click());
        pauseShort();
        AddNewClaimPage.calendarOkButton.perform(click());
        pauseShort();
        AddNewClaimPage.timeField.perform(click());
        pauseShort();
        AddNewClaimPage.timeOKButton.perform(click());
        pauseShort();
        AddNewClaimPage.descriptionField.perform(typeText("     "));
        AddNewClaimPage.descriptionField.perform(closeSoftKeyboard());
        AddNewClaimPage.saveButton.perform(click());
        pauseShort();

        AddNewClaimPage.emptyFieldMessage.check(matches(isDisplayed()));
        AddNewClaimPage.emptyFieldOkButton.check(matches(isDisplayed()));
        AddNewClaimPage.emptyFieldMessage.check(matches(withText("Заполните пустые поля")));
        AddNewClaimPage.emptyFieldOkButton.check(matches(withText("OK")));
        AddNewClaimPage.emptyFieldOkButton.check(matches(isClickable()));

        AddNewClaimPage.emptyFieldOkButton.perform(click());
        pauseShort();
        AddNewClaimPage.descriptionField.perform(closeSoftKeyboard());
        pauseShort();
        clickBack();
    }
}
