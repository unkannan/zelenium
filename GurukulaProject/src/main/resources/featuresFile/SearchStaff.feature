@SmokeTestsfsfs
Feature: Search Staff 
         
	Scenario: Pre-requisites data - Creating multiple Staffes to search with the Staff Name       
		Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    Then Navigate to Account menu > Staffs and create four different Staffs  of <Name> and <Branch>  
    |Name	|Branch	|
    |oneSTAFFSELENIUM		|oneBRANCHSELENIUM|
    |twoSTAFFSELENIUM		|twoBRANCHSELENIUM|	
    |THREESTAFFSELENIUM	|threeBRANCHSELENIUM|
    When user search for the Staff using Staff name "oneStaffSELENIUM"
    Then Staff details should be shown in the Staff list for "oneStaffSELENIUM"
    
  	Scenario: Partial Staff name search - Staff details list should not be shown when user tries to search with partial Staff name   
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    When user search for the Staff using Staff name "SELENIUM"
    Then Staff details should NOT be shown for "SELENIUM" search criteria as it is partial name 
    
  Scenario: Searching with Cases sensitive - Staff details should be shown when user search with small case or upper cases as it is not a case sensitive   
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    When user search for the Staff using Staff name with <lowercasesANDuppercases> then Staff details should be shown
    |lowercasesANDuppercases|
    |oneStaffselenium|
    |ONEStaffSELENIUM|
    |ONEStaffSELEnium|
    
   Scenario: Search with spaces between words - Staff details should NOT be shown when user search with Staff NAMES BY GIVING SPACES BETWEEN WORDS 
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
     When user search for the Staff using Staff name with <workwithspaces> then Staff details should NOT be shown
     |workwithspaces|
    |one Staffselenium|
    |ONEStaffS ELENIUM|
    |ONEbra nchSELEnium|
    
    Scenario: Staff details should be shown when user search with Staff ID  
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    When user search for the Staff using Staff ID with "1" 
    Then Staff details should be shown with "1"
    
	Scenario: Search with invalid chars - Staff details should NOT be shown when user search with criteria of invalid Staff code, invalid Staff name, partial Staff name, partial code 
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    When user search for staff with invalid characters <invalidcharacters> and see that search page will not shown any results
     |invalidcharacters| 
     |@@@&&|
    |!!!|
    |52432424"£$£"$fsaf|
    
     Scenario: Blank search functional check - Staff details should be shown when search is clicked with blank criteria    
    Given Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login
    When user search for the Staff using "invalid Staff" name where results are not shown
    And user clears the search criteria and clicks the search with blank in search text field
    Then all Staff details should be shown in the Staff list  
		 