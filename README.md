Coverage: %
# HWA-Project

This project is a basic web application that simulates an inventory system that holds the details of rowing clubs in the UK and the different kinds of boats these rowing clubs have (ranging from small boats such as singles (1x) and doubles (2x)/pairs (2-) to bigger boats such as coxless fours (4-) and eights (8+)). This also includes the different companies that make these boats, such as Empacher, Filippi Boats and Hudson Boat Works.

## Getting Started
This project includes a far .jar file which will allow you to start the program from the terminal. I included a method in the application that outputs a message saying "Spring is working" (for my convenience when testing) as well as the timestamp for when you start running the program. From there, you should be able to open the index.html page.

## Prerequisites
The following software is required in order for the project to run:
* Eclipse IDE (Download from https://www.eclipse.org/downloads/) for Java

* MySQL 8.0 (Download from https://www.mysql.com/downloads/) for SQL

* Visual Studio Code (Download from https://code.visualstudio.com/download) for HTML, CSS and JavaScript

* Postman (Download from https://www.postman.com/downloads/) for testing fetch requests from API

* SpringBoot (can be downloaded through Eclipse in the marketplace) for setting up the web application and to test/communicate with the backend

* Selenium (downloaded through Google Chrome) for testing the front end

## Installing


## Running the program


## Unit Tests
Unit tests allow each .java file (e.g. boat.java) to test each method without relying on the other classes to see if they work on their own before being deployed. For test coverage, it should only cover the methods within that class (i.e. coverage in all other classes besides boat.java should be 0%). Here is an example:

## Integration Tests
Unlike the unit tests, integration tests test the class as well as any other classes that it may rely on to run. This helps the testing for when the code is actually running to see if it works correctly. Below is an example of an integration test in the project:

## Coding style

Before each method, add a comment using // and briefly describe what the method does, specify what the parameter(s) and return type(s) is (if applicable). This is to ensure that for shared projects, the other person can understand what each method does and makes debugging easier.

```
// Comment saying what the method does
// @param if the method has any parameters
// @return if the method has a return type (not needed if return
// type is void)
public <return type> <method name>() {
    <code goes here>
}
```

## Built With
Maven - Dependecy Management

## Versioning
We use SemVer for versioning

## Author
* **Gabriel Jose** - *Initial work* - [gabejose](https://github.com/gabejose)

## Acknowledgments
* Rowing is a hobby, such that it takes up at least 50% of my life. As much as it pushes me to have annual meetings with death, I still enjoy the sport very much
* YouTube for the funny and interesting rowing content