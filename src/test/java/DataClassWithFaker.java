import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class DataClassWithFaker {

    private static Faker faker;

    private void printTestData(RegistrationInfo info) {
    }

    public void printTestData(String name, String phone, String cardNumber) {
        System.out.println("======================");
        System.out.println(name);
        System.out.println(phone);
        System.out.println(cardNumber);
        System.out.println("======================");
    }

    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }


    @Test
    public void shouldGenerateData() {
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
        String date = String.valueOf(faker.date().birthday());
        printTestData(name, phone, cardNumber);
    }

    @Test
    void shouldGenerateTestDataUsingUtils() {
        RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");
        printTestData(info);
    }


}
