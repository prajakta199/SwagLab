Feature: Login Screen feature
  
  Scenario: Elements displayed on login page
  
   Given user is on LoginScreen
	When user wants to view elements
	Then User Name is displayed
	And Password is displayed
	And Login button is displayed
	And Logo is displayed
 
	
  Scenario: Enter space in username fields credentials
     Given user is on LoginScreen
	When user enters username as " "
	And user enters password as "123"
	And clicks on login button
	Then Username error message is displayed
	And Products is not displayed
	
	Scenario: Enter space in pswd fields credentials
   Given user is on LoginScreen
	When user enters username as "abc"
	And user enters password as " "
	And clicks on login button
	Then password error message is displayed
	And Products is not displayed
	
		
  Scenario: Login with invalid credentials
   Given user is on LoginScreen
	When user enters username as "abc"
	And user enters password as "123"
	And clicks on login button
	Then error message is displayed
	And Products is not displayed
	
	Scenario: Elements displayed after login
   Given user has logged in with username and password as "standard_user" and "secret_sauce"
	When user is present on Home page
	Then Products is displayed
#	

   
    