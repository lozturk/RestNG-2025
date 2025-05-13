package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;
import static constants.ApiPaths.*;

public class PartialUpdateBookingApi extends BaseApi {

    public PartialUpdateBookingApi() {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
             .loggAllSpecificRequestDetail(LogDetail.BODY)
             .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    public Response partialUpdateBooking(Map<String, Object> partialUpdateBookingPayload, int bookingId,
                                  String username, String password) {
        return getPartialUpdateBookingApiResponse(partialUpdateBookingPayload, bookingId, username, password);
    }


    private Response getPartialUpdateBookingApiResponse(Object partialUpdateBookingPayload, int bookingId,
                                                        String username, String password) {
        super.setBasePath(PARTIAL_UPDATE_BOOKING.getApiPath());
        super.setRequestBody(partialUpdateBookingPayload);
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(PARTIAL_UPDATE_BOOKING.getHttpMethodType());
    }
}
