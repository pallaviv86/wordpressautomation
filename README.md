# WordPress Application Testing

This is a demo project to demonstrate testing of WordPress Application using Selenium WebDriver with Java, TestNG and Maven.

## Installation/Setup

#### Prerequisite

1:JAVA 8 SDK and JAVA_HOME env variable should be set in your system [JAVA](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/).  
2:MAVEN and M2_HOME env variable set in your system [MAVEN](https://maven.apache.org/install.html)

## Execution

This project is built using maven build tool. Project can be check out into your system and run the test using maven command


```
mvn clean install or
mvn test or
mvn -Dtestng.dtd.http=true -DENV=dev test
  
testng.dtd.http - Environment variable to change the default behaviour of TESTNG. By default TestNG disables loading DTD from unsecure URL's.
 
```

## Reporting
Reports will be available inside the folder Project-Root-folder/target/test-output

-> index.html 
-> Project-Root-folder/target/test-output/WordPress/WordPress Application Test.html 
-> emailable-report.html

## File locations
-> Log file is present in Project-Root-folder/logs/WordPressTest.log

##Explanation
1: I have used WordPress application(https://wordpress.com/) to demonstrate the Testing.
2: Have used Selenium WebDriver with Java, Maven and TestNG in the framework. 
3: Have used POM (Page Object Model)design pattern, Log4j for logging and TestNG reports. 
4: Have all page classes inside org.sample.wordpress.pages package, all testcases inside org.sample.wordpress.tests package and utility classes inside org.sample.wordpress.utilities package
5: All the project related files are inside Project-Root-folder/src/test/resources folder 
6. Logs are generated in Project-Root-folder/logs/WordPressTest.log and TestNG reports are generated inside Project-Root-folder/target/test-output.
