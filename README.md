# Ryde Web Automation README

## Overview

This repository contains web automation tests for testing the functionality of the ad banner on a web page. The tests are implemented using Selenium WebDriver with Java.

## Project Structure
The project follows a standard Maven directory structure:

The class files, responsible for testing the functionality of the ad banner is located at the following path:
RydeWebAutomation/src/test/java/Web/

## Test Classes

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
