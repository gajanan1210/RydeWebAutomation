# Ryde Web Automation README

## Overview

This repository contains web automation tests for testing the functionality of the ad banner on a web page. The tests are implemented using Selenium WebDriver with Java.

## Setup
To run the tests, you need to set up the following:

1. **Java & Eclipse:**

   Download and install Java and Eclipse IDE

2. **Clone or Download the Project from Git:**

Clone the project repository from Git or download the code as a zip file and extract it to your local system.


## Project Structure
The project follows a standard Maven directory structure:

The class files, responsible for testing the functionality of the ad banner is located at the following path:
RydeWebAutomation/src/test/java/Web/

## Test Scenario

### 1) AdBannerBehaviorTest

#### Description:
This class tests the behavior of the ad banner on a web page in different browsers, such as Chrome and Firefox.

#### Functionality:
- Test the ad banner's behavior in different browsers (e.g., Chrome, Firefox)

### 2) AdBannerProperties

#### Description:
This class verifies various properties of the ad banner, such as its visibility, position, and behavior when interacting with the page.

#### Functionality:
- Locate the ad banner using X and Y coordinates
- Verify that the ad banner is visible and properly loaded
- Ensure that the ad banner appears fixed at the bottom of the screen while scrolling the page
- Verify that the ad banner disappears when the 'Close' button is clicked

### 3) ClickAdLink

#### Description:
This class tests the functionality of clicking on the ad banner and ensuring that it redirects to the correct URL.

#### Functionality:
- Click on the ad banner and ensure it redirects to the correct URL

## Running Tests
To run the tests, follow these steps:

1. **Import the Project into Eclipse:**
   - Open Eclipse IDE and import the project you downloaded
    - In the IDE, navigate to "File" > "Import".
    - Choose "Existing Maven Projects" under the "Maven" category.
    - Click "Next" and then "Browse" to locate the root directory of the project.
    - Select the project folder and click "Finish" to import it as a Maven project into your IDE.
   
2. **Run the Tests:**
   
In Eclipse, navigate to the test files mentioned below:

   - `AdBannerBehaviorTest.java`
   - `AdBannerProperties.java`
   - `ClickAdLink.java`
  
   These files are located under the `RydeWebAutomation/src/test/java/Web/` directory, as specified in the project structure.
   
   - Right-click on each file and select "Run As" > "Java Application".
   
   - This will execute the tests, and you should see the test results in the console.



