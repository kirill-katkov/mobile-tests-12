package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {
    @Test
    @Tag("wikipedia")
    @DisplayName("Проверка поля ввода BrowserStack")
    @Description("Проверка со значением BrowserStack")
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

    @Tag("wikipedia")
    @Test
    @DisplayName("Проверка поля ввода Microsoft и проверка Description")
    @Description("Проверка со значением Microsoft")
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

    @Test
    @Tag("wikipedia")
    @DisplayName("Проверка онбординга")
    @Description("Проверка перехода между экранами онбординга и текстов на экранах ")
    void testOnboarding() {
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
    @Tag("wikipedia")
    @DisplayName("Проверка текста на стартовом экране")
    @Description("Проверка текста на стартовом экране. Экран после онбординга")
    void checkTextStartScreen() {
        step("Skip onboarding", Selenide::back);
        step("check text", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(text("Customize your Explore feed You can now choose what to show on your feed," +
                            " and also prioritize your favorite types of content."));
        });
    }

    @Test
    @Tag("wikipedia")
    @DisplayName("Проверка экрана Настроить ленту'")
    @Description("Проверка открытия экрана Настроить ленту и текста на нем")
    void searchScreenTape() {
        step("Skip onboarding", Selenide::back);
        step("Moving to screen", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_positive")).click();
        });
        step("Check text", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
                    + "/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView"))
                    .shouldHave(text("Customize the feed"));
        });
    }
}
