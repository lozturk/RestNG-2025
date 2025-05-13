import apis.*;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.ApiRequestHelper;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class PartialUpdateBookingApiTests extends BaseTest{

    @DataProvider(name = "partialUpdateBookingData", parallel = true)
    public Object[][] partialUpdateBookingData() {
        var name = this.faker.name();
        var number = this.faker.number();
        var list = new ArrayList<Object[]>();
        for (int i = 0; i < 3; i++) {
            var objects = new Object[]{name.firstName(), name.lastName(), Math.toIntExact(number.randomNumber(2, true))};
            list.add(objects);
        }
        return list.toArray(new Object[0][]);
    }


    @Test(description = "Update a current booking with partial payload and validate HTTP Status code", dataProvider = "partialUpdateBookingData")
    public void partialUpdateAndValidateStatusCode(String firstName, String lastName, int randomNumber) {



        // get first current booking id
        int bookingId =  new GetBookingApi(LogDetail.STATUS).getAllBookingIds().body().jsonPath().getInt("bookingid["+ randomNumber + "]");
        var getCurrentBooking = new GetBookingApi().getBookingById(bookingId)
                                                       .then().assertThat().statusCode(200);
        System.out.println("Name to be updated: " + firstName + " " + lastName);

        // partial update booking with partial payload
        var partialUpdateBookingPayload = ApiRequestHelper.getPartialUpdateBookingPayload(firstName, lastName);
        var partialUpdateBookingApi  = new PartialUpdateBookingApi();
        var username = System.getenv("RESTBOOKER_USERNAME");
        var password = System.getenv("RESTBOOKER_PASSWORD");
        var partialUpdateBookingApiResponse = partialUpdateBookingApi.partialUpdateBooking(partialUpdateBookingPayload,bookingId, username, password)
                                                                     .then().assertThat().statusCode(200)
                                                                     .and().body("firstname", is(equalTo(firstName)))
                                                                     .and().body("lastname", is(equalTo(lastName)));
    }

}