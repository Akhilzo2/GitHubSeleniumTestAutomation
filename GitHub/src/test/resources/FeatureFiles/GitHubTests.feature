Feature: Github login functionality
	
Scenario: 1. Logging in to GitHub with valid username and valid password.
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName |Password        |
|Akhilzo2 |githubpassword@1|
Then The login should be successfull


Scenario: 2. Logging in to GitHub with valid username and invalid password.
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName  |Password        |
|Akhilzo23 |githubpassword@1|
Then The login should be unsuccessfull


Scenario: 3. Logging in to GitHub with invalid username and password.
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName |Password        |
|Akhilzo2 |githubpassword@2|
Then The login should be unsuccessfull


Scenario: 4. Logging in to GitHub with valid username and valid password in CAPS.
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName |Password        |
|Akhilzo2 |GITHUBPASSWORD@2|
Then The login should be unsuccessfull


Scenario: 5. Logging in to GitHub with valid username in CAPS and valid password.
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName |Password        |
|AKHILZO2 |githubpassword@1|
Then The login should be successfull


Scenario: 6. Logging in to GitHub without entering any username and password
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName|Password|
|        |        |
Then The login should be unsuccessfull


Scenario: 7. Logging in to GitHub with valid username in password field and the password in username field
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName        |Password|
|githubpassword@1|Akhilzo2|
Then The login should be unsuccessfull


Scenario: 8. Logging in to GitHub with valid username in both username and password fields
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName|Password|
|Akhilzo2|Akhilzo2|
Then The login should be unsuccessfull


Scenario: 9. Logging in to GitHub with a password in both username and password fields
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName        |Password        |
|githubpassword@1|githubpassword@1|
Then The login should be unsuccessfull

Scenario: 10. Logging in to GitHub by only entering a valid username
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName|Password|
|Akhilzo2|        |
Then The login should be unsuccessfull

Scenario: 11. Logging in to GitHub by only entering a password
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName|Password        |
|        |githubpassword@1|
Then The login should be unsuccessfull
	
	
Scenario: 12. Sample scenario with screenshot of the failed screen [Expected to fail]
Given The GitHub Website is up and running
When The user logs into GitHub with the following credentials
|UserName    |Password        |
|InvalidUser |githubpassword@4|
Then The login should be successfull








