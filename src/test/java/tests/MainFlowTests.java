package tests;


import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("web ")
public class MainFlowTests extends TestBase {
    @Test
    @DisplayName("On a mine page must be following titles \"Set Retail\" , \"Set Touch\", \"Set Prisma\" ")
    void titlePageOpenTest(){
        open("");

        ElementsCollection featuresArray = $$(".featuresText");
        featuresArray.get(0).shouldHave(text("Set Retail"));
        featuresArray.get(1).shouldHave(text("Set Touch"));
        featuresArray.get(2).shouldHave(text("Set Prisma"));

    }

}
