Prerequisite - 

1. Firefox Version -  53.0.2
2. Java  Version -  jdk1.8.0_121
3. Apache Maven - apache-maven-3.3.92
4. Gecko Driver Settings : Download "geckodriver.exe" from https://github.com/mozilla/geckodriver/releases
						   Right click on my computer and select the "properties". 
                           Select the "Advanced system settings".
              			   Go to Advanced tab in system properties window and click on environment variables.
             			   Now under the system variables,select Path and click on Edit.
                           Add GeckoDriver path. Please check screenshot in project "bbc-radio\Setup\GeckoDriverSetting.png"
                           
5. Open command prompt and navigate to project location
6. Run maven command - mvn eclipse:clean eclipse:eclipse
7. Run maven command to last test application - mvn clean test
6. Run Test Class in eclipse -  bbc-radio\src\test\java\com\bbc\radio\functional\test\RunBBCRadioFunctionalTest.java
7. Feature File Details - 
   
     1. bbc-radio\src\test\resources\functional\radionavdrawers.feature 
     			-- Assigned ToDO task
     			-- Java implementation in class 											bbc-radio\src\test\java\com\bbc\radio\functional\test\BBCRadioStepDefs.java
     			-- I have Corrected categories("Arts, Culture & the Media", "Religion & Ethics") in Scenario (Scenario: Selecting categories displays categories links) because that are not available in live application
     			
     2. bbc-radio\src\test\resources\todo-radiostations.feature 
     			-- Written Scenarios for given assignment   
     			-- I have added Background in feature file which will run before Scenario                  

