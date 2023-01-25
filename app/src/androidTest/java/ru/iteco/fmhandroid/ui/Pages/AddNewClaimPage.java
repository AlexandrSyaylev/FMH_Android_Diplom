package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AddNewClaimPage extends BasePage{
    public static ViewInteraction titleHeader = onView(withId(R.id.custom_app_bar_title_text_view));
    public static ViewInteraction subTitleHeader = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    public static ViewInteraction titleField = onView(withId(R.id.title_edit_text));
    public static ViewInteraction titleFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.title_edit_text))));
    public static ViewInteraction textCounter = onView(withId(R.id.textinput_counter));
    public static ViewInteraction executorField = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public static ViewInteraction executorFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.executor_drop_menu_auto_complete_text_view))));
    public static ViewInteraction executorFieldIcon = onView(withId(R.id.text_input_end_icon));
    public static ViewInteraction dateField = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction dateFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.date_in_plan_text_input_edit_text))));
    public static ViewInteraction timeField = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction timeFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.time_in_plan_text_input_edit_text))));
    public static ViewInteraction descriptionField = onView(withId(R.id.description_edit_text));
    public static ViewInteraction descriptionFieldAsText = onView(allOf(supportsInputMethods(), isDescendantOfA(withId(R.id.description_edit_text))));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    public static ViewInteraction noSaveChangesMessage = onView(withText("Изменения не будут сохранены. Вы действительно хотите выйти?"));
    public static ViewInteraction noSaveChangesCancelButton = onView(withText("Отмена"));
    public static ViewInteraction noSaveChangesOkButton = onView(withText("OK"));

    public static ViewInteraction calendarOkButton = onView(withId(android.R.id.button1));
    public static ViewInteraction calendarCancelButton = onView(withId(android.R.id.button2));
    public static ViewInteraction calendarView = onView(withId(android.R.id.custom));
    public static ViewInteraction timeHeader = onView(withId(android.R.id.custom));
    public static ViewInteraction timeOKButton = onView(withId(android.R.id.button1));
    public static ViewInteraction timeCancelButton = onView(withId(android.R.id.button2));

    public static ViewInteraction EmptyFieldMessage = onView(withText("Заполните пустые поля"));
    public static ViewInteraction EmptyFieldOkButton = onView(withId(android.R.id.button1));
}
