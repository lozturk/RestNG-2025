import apis.CreateBookingApi;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ApiRequestHelper;
import util.TestDataHelper;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.Matchers.*;

public class CreateBookingApiTests {

    private CreateBookingApi createBookingApi;
    private ApiRequestHelper apiRequestHelper;
    private Faker faker;

    @BeforeTest
    private void setCreateNewBookingApi() {
            this.createBookingApi = new CreateBookingApi();
            this.apiRequestHelper = new ApiRequestHelper();
    }

    // Provide Payload for Create Booking API
    @DataProvider(name = "provideCreateNewBookingData")
    public Object[][] provideCreateNewBookingData() {
        this.faker = TestDataHelper.getFaker();
        var dateFormatter = DateTimeFormatter.ISO_DATE;

        int numberOfTestCases = 1; // Number of test data sets to generate
        Object[][] testData = new Object[numberOfTestCases][7];

        for (int i = 0; i < numberOfTestCases; i++) {
            var firstname = faker.name().firstName();
            var lastName = faker.name().lastName();
            var totalPrice = faker.number().numberBetween(100, 500);
            var depositPaid = faker.bool().bool();
            var additionalNeeds = faker.food().dish();
            var numberOfPlusDays = TestDataHelper.getRandomInt(2);

            testData[i] = new Object[]{
                    firstname,
                    lastName,
                    totalPrice,
                    depositPaid,
                    additionalNeeds,
                    TestDataHelper.getFutureDate(numberOfPlusDays, dateFormatter),
                    TestDataHelper.getFutureDate(numberOfPlusDays + 4, dateFormatter)
            };
        }

        return testData;
    }

    @Test (description = "Create a new booking and validate HTTP Status code", dataProvider = "provideCreateNewBookingData")
    public void createNewBookingAndValidateStatusCode(String firstName, String lastName, Integer totalPrice, Boolean depositPaid,
                                                      String additionalNeeds, String checkInDate, String checkOutDate) {
        var createBookingPayload = apiRequestHelper
                .getCreateBookingApiPayload(firstName, lastName, totalPrice, depositPaid, additionalNeeds, checkInDate, checkOutDate);
        var createBookingAndValidateStatusCode = createBookingApi
                .createNewBooking(createBookingPayload)
                .then().assertThat().statusCode(200)
                .and().body("bookingid", is(not(equalTo(0))));
    }







}
