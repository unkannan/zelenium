
Nuvasive Login page Functionality

Steps for Execution: 
To execute test scripts please follow below steps: 

1) Install Java & maven and set their respective paths in system variables. 
2) Download the project 
3) Clean and compile project using 
mvn clean compile 
4) Assign any browser in the properties file

CurrencyConversionAutomation/src/test/resources/configuration.properties file 
   Ex: browser=chrome or firefox to run in respective browsers 
6) execute the command in command prompt 
mvn test 



Scope of Testing: 

In-Scope: 

1) Functional Testing: 
i. Manual and exploratory testing 
ii. Automation testing 

2) Non-Functional Testing: 
i. UI testing performing various actions and also to confirm that application is easy to use. 
ii. Cross-browser testing to verify that application works as intended on supported browsers. 

Out of Scope: 
1) Performance testing 
2) Security testing 
Test Strategy: 
This section lists down the strategy to ensure the quality of Nuvasive Login Page application via manual & automation testing. 
1) Manually explore application to understand basic functionalities. 
2) Initially identified the features in application. 
3) Designed the test scenarios for testing of various features in application. 
4) Identify automatable test scenarios and mark the test cases accordingly. 
5) Design test scripts for automation testing 
6) Execute both manual and automation tests against application in test. 
7) Analyse test results to identify defects in application. 



Automation tools used: 
List of all the software and tools required for developing and executing automation framework. 
1) Java (version 1.8) 
2) Selenium (version 3.141.59) 
3) TestNG (version 6.14.3) 
4) Maven (version 4.0) 
5) Log4j (version 1.2.17) 
6) Google Chrome (version 77.0.3865.90) 
7) Mozilla Firefox (version 69.0.1 (64-bit)) 
8) Internet Explorer 11 (version 11.0.9600.19326CO) 




Test Deliverables: 

1. Test Scenarios: 

Test Reports is at 
1.. NuVasiveLoginAutomation/test-output/emailable-report.html 
2. NuVasiveLoginAutomation/test-output/index.html 
3. Surefire-reports at NuVasiveLoginAutomation\target\surefire-reports 
4.  Logs available at NuVasiveLoginAutomation\logs\logging.log 


