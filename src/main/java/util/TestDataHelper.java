package util;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TestDataHelper {

    private final static Faker FAKER = Faker.instance();

    public static String getFutureDate(int plusDays, DateTimeFormatter dateTimeFormatter) {
        return LocalDate.now()
                        .plusDays(plusDays)
                        .format(dateTimeFormatter);
    }

    public static Faker getFaker() {
        return FAKER;
    }

    public static int getRandomInt(int numberOfDigits) {
        return Math.toIntExact(FAKER.number().randomNumber(numberOfDigits, true));
    }

    public Map<String, Object> getCreatedBookingApiPayload() {
        Map<String, Object> createBookingPayload = new HashMap<>();
        createBookingPayload.put("firstname", FAKER.name().firstName());
        createBookingPayload.put("lastname", FAKER.name().lastName());
        createBookingPayload.put("totalprice", FAKER.number().numberBetween(100, 500));
        createBookingPayload.put("depositpaid", FAKER.bool().bool());
        createBookingPayload.put("additionalneeds", FAKER.food().dish());
        var numberOfPlusDays = TestDataHelper.getRandomInt(2);
        var dateFormatter = DateTimeFormatter.ISO_DATE;
        TestDataHelper.getFutureDate(numberOfPlusDays + 4, dateFormatter);
        Map <String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", TestDataHelper.getFutureDate(numberOfPlusDays, dateFormatter));
        bookingdates.put("checkout", TestDataHelper.getFutureDate(numberOfPlusDays, dateFormatter));
        createBookingPayload.put("bookingdates", bookingdates);

        return createBookingPayload;

    }
}
