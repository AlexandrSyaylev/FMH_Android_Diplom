package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimCard extends BasePage{
    public static ViewInteraction claimOneContainer = onView(withIndex(withId(R.id.claim_list_card), 0));
    public static ViewInteraction claimThemeTitle = onView(withIndex(withId(R.id.title_material_text_view), 0));
    public static ViewInteraction claimThemeTitleText = onView(withId(R.id.title_material_text_view));
    public static ViewInteraction claimThemeDescription = onView(withIndex(withId(R.id.description_material_text_view), 0));
    public static ViewInteraction claimExecutorTitle = onView(withIndex(withId(R.id.executor_name_label_material_text_view), 0));
    public static ViewInteraction claimExecutorName = onView(withIndex(withId(R.id.executor_name_material_text_view), 0));
    public static ViewInteraction claimDividerLine = onView(withIndex(withId(R.id.claim_middle_divider_image_view), 0));
    public static ViewInteraction claimDateTitle = onView(withIndex(withId(R.id.plan_date_label_material_text_view), 0));
    public static ViewInteraction claimDateValue = onView(withIndex(withId(R.id.plan_date_material_text_view), 0));
    public static ViewInteraction claimTimeValue = onView(withIndex(withId(R.id.plan_time_material_text_view), 0));

    //claim full view
    public static ViewInteraction claimThemeTitleFull = onView(withId(R.id.title_label_text_view));
    public static ViewInteraction claimThemeTitleTextFull = onView(withId(R.id.title_text_view));
    public static ViewInteraction claimExecutorTitleFull = onView(withId(R.id.executor_name_label_text_view));
    public static ViewInteraction claimExecutorNameFull = onView(withId(R.id.executor_name_text_view));
    public static ViewInteraction claimDateTitleFull = onView(withId(R.id.plane_date_label_text_view));
    public static ViewInteraction claimDateValueFull = onView(withId(R.id.plane_date_text_view));
    public static ViewInteraction claimTimeValueFull = onView(withId(R.id.plan_time_text_view));
    public static ViewInteraction claimStatusView = onView(withId(R.id.status_icon_image_view));
    public static ViewInteraction claimDescriptionText = onView(withId(R.id.description_text_view));
    public static ViewInteraction claimAuthorTitle = onView(withId(R.id.author_label_text_view));
    public static ViewInteraction claimAuthorValue = onView(withId(R.id.author_name_text_view));
    public static ViewInteraction claimCreateTitle = onView(withId(R.id.create_data_label_text_view));
    public static ViewInteraction claimCreateDate = onView(withId(R.id.create_data_text_view));
    public static ViewInteraction claimCreateTime = onView(withId(R.id.create_time_text_view));
    public static ViewInteraction claimCommentBlock = onView(withId(R.id.comments_material_card_view));
    public static ViewInteraction claimCommentAddButton = onView(withId(R.id.add_comment_image_button));
    public static ViewInteraction claimCloseButton = onView(withId(R.id.close_image_button));
    public static ViewInteraction claimStatusButton = onView(withId(R.id.status_processing_image_button));
    public static ViewInteraction claimEditButton = onView(withId(R.id.edit_processing_image_button));
}
