import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.Duration;

import java.util.Locale;
import java.util.Random;
import java.util.logging.Formatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryTest {
    Faker faker = new Faker(new Locale("ru"));


    @Test
    void shouldSendFormV1() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "980x900";
        open("http://localhost:9999/");
        $x("//input[@placeholder = 'Город']").val(DataGenerator.Registration.generateInfo("ru").getCity());
        $x("//input[@placeholder ='Дата встречи']").doubleClick();
        $x("//input[@placeholder ='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder ='Дата встречи']").val(DataGenerator.Registration.generateDate(4));
        $x("//input[@name= 'name']").val(DataGenerator.Registration.generateInfo("ru").getName());
        $x("//input[@name= 'phone']").val(faker.numerify("+7##########"));
        $(".checkbox__box").click();
        $(".button[role='button']").click();
        $(".notification__title").should(Condition.visible, Duration.ofSeconds(15));
        $(".notification__content").should(Condition.visible, Duration.ofSeconds(15));



    }

}
