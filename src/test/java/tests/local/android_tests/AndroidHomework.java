package tests.local.android_tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidHomework extends TestBase {


    @Test
    @Tag("android")
    void searchTestBrowserStack() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Tag("android")
    @Test
    void searchTestMicrosoft() {
        String valueTitleCheck = "Microsoft";
        String valueDescriptionCheck = "American multinational technology corporation";
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(valueTitleCheck);
        });
        step("Verify content found", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(text(valueTitleCheck));
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                    .shouldHave(text(valueDescriptionCheck));

        });
    }

    @Tag("android")
    @Test
    void testOnboarding(){
        $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        $(AppiumBy.xpath("//android.widget.LinearLayout[2]")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("New ways to explore"));
        $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                .shouldHave(text("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
                        "Customize the feed to your interests – whether it’s learning about historical events On this day, " +
                        "or rolling the dice with Random."));
        $(AppiumBy.xpath("//android.widget.LinearLayout[3]")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Reading lists with sync"));
        $(AppiumBy.xpath("//android.widget.LinearLayout[4]")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Send anonymous data"));
    }




    @Test
    @Tag("android")
    @DisplayName("Проверка онбординга")
    @Description("Проверка перехода между экранами онбординга и текстов на экранах ")
    void onboardingTest() {

        step("Check the onboarding first screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("We’ve found the following on your device:"));
        });

        step("Moving to the second screen", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]")).click();
        });

        step("Check the onboarding second screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Dive down the Wikipedia rabbit hole with " +
                    "a constantly updating Explore feed. Customize the feed to your interests – whether it’s learning about historical " +
                    "events On this day, or rolling the dice with Random."));
        });

        step("Moving to the third screen", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
        });

        step("Check the onboarding third screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("You can make reading lists from " +
                    "articles you want to read later, even when you’re offline. Login to your Wikipedia account to sync your " +
                    "reading lists. Join Wikipedia"));
        });

        step("Moving to the fourth screen", () -> {
            $(AppiumBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[4]")).click();
        });

        step("Check the onboarding fourth screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Help make the app better" +
                    " by letting us know how you use it. Data collected is anonymous. Learn more"));
        });

    }


    @Test
    @Tag("android")
    @DisplayName("Проверка текста на стартовом экране")
    @Description("Проверка текста на стартовом экране. Экран после онбординга")
    void checkTextStartScreen() {
        step("Skip onboarding", Selenide::back);

        step("check text", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(text("Customize your Explore feed You can now choose what to show on your feed," +
                            " and also prioritize your favorite types of content."));
        });
    }


    @Test
    @Tag("android")
    @DisplayName("Проверка экрана Настроить ленту'")
    @Description("Проверка открытия экрана Настроить ленту и текста на нем")
    void searchScreenTape() {

        step("Skip onboarding", Selenide::back);

        step("Moving to screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_announcement_action_positive")).click();
        });

        step("Check text", () -> {
            $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
                    + "/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView"))
                    .shouldHave(text("Customize the feed"));
        });
    }

    @Test
    @Tag("android")
    @DisplayName("Проверка экрана перехода через tabbar'")
    @Description("Проверка перехода по таббару и текста на экранах ")
    void checkTabbar() {
        step("Skip onboarding", Selenide::back);

        step("Moving to the Saved screen from tab bar", () -> {
            $(MobileBy.AccessibilityId("Saved")).click();
        });

        step("Check text on screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/messageTitleView"))
                    .shouldHave(text("Sync reading lists"));
        });

        step("Moving to the Search screen from tab bar", () -> {
            $(MobileBy.AccessibilityId("Search")).click();
        });

        step("Check text on screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/history_title")).shouldHave(text("History"));
        });

        step("Moving to the Edits screen from tab bar", () -> {
            $(MobileBy.AccessibilityId("Edits")).click();
        });

        step("Check text on screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(text("Did you " +
                    "know that everyone can edit Wikipedia?"));
        });

        step("Moving to the More screen from tab bar", () -> {
            $(MobileBy.AccessibilityId("More")).click();
        });

        step("Check text on screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_account_container")).shouldHave(visible);
        });

    }


}
