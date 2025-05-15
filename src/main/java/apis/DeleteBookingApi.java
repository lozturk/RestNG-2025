package apis;

import http.BaseApi;
import io.restassured.response.Response;

import static constants.ApiPaths.DELETE_BOOKING;

/**
 * The DeleteBookingApi class provides methods to interact with the Delete Booking API.
 * It allows sending requests to delete bookings by ID with basic authentication
 * and handles the setup of request and response logging.
 */
public class DeleteBookingApi extends BaseApi {

    // Initializes the DeleteBookingApi class with logging for request and response data
    public DeleteBookingApi() {
        super();
        super.loggAllRequestData().loggAllResponseData();
    }

    // Sends a request to delete a booking by ID with basic authentication
    public Response deleteBookingById(int bookingId, String username, String password) {
        super.setBasePath(DELETE_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(DELETE_BOOKING.getHttpMethodType());
    }
}