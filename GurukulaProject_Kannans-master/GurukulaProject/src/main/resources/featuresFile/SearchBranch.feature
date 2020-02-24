@SearchBranch
Feature: Search Branch 
         
		 Scenario: Pre-requisites to create Branches for searching       
		Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    Then Navigate to Account menu > Branches and create four different Branches  of <Name> and <Code>  
    |Name	|Code	|
    |oneBRANCHSELENIUM		|77|
    |twoBRANCHSELENIUM		|888|	
    |threeBRANCHSELENIUM	|9999|
    When user search for the branch using branch name "oneBRANCHSELENIUM"
    Then branch details should be shown in the branch list for "oneBRANCHSELENIUM"
   
	Scenario: Partial branch name search - Branch details list should be shown when user tries to search with partial branch name   
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for the branch using branch name "SELENIUM"
    Then branch details should NOT be shown for "SELENIUM" search criteria as it is partinal name 

  Scenario: Searching with Cases sensitive - Branch details should be shown when user search with small case or upper cases as it is not a case sensitive   
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for the branch using branch name with <lowercasesANDuppercases> then branch details should be shown
    |lowercasesANDuppercases|
    |onebranchselenium|
    |ONEBRANCHSELENIUM|
    |ONEbranchSELEnium|
    
    
     Scenario: Searching with Branch Code - Branch details should be shown when user search with BRANCH CODE   
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for the branch using branch name with "77" 
    Then branch details should be shown for code "77" 

Scenario: Search with spaces between words - Branch details should NOT be shown when user search with BRANCH NAMES BY GIVING SPACES BETWEEN WORDS  
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
     When user search for the branch using branch name with <workwithspaces> then branch details should NOT be shown
     |workwithspaces|
    |one branchselenium|
    |ONEBRANCHS ELENIUM|
    |ONEbra nchSELEnium|

Scenario: Branch details should be shown when user search with BRANCH ID  
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for the branch using branch ID with "2" 
    Then branch details should be shown with "2"

Scenario: Search with invalid chars - Branch details should NOT be shown when user search with criteria of invalid branch code, invalid branch name, partial branch name, partial code 
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for <invalidcharacters> criteria and seen that search page will not shown any results
     |invalidcharacters| 
     |@@@&&|
    |!!!|
    |52432424"£$£"$fsaf|
		 
    
   Scenario: Blank search functional check - Branch details should be shown when search is clicked with blank criteria    
    Given Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login
    When user search for the branch using "invalid BRANCH" name where results are not shown
    And user search by removing the critiera and clicks the search with blank in search text field
    Then all branch details should be shown in the branch list  
    