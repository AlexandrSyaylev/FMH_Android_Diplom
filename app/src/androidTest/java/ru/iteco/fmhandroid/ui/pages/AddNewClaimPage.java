package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AddNewClaimPage extends BasePage{
    private static ViewInteraction titleHeader = onView(withId(R.id.custom_app_bar_title_text_view));
    private static ViewInteraction subTitleHeader = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    private static ViewInteraction titleField = onView(withId(R.id.title_edit_text));
    private static ViewInteraction titleFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.title_edit_text))));
    private static ViewInteraction textCounter = onView(withId(R.id.textinput_counter));
    private static ViewInteraction executorField = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    private static ViewInteraction executorFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.executor_drop_menu_auto_complete_text_view))));
    private static ViewInteraction executorFieldIcon = onView(withId(R.id.text_input_end_icon));
    private static ViewInteraction dateField = onView(withId(R.id.date_in_plan_text_input_edit_text));
    private static ViewInteraction dateFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.date_in_plan_text_input_edit_text))));
    private static ViewInteraction timeField = onView(withId(R.id.time_in_plan_text_input_edit_text));
    private static ViewInteraction timeFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.time_in_plan_text_input_edit_text))));
    private static ViewInteraction descriptionField = onView(withId(R.id.description_edit_text));
    private static ViewInteraction descriptionFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.description_edit_text))));
    private static ViewInteraction saveButton = onView(withId(R.id.save_button));
    private static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    private static ViewInteraction noSaveChangesMessage = onView(withText("Изменения не будут сохранены. Вы действительно хотите выйти?"));
    private static ViewInteraction noSaveChangesCancelButton = onView(withText("Отмена"));
    private static ViewInteraction noSaveChangesOkButton = onView(withText("OK"));

    private static ViewInteraction calendarOkButton = onView(withId(android.R.id.button1));
    private static ViewInteraction calendarCancelButton = onView(withId(android.R.id.button2));
    private static ViewInteraction calendarView = onView(withId(android.R.id.custom));
    private static ViewInteraction timeHeader = onView(withId(android.R.id.custom));
    private static ViewInteraction timeOKButton = onView(withId(android.R.id.button1));
    private static ViewInteraction timeCancelButton = onView(withId(android.R.id.button2));

    private static ViewInteraction emptyFieldMessage = onView(withText("Заполните пустые поля"));
    private static ViewInteraction emptyFieldOkButton = onView(withId(android.R.id.button1));


    @Step("Проверка наличия заголовка Создание страницы")
    public static void titleHeaderCheck(){
        waitUntilElement(R.id.custom_app_bar_title_text_view);
        titleHeader.check(matches(isDisplayed()));
    }
    @Step("Тапнуть по кнопке Отмена страницы создание заявки")
    public static void cancelButtonClick(){
        waitUntilElement(R.id.cancel_button);
        cancelButton.perform(click());
    }
    @Step("Тапнуть по кнопке Отмена окна сообщения")
    public static void noSaveChangesCancelButtonClick(){
        waitUntilElement("Отмена");
        noSaveChangesCancelButton.perform(click());
    }
    @Step("Тапнуть по кнопке OK")
    public static void calendarOkButtonClick(){
        calendarOkButton.perform(click());
    }
    @Step("Тапнуть по кнопке OK")
    public static void timeFieldClick(){
        timeField.perform(click());
    }
    @Step("Тапнуть по кнопке")
    public static void timeOKButtonClick(){
        timeOKButton.perform(click());
    }
    @Step("Тапнуть по кнопке OK")
    public static void dateFieldClick(){
        dateField.perform(click());
    }
    @Step("Тапнуть по кнопке Сохранить")
    public static void saveButtonClick(){
        saveButton.perform(click());
    }
    @Step("Тапнуть по кнопке Сохранить")
    public static void emptyFieldOkButtonClick(){
        emptyFieldOkButton.perform(click());
    }
    @Step("Тапнуть по кнопке OK окна сообщения")
    public static void noSaveChangesOkButtonClick(){
        noSaveChangesOkButton.perform(click());
    }
    @Step("Тапнуть по полю и спрятать клавиатуру")
    public static void descriptionFieldHide(){
        descriptionField.perform(closeSoftKeyboard());
        waitUntilKeyboardHide();
    }
    @Step("Тапнуть по полю и спрятать клавиатуру")
    public static void titleFieldClickAndHide(){
        titleField.perform(click());
        titleField.perform(closeSoftKeyboard());
    }
    @Step("Ввести в поле значение")
    public static void titleFieldType(String text){
        typeT(titleField, text);
    }
    @Step("Ввести в поле значение")
    public static void descriptionFieldType(String text){
        typeT(descriptionField, text);
    }
    @Step("Проверка наличия всех элементов на странице")
    public static void elementsCheckAll(){
        titleHeader.check(matches(isDisplayed()));
        subTitleHeader.check(matches(isDisplayed()));
        titleField.check(matches(isDisplayed()));
        textCounter.check(matches(isDisplayed()));
        executorField.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.text_input_end_icon), 1)).check(matches(isDisplayed()));
        dateField.check(matches(isDisplayed()));
        timeField.check(matches(isDisplayed()));
        descriptionField.check(matches(isDisplayed()));
        saveButton.check(matches(isDisplayed()));
        cancelButton.check(matches(isDisplayed()));

        saveButton.check(matches(isClickable()));
        cancelButton.check(matches(isClickable()));

        saveButton.check(matches(withText("Сохранить")));
        cancelButton.check(matches(withText("Отмена")));

        titleHeader.check(matches(withText("Создание")));
        subTitleHeader.check(matches(withText("Заявки")));

        titleField.check(matches(withHint("Тема")));
        executorField.check(matches(withHint("Исполнитель")));
        dateField.check(matches(withHint("Дата")));
        timeField.check(matches(withHint("Время")));
        descriptionField.check(matches(withHint("Описание")));
    }
    @Step("Проверка сообщения об ошибке в виде вспылающего окна")
    public static void emptyFieldMessageCheck(){
        waitUntilElement("Заполните пустые поля");
        emptyFieldMessage.check(matches(isDisplayed()));
        emptyFieldOkButton.check(matches(isDisplayed()));
        emptyFieldMessage.check(matches(withText("Заполните пустые поля")));
        emptyFieldOkButton.check(matches(withText("OK")));
        emptyFieldOkButton.check(matches(isClickable()));
    }
    @Step("проверка сообщения о несохраненных изменениях на странице")
    public static void noChangesMessageCheck(){
        waitUntilElement("Изменения не будут сохранены. Вы действительно хотите выйти?");
        noSaveChangesMessage.check(matches(isDisplayed()));
        noSaveChangesMessage.check(matches(withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        noSaveChangesCancelButton.check(matches(isDisplayed()));
        noSaveChangesCancelButton.check(matches(withText("Отмена")));
        noSaveChangesCancelButton.check(matches(isClickable()));

        noSaveChangesOkButton.check(matches(isDisplayed()));
        noSaveChangesOkButton.check(matches(withText("OK")));
        noSaveChangesOkButton.check(matches(isClickable()));
    }
}
