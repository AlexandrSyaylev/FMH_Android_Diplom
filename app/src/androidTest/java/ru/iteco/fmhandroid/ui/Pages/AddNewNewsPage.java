package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AddNewNewsPage extends BasePage{
    public static ViewInteraction titleHeader = onView(withId(R.id.custom_app_bar_title_text_view));
    public static ViewInteraction subTitleHeader = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    public static ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction categoryFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_category_text_auto_complete_text_view))));
    public static ViewInteraction categoryFieldIconDropDown = onView(withContentDescription("Показать раскрывающееся меню"));
    public static ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction titleFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_title_text_input_edit_text))));
    public static ViewInteraction dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction dateFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_publish_date_text_input_edit_text))));
    public static ViewInteraction timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction timeFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_publish_time_text_input_edit_text))));
    public static ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction descriptionFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.news_item_description_text_input_edit_text))));
    public static ViewInteraction switcherButton = onView(withId(R.id.switcher));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    public static ViewInteraction categoryDropDownA = onView(withText("Объявление")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownB = onView(withText("День рождения")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownC = onView(withText("Зарплата")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownD = onView(withText("Профсоюз")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownE = onView(withText("Праздник")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownF = onView(withText("Массаж")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownG = onView(withText("Благодарность")).inRoot(isPopupWindow());
    public static ViewInteraction categoryDropDownH = onView(withText("Нужна помощь")).inRoot(isPopupWindow());

    public static ViewInteraction noSaveChangesMessage = onView(withText("Изменения не будут сохранены. Вы действительно хотите выйти?"));
    public static ViewInteraction noSaveChangesCancelButton = onView(withText("Отмена"));
    public static ViewInteraction noSaveChangesOkButton = onView(withId(android.R.id.button1));

    public static ViewInteraction calendarOkButton = onView(withId(android.R.id.button1));
    public static ViewInteraction calendarCancelButton = onView(withId(android.R.id.button2));
    public static ViewInteraction calendarView = onView(withId(android.R.id.custom));
    public static ViewInteraction timeHeader = onView(withId(android.R.id.custom));
    public static ViewInteraction timeOKButton = onView(withId(android.R.id.button1));
    public static ViewInteraction timeCancelButton = onView(withId(android.R.id.button2));
}
