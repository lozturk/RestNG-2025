package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static constants.ApiPaths.*;

/**
 * The GetBookingApi class provides methods to interact with the Get Booking API.
 * It allows sending requests to retrieve booking details by ID or fetch all booking IDs,
 * and handles the setup of request and response logging.
 */
public class GetBookingApi extends BaseApi {

    // Initializes the GetBookingApi class with logging for all request and response data
    public GetBookingApi() {
        super();
        super.loggAllRequestData().loggAllResponseData();
    }

    // Initializes the GetBookingApi class with specific logging details for method, URI, and status
    public GetBookingApi(LogDetail logDetail) {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
             .loggAllSpecificRequestDetail(LogDetail.URI)
             .loggAllSpecificResponseDetail(LogDetail.STATUS);
    }

    // Sends a request to retrieve all booking IDs
    public Response getAllBookingIds() {
        super.setBasePath(GET_BOOKING_IDS.getApiPath());
        return super.sendRequest(GET_BOOKING_IDS.getHttpMethodType());
    }

    // Sends a request to retrieve booking details by ID
    public Response getBookingById(int bookingId) {
        super.setBasePath(GET_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        return super.sendRequest(GET_BOOKING.getHttpMethodType());
    }
}