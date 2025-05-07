package util;

import java.util.HashMap;
import java.util.Map;

public class ApiRequestHelper {



    public Map<String, Object> getCreateBookingApiPayload(String firstname, String lastname, int totalprice, boolean depositpaid,
                                                          String additionalneeds, String checkin, String checkout) {

        Map<String, Object> createBookingPayload = new HashMap<>();

        createBookingPayload.put("firstname", firstname);
        createBookingPayload.put("lastname", lastname);
        createBookingPayload.put("totalprice", totalprice);
        createBookingPayload.put("depositpaid", depositpaid);
        createBookingPayload.put("additionalneeds", additionalneeds);

        Map <String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout", checkout);

        createBookingPayload.put("bookingdates", bookingdates);

        return createBookingPayload;

    }






}
