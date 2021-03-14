package tests;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("web ")
public class MainFlowTests extends TestBase {
    @Test
    @DisplayName("On a mine page must be following titles \"Set Retail\" , \"Set Touch\", \"Set Prisma\" ")
    void titlePageOpenTest(){
        open("");
        ElementsCollection featuresArray = $$(".featuresInfo");
        featuresArray.get(0).shouldHave(text("Set Retail"));
        featuresArray.get(1).shouldHave(text("Set Touch"));
        featuresArray.get(2).shouldHave(text("Set Prisma"));
    }
    @Test
    @DisplayName("Follow second feature link and request a presentation")
    void requestPresentationByFirstLink(){
        //open url and follow the second feature link
        open("");
        $$(".featuresInfo").get(1).$(byText("Узнать подробнее")).click();
        $(byText("Запросить презентацию")).click();
        //fill a form
        Faker faker = new Faker();
        $(byName("LEAD_NAME")).click();
        $("#LEAD_NAME").click();//.setValue(faker.name().firstName());
        $("#LEAD_LAST_NAME_CONT").setValue(faker.name().lastName());
        $("#LEAD_EMAIL").setValue(faker.internet().emailAddress());
        $("#LEAD_PHONE").setValue(faker.phoneNumber().phoneNumber());
        $("#LEAD_COMPANY_TITLE").setValue(faker.company().name());
        //$("#SUBMIT_BUTTON").click();

        sleep(3000);
    }

}
