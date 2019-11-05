# README #

This README would normally document whatever steps are necessary to get the application up and running.

### What is this repository for? ###

This repository contains code for Assurity API automation task.


### How do I get set up? ###

This is a maven project and contains all the dependencies in pom.xml file present at root folder. We need to ensure that we resolve all the dependencies before executing the test case.
This can be done following one of the below steps:-
1. Go to the project path containing pom.xml on a terminal and run this command - mvn clean install -U -DskipTests.Please ensure you have maven installed on your machine.
2. Open this maven project in an IDE like IDEA intellij or eclipse which will resolve the maven dependencies.

Once we are done with above step successfully ,we can run our test case by one of the following ways mentioned in below section.

### How to run tests ###

1. Open this project in an IDE. Right click on suite.xml file present under src->test->resources->suiteXMLs. And select 'Run suite.xml'.Please ensure you have testNG plugin installed in your IDE.
2. You can also run the test case by right clicking directly on the test case and select 'Run testcasename'.
3. Go to the project path on your terminal and run command :- mvn clean install -DSuiteXmlFile=suite.xml


* Database configuration:-
Not Applicable

* Deployment instructions:-
NA
### Project Related Info ###

* src->main->resources :-

1. apiEndPoints.properties:- All api endpoints which are being used in testing are listed here.
2. env.properties:- All environment configuration related information is present here. For now we have api base URL listed here.
3. log4j.properties :- logging configuration is present here.

 ### Contribution ### 
* Writing tests:-
Please sync with repo owners/developers and discuss cases which are yet to be automated.
Pull request need to be raised and code review comments need to be incorporated later.
* Other guidelines:-
N/A

### Who do I talk to? ###

* Repo owner or admin:-
ritesh.vashisth@yahoo.com
