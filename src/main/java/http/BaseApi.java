package http;

import config.PropertyUtil;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static config.PropertyUtil.getConfig;

/**
 * BaseApi class provides a foundation for creating API requests with RestAssured.
 * It includes methods for setting request parameters, logging, and sending requests.
 */
public abstract class BaseApi {

    // Holds the request specification for configuring and sending API requests
    private final RequestSpecification requestSpecification;

    // Initializes the BaseApi class with default configurations and Allure reporting
    public BaseApi() {

        this.requestSpecification = RestAssured.given()
                                               .baseUri(PropertyUtil.getConfig().baseUrl())
                                               .filter(new AllureRestAssured());
    }

    // Sets the request body for the API request
    protected void setRequestBody(Object object) {
        this.requestSpecification.body(object);
    }

    // Sets the base path for the API request
    protected void setBasePath(String basePath) {
        this.requestSpecification.basePath(basePath);
    }

    // Sets the content type for the API request
    protected void setContentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
    }

    // Sets basic authentication credentials for the API request
    protected void setBasicAuth(String username, String password) {
        this.requestSpecification.auth().preemptive().basic(username, password);
    }

    // Sets a path parameter for the API request
    protected void setPathParam(String paramName, Object paramValue) {
        this.requestSpecification.pathParam(paramName, paramValue);
    }

    // Sets a header for the API request
    protected void setHeader(String headerName, String headerValue) {
        this.requestSpecification.header(headerName, headerValue);
    }

    // Enables logging of all request data
    public BaseApi loggAllRequestData() {
        this.requestSpecification.filter(new RequestLoggingFilter());
        return this;
    }

    // Enables logging of specific request details
    public BaseApi loggAllSpecificRequestDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new RequestLoggingFilter(logDetail));
        return this;
    }

    // Enables logging of all response data
    public BaseApi loggAllResponseData() {
        this.requestSpecification.filter(new ResponseLoggingFilter());
        return this;
    }

    // Enables logging of specific response details
    public BaseApi loggAllSpecificResponseDetail(LogDetail logDetail) {
        this.requestSpecification.filter(new ResponseLoggingFilter(logDetail));
        return this;
    }

    // Sends the API request using the specified HTTP method
    public Response sendRequest(Method methodType) {
        final RequestSpecification when = this.requestSpecification.when();
        return switch (methodType) {
            case GET -> when.get();
            case POST -> when.post();
            case PUT -> when.put();
            case DELETE -> when.delete();
            case PATCH -> when.patch();
            default -> throw new IllegalArgumentException("Invalid HTTP method type: " + methodType);
        };
    }
}