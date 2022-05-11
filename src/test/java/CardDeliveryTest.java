import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryTest {


    @Test
    void shouldSendFormV1() {
        var info = DataGenerator.Registration.generateInfo("ru");
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "980x900";
        var daysToAddForFirstMeeting = 4;
        var daysToAddForSecondMeeting = 5;
        open("http://localhost:9999/");
        $x("//input[@placeholder = 'Город']").val(info.getCity());
        $x("//input[@placeholder ='Дата встречи']").doubleClick();
        $x("//input[@placeholder ='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder ='Дата встречи']").val(DataGenerator.Registration.generateDate(daysToAddForFirstMeeting));
        $x("//input[@name= 'name']").val(info.getName());
        $x("//input[@name= 'phone']").val(info.getPhone());
        $(".checkbox__box").click();
        $(".button[role='button']").click();
        $("[data-test-id='success-notification']").should(Condition.visible, Condition.text("Успешно"),Condition.text("Встреча успешно запланирована на "));
        $x("//input[@placeholder ='Дата встречи']").doubleClick();
        $x("//input[@placeholder ='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder ='Дата встречи']").val(DataGenerator.Registration.generateDate(daysToAddForSecondMeeting));
        $(".button[role='button']").click();
        $("[class ='button button_view_extra button_size_s button_theme_alfa-on-white']").click();
        $("[data-test-id='success-notification']").should(Condition.visible,Condition.text("Встреча успешно запланирована на "));
        $x("//*[@id=\"root\"]/div/div[1]/div[3]").should(Condition.visible);

    }

}