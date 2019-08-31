# City List Design-and-Build Activity

In this activity, you will design and build a REST API based on the specification below. This specification is intentionally vague—this activity will force you to think about the design of the application and to ask good questions about the requirements.

## Requirements

* This application must keep track of city information.
* It must track the following data about cities:
    * Name
    * State
    * Population
    * Whether or not the city is a state capital
* The API must allow the user to do the following:
    * Add a city
        * URI: /city
        * Method: POST
        * Request Body: City
        * Response Body: City
    * Delete a city by name
        * URI: /city/{name}
        * Method: DELETE
        * Request Body: None
        * Response Body: None
    * Retrieve all the cities
        * URI: /city
        * Method: GET
        * Request Body: None
        * Response Body: City List
    * Retrieve one city by name
        * URI: /city/{name}
        * Method: GET
        * Request Body: None
        * Response Body: City
* Test this application using Postman.
* The Jackson mapper converts Lists to JSON automatically.
* The initial version of this application must store all data in memory. A later version must persist the data to file using one of the techniques shown in class.

Design and document a REST API that supports these requirements and then implement that web service using Spring Boot.

## Deliverables

1. OpenAPI 3.x documentaion of your REST API.
1. Pivotal Tracker project.
1. Spring-Boot-based web service that implements your API.
