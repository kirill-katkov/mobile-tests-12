package tests.browserstack;
import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class HomeWorkTest extends TestBase {
    @Test
    void searchTest() {
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
}
