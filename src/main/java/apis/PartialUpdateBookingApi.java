package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;
import static constants.ApiPaths.*;

/**
 * The PartialUpdateBookingApi class provides methods to interact with the Partial Update Booking API.
 * It allows sending requests to partially update booking details using a payload, booking ID, and basic authentication,
 * and handles the setup of request details such as logging and content type.
 */
public class PartialUpdateBookingApi extends BaseApi {

    // Initializes the PartialUpdateBookingApi class with filtered logging details and JSON content type setup
    public PartialUpdateBookingApi() {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
             .loggAllSpecificRequestDetail(LogDetail.BODY)
             .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    // Sends a request to partially update a booking using a payload, booking ID, and basic authentication
    public Response partialUpdateBooking(Map<String, Object> partialUpdateBookingPayload, int bookingId,
                                         String username, String password) {
        return getPartialUpdateBookingApiResponse(partialUpdateBookingPayload, bookingId, username, password);
    }

    // A private helper method that sets the base path, request body, path parameter, and basic authentication, then sends the API request
    private Response getPartialUpdateBookingApiResponse(Object partialUpdateBookingPayload, int bookingId,
                                                        String username, String password) {
        super.setBasePath(PARTIAL_UPDATE_BOOKING.getApiPath());
        super.setRequestBody(partialUpdateBookingPayload);
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(PARTIAL_UPDATE_BOOKING.getHttpMethodType());
    }
}