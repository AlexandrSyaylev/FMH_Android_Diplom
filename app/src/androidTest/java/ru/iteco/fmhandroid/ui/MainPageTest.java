package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.ClaimPage;
import ru.iteco.fmhandroid.ui.Pages.NewsPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;
import ru.iteco.fmhandroid.ui.Pages.MainPage;
import ru.iteco.fmhandroid.ui.Pages.NewsCard;

public class MainPageTest extends BeforeTestLogin{
    @Test
    public void headerHasRequiredElements() {
        pause();
        HeaderPage.mainMenuButton.check(matches(isDisplayed()));
        HeaderPage.logoView.check(matches(isDisplayed()));
        HeaderPage.logoView.check(matches(not(isClickable())));
        HeaderPage.thematicButton.check(matches(isDisplayed()));
        HeaderPage.lkButton.check(matches(isDisplayed()));
    }

    @Test
    public void shouldHaveRequiredElements(){
        pause();
        MainPage.containerNewsHeader.check(matches(isDisplayed()));
        MainPage.newsContainerOneClickable.check(matches(isDisplayed()));
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));
        MainPage.newsHeaderTitle.check(matches(withText("Новости")));

        MainPage.newsCollapseButton.check(matches(isDisplayed()));
        MainPage.newsAllNewsButton.check(matches(isDisplayed()));
        MainPage.newsAllNewsButton.check(matches(withText("ВСЕ НОВОСТИ")));

        NewsCard.newsTitle.check(matches(isDisplayed()));
        NewsCard.newsCategoryImage.check(matches(isDisplayed()));
        NewsCard.newsDate.check(matches(isDisplayed()));
        NewsCard.newsDescription.check(matches(not(isDisplayed())));

        MainPage.claimBlockHeader.check(matches(isDisplayed()));
        MainPage.claimBlockHeader.check(matches(withText("Заявки")));
        MainPage.claimBlockHeader.perform(swipeUp());
        MainPage.claimAddNewButton.check(matches(isDisplayed()));
        MainPage.claimExpandButton.check(matches(isDisplayed()));
        MainPage.claimShowAllButton.check(matches(isDisplayed()));
        MainPage.claimAddNewButton.check(matches(isClickable()));
        onView(withIndex(withId(R.id.news_item_material_card_view), 1)).check(matches(isClickable()));
        MainPage.claimShowAllButton.check(matches(isClickable()));
        MainPage.claimShowAllButton.check(matches(withText("ВСЕ ЗАЯВКИ")));
        MainPage.claimShowAllButton.perform(swipeUp());
    }

    @Test
    public void shouldShowAndHideDescriptionFieldWhenTapNews(){
        MainPage.containerNewsHeader.perform(click());
        onView(withIndex(withId(R.id.news_item_description_text_view), 1)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenPageNewsWhenTapOnButtonAllNews(){
//        pause();
        MainPage.newsAllNewsButton.perform(click());
        pauseShort();
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        MainPage.claimBlockHeader.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenPageClaimsWhenTapOnButtonAllClaims(){
//        pause();
        MainPage.claimShowAllButton.perform(click());
        pauseShort();
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
        clickBack();
        pauseShort();
        MainPage.newsHeaderTitle.check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowHeaderWhenSwipeUp(){
//        pause();
        MainPage.claimShowAllButton.perform(customSwipeUp());
        pauseShort();
        HeaderPage.logoView.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenNewsPageWhenTapNewsInMainMenu(){
//        pause();
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.newsPageButton.perform(click());
        pauseShort();
        NewsPage.titleNewsHeader.check(matches(isDisplayed()));
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.perform(click());
        pauseShort();
        HeaderPage.logoView.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenClaimPageWhenTapNewsInMainMenu(){
//        pause();
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.claimPageButton.perform(click());
        pauseShort();
        ClaimPage.titleClaimHeader.check(matches(isDisplayed()));
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.mainPageButton.perform(click());
        pauseShort();
        HeaderPage.logoView.check(matches(isDisplayed()));
    }
}
