NOTE:
----------------------------------------------------------------------------------------------------------------------------

1. Total 12 scenarios are included, this shows the re usability of the framework with little modification
2. The last [12th] is expected to fail, This is show how the report looks like when a test case fails
3. The Final build status will be failure due to the test case which is expected to fail
4. The same test pack can be run from jenkins for better looking reports with graphs and tables


ENVIRONMENT:
----------------------------------------------------------------------------------------------------------------------------
This test pack is developed in windows environment and chromedriver is used, it is expected to run in the same environment if there are no code changes in the exiting project.


FRAMEWORK:
----------------------------------------------------------------------------------------------------------------------------

I have used the BDD cucumber Framework for this project. The BDD Cucumber framework is used in test automation to reduce the gap between the business people and the automation testers where the tests are written in GIVEN,WHEN,THEN,AND format and can be understood by anyone who can read and understand plain english.

All the 12 test scenarios and there steps with test data can be seen in the GitHubTests.feature [/src/test/resources/FeatureFiles/GitHubTests.feature]


HOW TO RUN:
----------------------------------------------------------------------------------------------------------------------------

Note: I am expecting Java and Maven setup is already done in the machine where the tests are going to be executed

1. Download the code
2. open command prompt and navigate to the root folder [GitHub]
3. Type mvn clean test [if Java and Maven Set up is correct then it will start test execution]
4. Once the test execution is completed (After around 3 mins), you will be able to see a similar message like the below one in your console

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:53 min
[INFO] Finished at: 2017-08-11T00:49:07+05:30
[INFO] Final Memory: 19M/209M
[INFO] ------------------------------------------------------------------------


HOW TO VIEW THE REPORT:
----------------------------------------------------------------------------------------------------------------------------

Navigate to the root folder [GitHub] after the test execution.
Then Navigate to target\HTML-Report folder and open the index.html file

Each test scenario can be expanded if it is already not expanded (It changes depends on the browser you open the report) to view the detailed steps and the test data used, also to identify which is the exact step where the test got failed if there is any failure.

Note: The 12th scenario will be in red color as it is expected to fail, and a screenshot will be attached at the end of it after the error logs. the error logs will tell you where exactly the failre happend. 


OTHER CUSTOM REPORTS
----------------------------------------------------------------------------------------------------------------------------

Other Custome reports in HTML format can be easily created by getting the scenario and name and status from after section of the stepdefinition class. As the time is limited i havent included the same here.


QUESTIONS & CLARIFICATION
----------------------------------------------------------------------------------------------------------------------------

Write to akhilzo2.6@gmail.com or akhil.m52@wipro.com for any clarifiactions required.
Mob: 9902362045