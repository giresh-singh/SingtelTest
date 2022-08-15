# Singtel Automation Framework - Selenium & Java # 
Purpose of this README is to provide overview of framework, how to get framework from github, environment required, how to execute scenarios, view report and brief about framework architecture.
### Overview: ###
Framework is developed by using Selenium-Cucumber-java.
* WebDriverManager is used which carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.
* Cucumber is used to supports behavior-driven development. Cucumber BDD approach is its ordinary language parser called Gherkin.
* Courgette is used for parallel execution and cucumber report generation.
* Dependency injection for test data context.

<b><u>Repository URL:</b></u><br>https://github.com/giresh-singh/SingtelTest </br>
Click on Code button and choose option to download framework

<b><u>Pre-requisite (IDE and Test Bed):</u></b> 
* IntelliJ IDEA 2021.2.1 (Community Edition)
* JDK 1.8 
* Chrome browser

<b><u>Execute Test:</u></b></br>
    <h6>1. Using TestRunner:</h6> TestRunner.java file is available on below path - <i>src/test/java/com/singtel/automation/test/testcases/cucumber/TestRunner.java</i><br> Mouse right click and choose option Run TestRunner</br>
    <h6>2. Using command-line:</h6> 
    Open Intellij IDE terminal (Alt + F12). Execute below command:
    <br><b>mvn clean test</b>

<b><u>Check report</u></b><br>
    <h6>Latest Report:</h6> .\singtel\testreport\cucumber\latest\courgette-report<br>
    <h6>Report History:</h6> .\singtel\testreport\cucumber\history\courgette-report<br>

<b><u>Test Scenarios</u></b><br>
    There are six scenarios created in feature file and their steps are defined in step definition file.
    <h6>Feature File -</h6> .\singtel\src\test\resources\features\HomePage.feature <br>
    <h6>Step Definition File -</h6> .\singtel\src\test\java\com\singtel\automation\test\stepdef\ToDoMVCSteps.java <br>
    <h6>Scenario Outlines -</h6> 
        <table>
            <tr>
                <th>Scenario</th>
                <th>Objective</th>
              </tr>
            <tr><td> Add an item in ToDo list.</td><td>User is able to add an item in ToDo list.</td></tr>
            <tr><td> Mark an added item in ToDo list as 'Complete'.</td><td>User is able to mark an item as 'complete' in ToDo list.</td></tr>
            <tr><td> Mark a completed item in ToDo list as 'Active'.</td><td>User is able to mark a complete item as 'Active' by clicking again in ToDo list.</td></tr>
            <tr><td> Delete an item from ToDo list.</td><td>User is able to delete an item from ToDo list.</td></tr>
            <tr><td> Add multiple items in ToDo List.</td><td>User is able to add multiple items in ToDo list.</td></tr>
            <tr><td> Apply 'Active'/'Completed' filter and verify count in ToDo list.</td><td>User is able to apply 'Active'/'Completed' filters and match count for same in ToDo list.</td></tr>
        </table>

<b><u>Framework Architecture</u></b>
    <ul id="myUL">
    <li><span class="caret">src</span>
    <ul class="nested">
      <li><span class="caret">test</span>
        <ul class="nested">
          <li>java</li>
                <ul class="nested">
                    <li><span class="caret">framework</li>
                         <ul class="nested">
                            <li><span class="caret"><strong>engine</strong> - Intialize webdriver and related selenium operations</span></li>
                            <li><span class="caret"><strong>exception</strong> - Exception handling</span></li>
                            <li><span class="caret"><strong>log</strong> - Execution log</span></li>
                            <li><span class="caret"><strong>reader</strong> - Read properties file</span></li>
                            <li><span class="caret"><strong>report</strong> - Report generation/management</span></li>
                            <li><span class="caret"><strong>utils</strong> - Generic utilities</span></li>
                         </ul>
                    <li><span class="caret">test</span></li>
                     <ul class="nested">
                        <li><span class="caret"><strong>businessfunctions</strong> - UI workflow functions</span></li>
                        <li><span class="caret"><strong>constant</strong> - Data constant</span></li>
                        <li><span class="caret"><strong>cucumbercontext</strong> - Test Data sharing between scenarios</span></li>
                        <li><span class="caret"><strong>locators</strong> - UI page wise object locators</span></li>
                        <li><span class="caret"><strong>stepdef</strong> - Step definition mapping for feature file</span></li>
                        <li><span class="caret"><strong>testcases</strong> - Cucumber TestRunner</span></li>
                    </ul>
                </ul>
          <li>resources</li>
            <ul class="nested">
                <li><span class="caret"><strong>features</strong> - Scenario feature file</span></li>
                <li><span class="caret"><strong>properties</strong> - Log4j and TestBed properties</span></li>
            </ul>
        </ul>
      </li>
    </ul>
  </li>

<ul id="myUL">
    <li><span class="caret">testreport</span>
    <ul class="nested">
      <li><span class="caret">cucumber</span>
        <ul class="nested">
          <li><strong>latest</strong> - latest executed report</li>
          <li><strong>history</strong> - previous execution reports</li>
        </ul>
        </ul>
      </li>
    </ul>