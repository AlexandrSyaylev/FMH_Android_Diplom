package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AboutPage extends BasePage {
    private static String aboutUsTextRu = "Версия:";
    private static String aboutUsTextEn = "Version: ";
    private static String aboutUsVersionRu = "1.0.0";
    private static String aboutUsVersionEn = "1.0.0";
    private static String policyTextRu = "Политика конфиденциальности:";
    private static String policyTextEn = "Privacy Policy: ";
    private static String policyLinkRu = "https://vhospice.org/#/privacy-policy";
    private static String policyLinkEn = "https://vhospice.org/#/privacy-policy/ ";
    private static String userAgreementTextRu = "Пользовательское соглашение:";
    private static String userAgreementTextEn = "Terms of use: ";
    private static String userAgreementLinkRu = "https://vhospice.org/#/terms-of-use";
    private static String userAgreementLinkEn = "https://vhospice.org/#/terms-of-use ";
    private static String companyInfo = "© Айтеко, 2022";
    private static String our_mission_title_text = "Главное - жить любя";

    private static ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    private static ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    private static ViewInteraction versionTitleId = onView(withId(R.id.about_version_title_text_view));
    private static ViewInteraction versionTextId = onView(withId(R.id.about_version_value_text_view));
    private static ViewInteraction policyTextId = onView(withId(R.id.about_privacy_policy_label_text_view));
    private static ViewInteraction policyLinkId = onView(withId(R.id.about_privacy_policy_value_text_view));
    private static ViewInteraction userAgreementTextId = onView(withId(R.id.about_terms_of_use_label_text_view));
    private static ViewInteraction userAgreementLinkId = onView(withId(R.id.about_terms_of_use_value_text_view));
    private static ViewInteraction companyId = onView(withId(R.id.about_company_info_label_text_view));

    @Step("Кнопка видна и кликабельна")
    public static void backButtonCheck(){
        existClickable(backButton);
    }
    @Step("Тап по кнопке")
    public static void backButtonClick(){
        backButton.perform(click());
    }
    @Step("Лого присутствует и не кликабелен")
    public static void logoCheck(){
        existNotClickable(logoView);
    }
    @Step("Присутствует заголовок")
    public static void versionTitleIdCheck(){
        waitUntilElement(R.id.about_version_title_text_view);
        existText(versionTitleId, aboutUsTextRu);
    }
    @Step("Присутствует заголовок")
    public static void versionTextIdCheck(){
        existText(versionTextId, aboutUsVersionRu);
    }
    @Step("Присутствует ссылка")
    public static void policyLinkIdCheck(){
        existText(policyLinkId, policyLinkRu);
    }
    @Step("Присутствует заголовок")
    public static void policyTextIdCheck(){
        existText(policyTextId, policyTextRu);
    }
    @Step("Присутствует заголовок")
    public static void userAgreementTextIdCheck(){
        existText(userAgreementTextId, userAgreementTextRu);
    }
    @Step("Присутствует ссылка")
    public static void userAgreementLinkIdCheck(){
        existText(userAgreementLinkId, userAgreementLinkRu);
    }
    @Step("Присутствует ссылка")
    public static void companyIdCheck(){
        existText(companyId, companyInfo);
    }
}
