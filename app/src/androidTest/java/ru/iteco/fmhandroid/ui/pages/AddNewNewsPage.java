package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AddNewNewsPage extends BasePage{
    private static ViewInteraction titleHeader = onView(withId(R.id.custom_app_bar_title_text_view));
    private static ViewInteraction subTitleHeader = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    private static ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private static ViewInteraction categoryFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_category_text_auto_complete_text_view))));
    private static ViewInteraction categoryFieldIconDropDown = onView(withContentDescription("Показать раскрывающееся меню"));
    private static ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    private static ViewInteraction titleFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_title_text_input_edit_text))));
    private static ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    private static ViewInteraction dateFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_publish_date_text_input_edit_text))));
    private static ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private static ViewInteraction timeFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_publish_time_text_input_edit_text))));
    private static ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    private static ViewInteraction descriptionFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_description_text_input_edit_text))));
    private static ViewInteraction switcherButton = onView(withId(R.id.switcher));
    private static ViewInteraction saveButton = onView(withId(R.id.save_button));
    private static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    private static ViewInteraction categoryDropDownA = onView(withText("Объявление")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownB = onView(withText("День рождения")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownC = onView(withText("Зарплата")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownD = onView(withText("Профсоюз")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownE = onView(withText("Праздник")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownF = onView(withText("Массаж")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownG = onView(withText("Благодарность")).inRoot(isPopupWindow());
    private static ViewInteraction categoryDropDownH = onView(withText("Нужна помощь")).inRoot(isPopupWindow());

    private static ViewInteraction noSaveChangesMessage = onView(withText("Изменения не будут сохранены. Вы действительно хотите выйти?"));
    private static ViewInteraction noSaveChangesCancelButton = onView(withText("Отмена"));
    private static ViewInteraction noSaveChangesOkButton = onView(withId(android.R.id.button1));

    private static ViewInteraction calendarOkButton = onView(withId(android.R.id.button1));
    private static ViewInteraction calendarCancelButton = onView(withId(android.R.id.button2));
    private static ViewInteraction calendarView = onView(withId(android.R.id.custom));
    private static ViewInteraction timeHeader = onView(withId(android.R.id.custom));
    private static ViewInteraction timeOKButton = onView(withId(android.R.id.button1));
    private static ViewInteraction timeCancelButton = onView(withId(android.R.id.button2));

    @Step("Ожидание загузки страницы")
    public static void newsAddEditPageLoadWaits(){
        waitUntilElement(R.id.save_button);
    }
    @Step("Тап по кнопке")
    public static void saveButtonClick(){
        waitUntilElement(R.id.save_button);
        saveButton.perform(click());
    }
    @Step("Проверка кнопки")
    public static void saveButtonCheck(){
        waitUntilElement(R.id.save_button);
    }
    @Step("Тап по кнопке")
    public static void cancelButtonClick(){
        waitUntilElement(R.id.cancel_button);
        cancelButton.perform(click());
    }
    @Step("Тап по кнопке")
    public static void noSaveChangesOkButtonClick(){
        waitUntilElement(android.R.id.button1);
        noSaveChangesOkButton.perform(click());
    }
    @Step("Тап по полю")
    public static void categoryFieldClick() {
        categoryField.perform(click());
    }
    @Step("Очистить поле")
    public static void categoryFieldClear() {
        categoryField.perform(clearText());
        pauseSSt();
    }
    @Step("Скрыть клавиатуру")
    public static void categoryFieldHide() {
        categoryField.perform(closeSoftKeyboard());
    }
    @Step("Тап по полю")
    public static void descriptionFieldClick() {
        descriptionField.perform(click());
    }
    @Step("Очистить поле")
    public static void descriptionFieldClear() {
        descriptionField.perform(clearText());
    }
    @Step("Скрыть клавиатуру")
    public static void descriptionFieldHide() {
        descriptionField.perform(closeSoftKeyboard());
        waitUntilKeyboardHide();
    }
    @Step("Тап по полю")
    public static void dateFieldClick(){
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        dateField.perform(click());
    }
    @Step("Тап по полю")
    public static void timeFieldClick(){
        timeField.perform(click());
    }
    @Step("Тап по кнопке")
    public static void timeOKButtonClick(){
        waitUntilElement(android.R.id.button1);
        timeOKButton.perform(click());
    }
    @Step("Тап по кнопке")
    public static void timeCancelButtonClick(){
        waitUntilElement(android.R.id.button2);
        timeCancelButton.perform(click());
    }
    @Step("Проверка заголовка страницы")
    public static void titleCheck(String text){
        waitUntilElement(R.id.custom_app_bar_title_text_view);
        existText(titleHeader, text);
        existText(subTitleHeader, "Новости");
    }
    @Step("Проверка свитчер включен")
    public static void switcherCheck(){
        switcherButton.check(matches(isChecked()));
    }
    @Step("Проверка элементов на странице")
    public static void fieldsCheck(){
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        categoryField.check(matches(isDisplayed()));
        categoryFieldIconDropDown.check(matches(isDisplayed()));
        titleField.check(matches(isDisplayed()));
        dateField.check(matches(isDisplayed()));
        timeField.check(matches(isDisplayed()));
        descriptionField.check(matches(isDisplayed()));
        switcherButton.check(matches(isDisplayed()));
        saveButton.check(matches(isDisplayed()));
        cancelButton.check(matches(isDisplayed()));

        switcherButton.check(matches(isClickable()));
        saveButton.check(matches(isClickable()));
        cancelButton.check(matches(isClickable()));
        categoryField.check(matches(isClickable()));

        switcherButton.check(matches(withText("Активна")));

        saveButton.check(matches(withText("Сохранить")));
        cancelButton.check(matches(withText("Отмена")));
    }
    @Step("Проверка плэйсхолдеров на странице")
    public static void placeholdersCheck(){
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        categoryField.check(matches(withHint("Категория")));
        titleField.check(matches(withHint("Заголовок")));
        dateField.check(matches(withHint("Дата публикации")));
        timeField.check(matches(withHint("Время")));
        descriptionField.check(matches(withHint("Описание")));
    }

    @Step("Category drop list open")
    public static void openDropList(){
        categoryField.perform(click());
        categoryField.perform(closeSoftKeyboard());
    }
    @Step("Проверка Каледнаря (базовая)")
    public static void calendarBaseCheck(){
        waitUntilElement(android.R.id.custom);
        calendarView.check(matches(isDisplayed()));
        calendarCancelButton.check(matches(isDisplayed()));
        calendarOkButton.check(matches(isDisplayed()));
        calendarCancelButton.check(matches(isClickable()));
        calendarOkButton.check(matches(isClickable()));
    }

    @Step("Проверка часов (базовая)")
    public static void clockBaseCheck(){
        waitUntilElement(android.R.id.custom);
        timeHeader.check(matches(isDisplayed()));
        timeCancelButton.check(matches(isDisplayed()));
        timeOKButton.check(matches(isDisplayed()));
        timeOKButton.check(matches(isClickable()));
        timeCancelButton.check(matches(isClickable()));
    }

    @Step("Проверка раскрывающегося списка")
    public static void categoryDropListCheck(){
        waitUntilPopup("Объявление");
        categoryDropDownA.check(matches(isDisplayed()));
        categoryDropDownB.check(matches(isDisplayed()));
        categoryDropDownC.check(matches(isDisplayed()));
        categoryDropDownD.check(matches(isDisplayed()));
        categoryDropDownE.check(matches(isDisplayed()));
        categoryDropDownF.check(matches(isDisplayed()));
        categoryDropDownG.check(matches(isDisplayed()));
        categoryDropDownH.check(matches(isDisplayed()));
    }
    @Step("Проверка сообщения об ошибке")
    public static void errorFillEmptyFieldsCheck(){
        onView(withText(R.string.empty_fields)).inRoot(new ToastMatcher())
                .check(matches(withText("Заполните пустые поля")));
    }
}
