package apis;

import http.BaseApi;
import io.restassured.http.*;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static constants.ApiPaths.UPDATE_BOOKING;

@Slf4j
public class UpdateBookingApi extends BaseApi {



    public UpdateBookingApi(){
        super();
        super.loggAllRequestData().loggAllResponseData();
        super.setContentType(ContentType.JSON);
        super.setHeader("Accept", "application/json");
    }

    public Response updateBooking(Object updateBookingPayload, Integer bookingId, String username, String password) {
        super.setBasePath(UPDATE_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(UPDATE_BOOKING.getHttpMethodType());





}








}
