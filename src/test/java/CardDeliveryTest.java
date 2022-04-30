import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryTest {


    @Test
    void shouldSendFormV1() {

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "980x900";
        var daysToAddForFirstMeeting = 4;
        var daysToAddForSecondMeeting = 5;
        open("http://localhost:9999/");
        $x("//input[@placeholder = 'Город']").val(DataGenerator.Registration.generateInfo("ru").getCity());
        $x("//input[@placeholder ='Дата встречи']").doubleClick();
        $x("//input[@placeholder ='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder ='Дата встречи']").val(DataGenerator.Registration.generateDate(daysToAddForFirstMeeting));
        $x("//input[@name= 'name']").val(DataGenerator.Registration.generateInfo("ru").getName());
        $x("//input[@name= 'phone']").val(DataGenerator.Registration.generateInfo("ru").getPhone());
        $(".checkbox__box").click();
        $(".button[role='button']").click();
        $("[data-test-id='success-notification']").should(Condition.visible);
        $x("//input[@placeholder ='Дата встречи']").doubleClick();
        $x("//input[@placeholder ='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder ='Дата встречи']").val(DataGenerator.Registration.generateDate(daysToAddForSecondMeeting));
        $(".button[role='button']").click();
        $x("[data-test-id=replan-notification]").click();





    }

}
