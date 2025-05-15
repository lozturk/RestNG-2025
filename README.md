# RestNG-2025

## Overview
This project demonstrates API testing using RestAssured in Java. It includes test cases for validating API responses, headers, and JSON payloads.
It is designed to be easily extendable and maintainable, making it suitable for both beginners and experienced developers.

## Project Structure

- **`src/main/java`**: Contains the main application code.
  - **`apis`**: Contains API-related classes for handling requests and responses.
    - `CreateBookingApi.java`: Contains methods specifically for creating new bookings, including request payload construction.
    - `DeleteBookingApi.java`: Contains methods specifically for deleting bookings by ID, including authentication setup.
    - `GetBookingApi.java`: Contains methods specifically for retrieving booking details by ID, including request construction.
    - `UpdateBookingApi.java`: Contains methods specifically for updating existing bookings, including request payload construction.
    - `PartialUpdateBookingApi.java`: Contains methods specifically for partially updating bookings, including request payload construction.
  - **`http`**: Contains base api class for configuring and sending HTTP requests, including logging and authentication.
    - `BaseApi.java`: Contains common methods and configurations for API requests, such as base URL and authentication.
- **`src/test/java`**: Contains the test cases for API testing.
  - `BaseTest.java`: Sets up base configurations and provides data providers for test cases.
  - `CRUDTests.java`: Implements create, retrieve, update, and delete (CRUD) operations and validates API responses.
  - `CreateBookingApiTests.java`: Tests for creating new bookings and validating HTTP status codes.
  - `UpdateBookingApiTests.java`: Tests for updating existing bookings and validating HTTP status codes.
  - `PartialUpdateBookingApiTests.java`: Tests for partially updating bookings and validating responses.
  - `GetBookingApiTests.java`: Tests for retrieving booking details by ID and validating HTTP status codes.
  - `DeleteBookingApiTests.java`: Tests for deleting bookings and validating HTTP status codes.


## Features
- Validate API responses
- Validate headers
- Validate JSON payloads

## Dependencies
The project uses the following dependencies:
- [Allure TestNG](https://github.com/allure-framework/allure-java) for reporting
- [Allure Rest-Assured](https://github.com/allure-framework/allure-java) for integrating RestAssured with Allure
- [TestNG](https://testng.org/) for test execution
- [JSON Path](https://github.com/json-path/JsonPath) for JSON parsing
- [Lombok](https://projectlombok.org/) for reducing boilerplate code
- [RestAssured](https://rest-assured.io/) for API testing
- [RestAssured JSON Schema Validator](https://rest-assured.io/) for schema validation
- [JavaFaker](https://github.com/DiUS/java-faker) for generating fake data
- [Awaitility](https://github.com/awaitility/awaitility) for handling asynchronous operations
- [Owner](https://github.com/lviggiano/owner) for managing configuration properties
- [SLF4J API](http://www.slf4j.org/) for logging

## Installation
Follow these steps to set up and run the project locally:
1. Clone the repository: `git clone https://github.com/lozturk/RestNG-java-2025.git`
2. Navigate to the project directory: `cd RestNG-java-2025`
3. Build the project using Maven

## Contributing
Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request.

## Contact
For questions or feedback, please open an issue in this repository.
