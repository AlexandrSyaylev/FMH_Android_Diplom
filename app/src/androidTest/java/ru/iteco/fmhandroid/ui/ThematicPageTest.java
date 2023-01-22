package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Before;
import org.junit.Test;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.ThematicPage;

public class ThematicPageTest extends BeforeTestLogin{
    @Before
    public void openPage(){
        pause();
        HeaderPage.thematicButton.perform(click());
        pauseShort();
    }

    @Test
    public void shouldHaveRequiredElements(){
        ThematicPage.titleText.check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_image_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0)).check(matches(not(isDisplayed())));
        ThematicPage.titleText.check(matches(withText("Главное - жить любя")));
    }

    @Test
    public void shouldHaveHeaderAndHeaderShouldBeWhenSwipeUp(){
        headerCheck();
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 2)).perform(customSwipeUp());
        headerCheck();
    }

    @Test
    public void shouldShowDescriptionWhenTapOnCard(){
        onView(withIndex(withId(R.id.our_mission_item_material_card_view), 0)).perform(click());
        onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0)).check(matches(isDisplayed()));
    }
}
