package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static constants.ApiPaths.*;

public class GetBookingApi extends BaseApi {

    public GetBookingApi() {
        super();
        super.loggAllRequestData().loggAllResponseData();
    }

    public GetBookingApi(LogDetail logDetail) {
        super();
        super.loggAllSpecificRequestDetail(LogDetail.METHOD)
                .loggAllSpecificRequestDetail(LogDetail.URI)
             .loggAllSpecificResponseDetail(LogDetail.STATUS);
    }

    public Response getAllBookingIds() {
        super.setBasePath(GET_BOOKING_IDS.getApiPath());
        return super.sendRequest(GET_BOOKING_IDS.getHttpMethodType());
    }

    public Response getBookingById(int bookingId) {
        super.setBasePath(GET_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        return super.sendRequest(GET_BOOKING.getHttpMethodType());
    }
}
