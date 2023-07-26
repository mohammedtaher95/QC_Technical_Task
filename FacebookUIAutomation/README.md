# UI JAVA Test Automation Framework
- This project is an open-source Test automation Framework that allows you to perform multiple actions to test a web application's functionality, behaviour, 
which provides easy to use syntax, and easy to setup environment according to the needed requirements for testing
- This project is based on Selenium WebDriver, TestNG Runner, and Maven


## Features
- Support Running Testing on Following Browsers locally: Chrome, Firefox, & Edge either Normal or Headless
- Support Cross-Browsing Mode
- Support Running on Selenium Grid via Docker 
- Support Data Driven via JSON, Faker Data
- Generate Allure Report automatically after Test Execution with screenshots
- Changing Framework settings via Properties files

## Tech Stack
- Java
- Maven
- TestNG
- Selenium WebDriver
- Allure
- Docker for Setting up Selenium Grid
- Jenkins

## How to use:

### Step 1: Setup Project
- Run this project using Eclipse, IntelliJ or your favourite IDE
- Click on Run dropdown menu and then select Edit Configuration, then Add `tools.listeners.TestNGListener` to TestNG Configuration
- Configure Properties Files `src\main\resources\properties` to setup environment type, running test in normal, headless mode, adding Base URL, configure opening Allure Report after finishing tests

  
### Step 2: Running Tests
- Run your TestClass.java as a TestNG Test Class.
- The execution report will open automatically in your default web browser after the test run is completed

