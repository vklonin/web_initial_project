package tests;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
        //check opened page
        $(".touch_subtitle").shouldHave(text("Касса в лучшем виде"));
        $(byText("Запросить презентацию")).click();
        //fill a form
        Faker faker = new Faker();
        SelenideElement bx_form_iframe_8 = $(byName("bx_form_iframe_8"));
        switchTo().frame(bx_form_iframe_8);
        $("#LEAD_NAME").setValue(faker.name().firstName());
        $("#LEAD_LAST_NAME").setValue(faker.name().lastName());
        $("#LEAD_EMAIL").setValue(faker.internet().emailAddress());
        $(".crm-webform-input-phone").setValue(faker.phoneNumber().phoneNumber());
        $("#LEAD_COMPANY_TITLE").setValue(faker.company().name());
        $("#SUBMIT_BUTTON").click();
        //check that form is closed
        $(".touch_subtitle").shouldHave(text("Касса в лучшем виде"));
    }

}
