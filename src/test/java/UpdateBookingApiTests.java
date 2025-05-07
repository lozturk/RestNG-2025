
import apis.UpdateBookingApi;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestDataHelper;
import static org.hamcrest.Matchers.*;

public class UpdateBookingApiTests {

    String userName;
    UpdateBookingApi updateBookingApi = new UpdateBookingApi();
    TestDataHelper testDataHelper = new TestDataHelper();

    @DataProvider(name = "updateBookingApiPayload")
    public Object[][] bookingDataWithStreams() {
        var updateBookingApiPayload = testDataHelper.getCreatedBookingApiPayload();
        userName = updateBookingApiPayload.get("username").toString();
        return new Object[][]{
                {updateBookingApiPayload,"1732","admin", "password123"},
                {updateBookingApiPayload,"1304","admin", "password123"},
        };
    }

    @Test (description = "Update an existing booking and validate HTTP Status code", dataProvider = "updateBookingApiPayload")
    public void updateAndValidateStatusCode(Object updateBookingApiPayload, Integer bookingId, String username, String password) {
        var updateBookingAndValidateStatusCode = updateBookingApi.updateBooking(updateBookingApiPayload, bookingId, username, password)
                .then().assertThat().statusCode(200)
                .and().body("username", is(equalTo(userName)));
    }




}
