package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.request.CreateBookingRequest;

import java.util.Map;

import static constants.ApiPaths.CREATE_BOOKING;

/**
 * The CreateBookingApi class provides methods to interact with the Create Booking API.
 * It allows sending requests to create new bookings using different payload formats
 * and handles the setup of request details such as logging and content type.
 */
public class CreateBookingApi extends BaseApi {

    // Initializes the CreateBookingApi class with filtered logging details and JSON content type setup
    public CreateBookingApi() {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
             .loggAllSpecificRequestDetail(LogDetail.BODY)
             .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    // Sends a request to create a new booking using a payload provided as a Map
    public Response createNewBooking(Map<String, Object> createBookingPayload) {
        return getCreateBookingApiResponse(createBookingPayload);
    }

    // Sends a request to create a new booking using a payload provided as a CreateBookingRequest object
    public Response createNewBooking(CreateBookingRequest createBookingRequest) {
        return getCreateBookingApiResponse(createBookingRequest);
    }

    // A private helper method that sets the base path and request body, then sends the API request
    private Response getCreateBookingApiResponse(Object createBookingPayload) {
        super.setBasePath(CREATE_BOOKING.getApiPath());
        super.setRequestBody(createBookingPayload);
        return super.sendRequest(CREATE_BOOKING.getHttpMethodType());
    }
}