package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimPage extends BasePage {
    public static ViewInteraction titleClaimHeader = onView(withText("Заявки"));
    public static ViewInteraction filterButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));

    //popup filter
    public static ViewInteraction filterView = onView(withId(R.id.customPanel));
    public static ViewInteraction filterTitle = onView(withId(R.id.claim_filter_dialog_title));
    public static ViewInteraction statusOpen = onView(withId(R.id.item_filter_open));
    public static ViewInteraction statusInProgress = onView(withId(R.id.item_filter_in_progress));
    public static ViewInteraction statusExecuted = onView(withId(R.id.item_filter_executed));
    public static ViewInteraction statusCancelled = onView(withId(R.id.item_filter_cancelled));
    public static ViewInteraction filterOkButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    public static ViewInteraction filterCancelButton = onView(withId(R.id.claim_filter_cancel_material_button));

}
