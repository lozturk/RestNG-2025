package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.request.CreateBookingRequest;

import java.util.Map;

import static constants.ApiPaths.UPDATE_BOOKING;
/**
 * This class is responsible for updating booking details through the API.
 * It extends the BaseApi class to inherit common API functionalities.
 */
public class UpdateBookingApi extends BaseApi {

    // Initializes the UpdateBookingApi class with filtered logging details and JSON content type setup
    public UpdateBookingApi() {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
             .loggAllSpecificRequestDetail(LogDetail.BODY)
             .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    // Sends a request to update a booking using a payload provided as a Map, booking ID, and basic authentication
    public Response updateBooking(Map<String, Object> createBookingPayload, int bookingId,
                                  String username, String password) {
        return getCreateBookingApiResponse(createBookingPayload, bookingId, username, password);
    }

    // Sends a request to update a booking using a payload provided as a CreateBookingRequest object, booking ID, and basic authentication
    public Response updateBooking(CreateBookingRequest createBookingRequest, int bookingId,
                                  String username, String password) {
        return getCreateBookingApiResponse(createBookingRequest, bookingId, username, password);
    }

    // A private helper method that sets the base path, request body, path parameter, and basic authentication, then sends the API request
    private Response getCreateBookingApiResponse(Object createBookingPayload, int bookingId,
                                                 String username, String password) {
        super.setBasePath(UPDATE_BOOKING.getApiPath());
        super.setRequestBody(createBookingPayload);
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(UPDATE_BOOKING.getHttpMethodType());
    }
}