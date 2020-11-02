# gurukula-automation


Web automation framework to test **Gurukula** application, implemented using Java, Selenium/Webdriver, TestNG & Maven.
This project is implemented in Page Object Model (POM) which helps in making the code more readable, maintainable, and reusable.


## Prerequisite: ##
List of all the software and tools required for developing and executing automation framework.
1) Java (version 1.8)
2) Selenium (version 3.141.59)
3) TestNG (version 6.14.3)
4) Maven (version 3.5.3)
5) Log4j (version 1.2.17)
6) Google Chrome (version 74.0.3729.131)
7) Mozilla Firefox (version 66.0.3 (64-bit))
8) Respective Browser drivers
9) Intellij or Eclipse

## Automation Scripts Execution: ##
To execute test scripts please follow below steps:
1) Install Java & maven and set their respective paths in system variables.
2) Clone project 
   > git clone https://github.com/anujkumar21/gurukula-automation.git
3) Clean and compile project using
   > mvn clean compile
4) To execute automation scripts, execute any of the following commands from command prompt:
    - To execute all automation scripts (by default it will run on firefox)
      > mvn test
      
    - To execute on particular browser, execute below command with parameter as 'firefox' or 'chrome'
      > mvn test -Dbrowser=_browser-name_
      
      for e.g.: `mvn test -Dbrowser=firefox`
      
    - To execute test scripts for particular functionality execute below command with parameter as [branch, login, misc, password, register, resetPassword, searchBranch, searchStaff, sessions, settings, staff, welcome]
      > mvn test -Dgroups=_group-name_
      
      for e.g.: `mvn test -Dgroups=branch`      
    - To execute test scripts of any particular group on any particular browser
      > mvn test -Dbrowser=_browser-name_ -Dgroups=_group-name_
      
      for e.g.: `mvn test -Dbrowser=firefox -Dgroups=branch`


## Automation Coverage: ##
Below table & pie chart contains the total automation coverage of Gurukula application.
Out of total 128 manual test cases, 93% test cases are automated. 

  ![Automation Coverage](https://github.com/anujkumar21/gurukula-automation/blob/master/readmedata/automation_coverage.PNG)
  
  
## Automation Execution Status: ##
Below table & pie chart contains execution status of Gurukula automation.

![Automation Execution Status](https://github.com/anujkumar21/gurukula-automation/blob/master/readmedata/automation_execution_status.PNG)

**Notes:**
1) All 17 failures are product defects and are logged in the **'Defects'** worksheet in **"Gurukula - Consolidated Report.xlsx".**
2) Framework has capability to **capture screenshot** for every failed test scripts. All the screenshots are stored at **". \target\screenshots".**
