package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class MainPage extends BasePage {
    private static ViewInteraction containerAllNews = onView( //шапка с надписью новостью ???
            allOf(withId(R.id.container_list_news_include_on_fragment_main),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                    isDisplayed()));
    private static ViewInteraction containerNewsHeader = onView( //общий блок новостей на главной странице (из 3х элементов) под кнопкой ВСЕ НОВОСТИ
            allOf(withId(R.id.all_news_cards_block_constraint_layout),
                    withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                    isDisplayed()));
    private static ViewInteraction newsContainerOneClickable = onView(withIndex(withId(R.id.news_item_material_card_view), 0));//контейнер одной новости кликабельный, и 3 экз на главной!!!

    private static ViewInteraction newsHeaderTitle = onView(withText("Новости"));
    private static ViewInteraction newsCollapseButton = onView(withIndex(withId(R.id.expand_material_button), 0));
    private static ViewInteraction newsAllNewsButton = onView(withId(R.id.all_news_text_view));


    private static ViewInteraction claimBlockHeader = onView(// общий блок
            allOf(withText("Заявки"),
                    withParent(withParent(withId(R.id.container_list_claim_include_on_fragment_main))),
                    isDisplayed()));
    private static ViewInteraction claimAddNewButton = onView(withId(R.id.add_new_claim_material_button));
    private static ViewInteraction claimExpandButton = onView(withIndex(withId(R.id.news_item_material_card_view), 1));
    private static ViewInteraction claimShowAllButton = onView(withId(R.id.all_claims_text_view));

    public static void countNewsIs(int i){
        onView(withId(R.id.container_list_news_include_on_fragment_main)).check(matches(allOf(
                isDisplayed(),
                hasChildren(is(i))
        )));
    }

    @Step("Wait for loading page")
    public static void waitLoadMainPage(){
        waitUntilElement(R.id.news_item_material_card_view);
    }
    @Step("Проверка что блок отображается")
    public static void newsContainerOneClickableCheck(){
        exist(newsContainerOneClickable);
    }
    @Step("Проверка что блок отображается")
    public static void containerNewsHeaderCheck(){
        exist(containerNewsHeader);
    }
    @Step("Тап по блоку, появляется блок Описание")
    public static void containerNewsHeaderClick(){
        containerNewsHeader.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 1)).check(matches(isDisplayed()));
    }
    @Step("Проверка что кнопка отображается")
    public static void claimAddNewButtonCheck(){
        exist(claimAddNewButton);
    }
    @Step("Тап по кнопке")
    public static void claimAddNewButtonClick(){
        claimAddNewButton.perform(click());
        waitUntilElement("Заявки");
    }
    @Step("Проверка что кнопка отображается")
    public static void claimExpandButtonCheck(){
        exist(claimExpandButton);
    }
    @Step("Тап по кнопке")
    public static void claimExpandButtonClick(){
        claimExpandButton.perform(click());
    }
    @Step("Проверка что кнопка отображается")
    public static void claimShowAllButtonCheck(){
        exist(claimShowAllButton);
    }
    @Step("Тап по кнопке")
    public static void claimShowAllButtonClick(){
        claimShowAllButton.perform(click());
    }
    @Step("Проверка что отображается заголовок Заявки")
    public static void claimBlockHeaderCheck(){
        waitUntilElement("Заявки");
        existText(claimBlockHeader, "Заявки");
    }
    @Step("Свайп вверх на объекте")
    public static void claimShowAllButtonSwipe(){
        claimShowAllButton.perform(customSwipeUp());
    }
    @Step("Свайп вверх на объекте")
    public static void claimBlockHeaderSwipe(){
        claimBlockHeader.perform(customSwipeUp());
    }
    @Step("Проверка что отображается заголовок Новости")
    public static void newsHeaderTitleCheck(){
        waitUntilElement("Новости");
        existText(newsHeaderTitle, "Новости");
    }
    @Step("Проверка что кнопка отображается")
    public static void newsCollapseButtonCheck(){
        exist(newsCollapseButton);
    }
    @Step("Тап по кнопке")
    public static void newsCollapseButtonClick(){
        newsCollapseButton.perform(click());
    }
    @Step("Проверка что кнопка отображается")
    public static void newsAllNewsButtonCheck(){
        existClickableText(newsAllNewsButton, "ВСЕ НОВОСТИ");
    }
    @Step("Проверка что кнопка НЕотображается")
    public static void newsAllNewsButtonNotCheck(){
        newsAllNewsButton.check(matches(not(isDisplayed())));
    }
    @Step("Тап по кнопке")
    public static void newsAllNewsButtonClick(){
        newsAllNewsButton.perform(click());
    }
    @Step("Проверка карточки новостей")
    public static void newsOneClickable(){
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isClickable()));
    }

    @Step("Проверка что контейнер свернут")
    public static void newsContainerOneIsHidden() {
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
//        newsHeaderTitle.perform(click());
        onView(withIndex(withId(R.id.news_item_material_card_view), 0)).check(matches(not(isDisplayed())));
    }

    @Step("Проверка что контейнер разворачивается")
    public static void newsContainerClick() {
        onView(withIndex(withId(R.id.expand_material_button), 0)).perform(click());
//        newsHeaderTitle.perform(click());
    }
}
