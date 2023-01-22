package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Test;

import ru.iteco.fmhandroid.ui.Pages.AboutPage;
import ru.iteco.fmhandroid.ui.Pages.HeaderPage;
import ru.iteco.fmhandroid.ui.Pages.MainMenuPage;

public class AboutPageTest extends BeforeTestLogin {
    @Test
    public void shouldHaveRequiredUIElements(){
        HeaderPage.mainMenuButton.perform(click());
        MainMenuPage.aboutPageButton.perform(click());
        onView(isRoot()).perform(waitFor(1000));

        AboutPage.backButton.check(matches(isDisplayed()));
        AboutPage.backButton.check(matches(isClickable()));

        AboutPage.logoView.check(matches(isDisplayed()));
        AboutPage.logoView.check(matches(not(isClickable())));

        AboutPage.versionTitleId.check(matches(isDisplayed()));
        AboutPage.versionTitleId.check(matches(withText(AboutPage.aboutUsTextRu)));

        AboutPage.versionTextId.check(matches(isDisplayed()));
        AboutPage.versionTextId.check(matches(withText(AboutPage.aboutUsVersionRu)));

        AboutPage.policyTextId.check(matches(isDisplayed()));
        AboutPage.policyTextId.check(matches(withText(AboutPage.policyTextRu)));

        AboutPage.policyLinkId.check(matches(isDisplayed()));
        AboutPage.policyLinkId.check(matches(withText(AboutPage.policyLinkRu)));

        AboutPage.userAgreementTextId.check(matches(isDisplayed()));
        AboutPage.userAgreementTextId.check(matches(withText(AboutPage.userAgreementTextRu)));

        AboutPage.userAgreementLinkId.check(matches(isDisplayed()));
        AboutPage.userAgreementLinkId.check(matches(withText(AboutPage.userAgreementLinkRu)));

        AboutPage.companyId.check(matches(isDisplayed()));
        AboutPage.companyId.check(matches(withText(AboutPage.companyInfo)));

        AboutPage.backButton.perform(click());
    }
}
