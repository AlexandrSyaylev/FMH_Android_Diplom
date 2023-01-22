package ru.iteco.fmhandroid.ui.Pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Pages.BasePage;
import lombok.Getter;

public class AboutPage extends BasePage {
    public static String aboutUsTextRu = "Версия:";
    public static String aboutUsTextEn = "Version: ";
    public static String aboutUsVersionRu = "1.0.0";
    public static String aboutUsVersionEn = "1.0.0";
    public static String policyTextRu = "Политика конфиденциальности:";
    public static String policyTextEn = "Privacy Policy: ";
    public static String policyLinkRu = "https://vhospice.org/#/privacy-policy";
    public static String policyLinkEn = "https://vhospice.org/#/privacy-policy/ ";
    public static String userAgreementTextRu = "Пользовательское соглашение:";
    public static String userAgreementTextEn = "Terms of use: ";
    public static String userAgreementLinkRu = "https://vhospice.org/#/terms-of-use";
    public static String userAgreementLinkEn = "https://vhospice.org/#/terms-of-use ";
    public static String companyInfo = "© Айтеко, 2022";
    public static String our_mission_title_text = "Главное - жить любя";

    public static ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    public static ViewInteraction logoView = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction versionTitleId = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction versionTextId = onView(withId(R.id.about_version_value_text_view));
    public static ViewInteraction policyTextId = onView(withId(R.id.about_privacy_policy_label_text_view));
    public static ViewInteraction policyLinkId = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction userAgreementTextId = onView(withId(R.id.about_terms_of_use_label_text_view));
    public static ViewInteraction userAgreementLinkId = onView(withId(R.id.about_terms_of_use_value_text_view));
    public static ViewInteraction companyId = onView(withId(R.id.about_company_info_label_text_view));
}
