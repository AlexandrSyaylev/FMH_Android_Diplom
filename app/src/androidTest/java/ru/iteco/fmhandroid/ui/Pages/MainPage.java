package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class MainPage extends BasePage {
    public static ViewInteraction containerAllNews = onView( //шапка с надписью новостью ???
            allOf(withId(R.id.container_list_news_include_on_fragment_main),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                    isDisplayed()));
    public static ViewInteraction containerOneNews = onView( //блок новостей из 3х элементов родительский (вложен в LinearLayout) виден при сворачивании
            allOf(withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                    isDisplayed()));
    public static ViewInteraction containerNewsHeader = onView( //общий блок новостей на главной странице (из 3х элементов) под кнопкой ВСЕ НОВОСТИ
            allOf(withId(R.id.all_news_cards_block_constraint_layout),
                    withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                    isDisplayed()));
    public static ViewInteraction newsContainerOneClickable = onView(withIndex(withId(R.id.news_item_material_card_view), 0));//контейнер одной новости кликабельный, и 3 экз на главной!!!
    public static ViewInteraction newsHeader = onView( //шапка новости???
            allOf(withId(R.id.container_list_claim_include_on_fragment_main),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                    isDisplayed()));
    public static ViewInteraction newsHeaderTitle = onView(withText("Новости"));
    public static ViewInteraction newsCollapseButton = onView(withIndex(withId(R.id.expand_material_button), 0));
    public static ViewInteraction newsAllNewsButton = onView(withId(R.id.all_news_text_view));


    public static ViewInteraction claimBlockHeader = onView(// общий блок
            allOf(withText("Заявки"),
                    withParent(withParent(withId(R.id.container_list_claim_include_on_fragment_main))),
                    isDisplayed()));
    public static ViewInteraction claimAddNewButton = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction claimExpandButton = onView(withIndex(withId(R.id.news_item_material_card_view), 1));
    public static ViewInteraction claimShowAllButton = onView(withId(R.id.all_claims_text_view));

    public static void countNewsIs(int i){
//        onView(withId(R.id.news_item_material_card_view)).check(matches(allOf(
//                isDisplayed(),
//                hasChildren(is(i))
//        )));
        onView(withId(R.id.container_list_news_include_on_fragment_main)).check(matches(allOf(
                isDisplayed(),
                hasChildren(is(i))
        )));
    }

    public static void newsContainerOneIsHidden() {
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
//        newsHeaderTitle.perform(click());
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(not(isDisplayed())));
    }

    public static void newsContainerClick() {
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
//        newsHeaderTitle.perform(click());
    }
}
