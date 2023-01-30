package ru.iteco.fmhandroid.ui.tests;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.BeforeTestLogin;
import ru.iteco.fmhandroid.ui.pages.AddNewClaimPage;
import ru.iteco.fmhandroid.ui.pages.AddNewNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class AddNewClaimPageTest extends BeforeTestLogin {
    @Before
    @DisplayName("п219 При тапе по кнопке Добавить Заявку (+) на странице Заяки открывается страница Создание заявки ")
    public void openNewClaimPage() {
        MainPage.claimAddNewButtonClick();
        AddNewClaimPage.titleHeaderCheck();
    }

    @Description("Страница содержит поля ...")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п220-223,229 Страница содержит поля ...")
    @Test
    public void shouldHaveRequiredElements(){
        AddNewClaimPage.elementsCheckAll();
        clickBack();
    }

    @Description("Появляется модальное окно с иформацией о несохраненных действиях и кнопками \"Отмена\" и \"ОК\"")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п225, 226 Появляется модальное окно с иформацией о несохраненных действиях и кнопками \n" +
            " \"Отмена\" и \"ОК\" при тапе \"Отмена\" при наличии изменений")
    @Test
    public void shouldShowPopupWhenTapCancelButton(){
        AddNewClaimPage.titleFieldClickAndHide();
        AddNewClaimPage.cancelButtonClick();
        AddNewClaimPage.noChangesMessageCheck();

        AddNewClaimPage.noSaveChangesCancelButtonClick();
        AddNewClaimPage.titleHeaderCheck();
        clickBack();
    }

    @Description("При тапе по кнопке \"Отмена\" на странице создания заявки модальное окно закрывается")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п227 При тапе по кнопке \"Отмена\" на странице создания заявки модальное окно закрывается, пользоавтель остается на странице Создания заявки")
    @Test
    public void shouldOpenMainPageIfTapOkButtonOnPopup(){
        AddNewClaimPage.cancelButtonClick();
        AddNewClaimPage.noSaveChangesOkButtonClick();
        MainPage.claimBlockHeaderCheck();
    }

    @Description("При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п301 При сохранении Новости с хотя бы одним незаполненным полем появляется сообщение \"Заполните пустые поля\"")
    @Test
    public void shouldShowErrorWithEmptyFields(){
        AddNewClaimPage.saveButtonClick();
        AddNewClaimPage.emptyFieldMessageCheck();
        AddNewClaimPage.emptyFieldOkButtonClick();
        clickBack();
    }

    @Description("При тапе по полю Дата открывается календарь")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п233 При тапе по полю Дата открывается календарь")
    @Test
    public void shouldOpenCalendarWhenTapDateField(){
        AddNewClaimPage.dateFieldClick();
        AddNewNewsPage.calendarBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("При тапе по полю Время открывается интерактивное окно с часами")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п235 При тапе по полю Время открывается интерактивное окно с часами")
    @Test
    public void shouldOpenClockWhenTapTimeField(){
        AddNewClaimPage.timeFieldClick();
        AddNewNewsPage.clockBaseCheck();
        clickBack();
        clickBack();
    }

    @Description("Нельзя создать завку с пустым полем Комментарий, или комментарием из произвольного количества пробелов")
    @Story("Проверка Страницы Создание заявки")
    @DisplayName("п241 Нельзя создать завку с пустым полем Комментарий, или комментарием из произвольного количества пробелов")
    @Test
    public void shouldShowErrorWithSpacesInCommentFields(){
        AddNewClaimPage.titleFieldType("login2");
        AddNewClaimPage.dateFieldClick();
        AddNewClaimPage.calendarOkButtonClick();
        AddNewClaimPage.timeFieldClick();
        AddNewClaimPage.timeOKButtonClick();
        AddNewClaimPage.descriptionFieldType("     ");
        AddNewClaimPage.descriptionFieldHide();
        AddNewClaimPage.saveButtonClick();

        AddNewClaimPage.emptyFieldMessageCheck();

        AddNewClaimPage.emptyFieldOkButtonClick();
        AddNewClaimPage.descriptionFieldHide();
        clickBack();
    }
}
