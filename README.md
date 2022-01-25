# bidba_testing
In this project I have automated a smoke and regression tests for https://bidba.herokuapp.com/. While automating smoke and regression tests, I have used Page Object Model for easier understanding of code.    

# Techonologies 

I have used following technologies in this project:
- Java 1.8
- InteliJ
- Maven
- Required dependencies


# Run the Test

- Install Java 1.8
- Install InteliJ
- Install Maven
- Install Allure Framework
- Open InteliJ 
- Chcek if the Google Chrome version is same as in the project
- Clone this repository using InteliJ console
- Open project
- Open pom.xml file
- Check if the dependencies are up to date
- Install all dependencies
- In "Select Run/Debug Configuration" select accountCreationAndCheckoutProcess
- Click Run or Debug
- Open cmd and run allure serve *location_of_allure-results*

# Run the Test from Command Line

- Navigate to the project folder
- Enter "mvn test -DsuiteXmlFile="smoke.xml"" if you want to run smoke test
- Enter "mvn test -DsuiteXmlFile="regression.xml"" if you want to run regression tests
