package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ThematicPage extends BasePage{

    public static ViewInteraction titleText = onView(withId(R.id.our_mission_title_text_view));
    public static ViewInteraction missionOneContainerClickable = onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0));
    public static ViewInteraction missionImage = onView(withIndex(withId(R.id.our_mission_item_image_view), 0));
    public static ViewInteraction missionCollapseButton = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    public static ViewInteraction missionTitle = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    public static ViewInteraction missionDescription = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
}
