# Singtel Automation Framework - Selenium & Java 
<p>Purpose of this README is to provide overview of framework, how to get framework from github, environment required, how to execute scenarios, view report and brief about framework architecture</p>
<b><u>Overview</u></b><br>
    Framework is developed by using Selenium-Cucumber-java.<br>
    WebDriverManager is used which carries out the management (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.<br>
    Cucumber is used to supports behavior-driven development. Cucumber BDD approach is its ordinary language parser called Gherkin.<br>
    Courgette is used which browse cucumber features from within Rails app it help in reporting and parallel execution.<br>
    Dependency injection for test data context. <br>
<br><b><u>Github details</u></b><br>
    Repository URL - https://github.com/giresh-singh/SingtelTest
        <br>Click on Code button and choose option to download framework</br>
<br><b><u>IDE and Env used</u></b><br> 
    IntelliJ IDEA 2021.2.1 (Community Edition), Chrome browser</br>
<br><b><u>Execute test</u></b></br>
    <h6>1. By using TestRunner - </h6> TestRunner.java file is available on below path - <i>src/test/java/com/singtel/automation/test/testcases/cucumber/TestRunner.java</i><br> Mouse right click and choose option Run TestRunner</br>
<h6>2. By using 'mvn test' command  - </h6> 
    Open Intellij IDE terminal (Alt + F12). Now we can use below commands -
<table><tr><td> ><strong> mvn clean</strong></td><tr><td>> <strong>mvn test</strong></td></tr></table>
<b><u>Check report</u></b><br>
    <h6>Latest Report -</h6> .\singtel\testreport\cucumber\latest\courgette-report<br>
    <h6>Report History -</h6> .\singtel\testreport\cucumber\history\courgette-report<br>
<br><b><u>Test Scenarios</u></b><br>
    There are six scenarios created in feature file and their steps are defined in step definition file.
    <h6>Feature File -</h6> .\singtel\src\test\resources\features\HomePage.feature <br>
    <h6>Step Definition File -</h6> .\singtel\src\test\java\com\singtel\automation\test\stepdef\ToDoMVCSteps.java <br>
    <h6>Scenario Outlines -</h6> 
        <table>
            <tr>
                <th>Scenario</th>
                <th>Objective</th>
              </tr>
            <tr><td> Verify adding a todo to the list</td><td>User is able to add a item in TODO List</td></tr>
            <tr><td> Verify marking the item in the list complete</td><td>User is able to mark complete a item from TODO list</td></tr>
            <tr><td> Verify Completed item marked Active</td><td>User is able to change Completed item into Active status by clicking again on Completed Item</td></tr>
            <tr><td> Verify delete item from to do list</td><td>User is able to Delete an item from TODO List</td></tr>
            <tr><td> Verify multiple items adding a todo to the list</td><td>User is able to add multiple items in TODO List</td></tr>
            <tr><td> Verify Completed and Active counts from todo to list</td><td>User is able to apply Active/Completed filters and match count for same in TODO List</td></tr>
        </table>
<br/><b><u>Framework Architecture</u></b><br></br>
    <ul id="myUL">
    <li><span class="caret">src</span>
    <ul class="nested">
      <li><span class="caret">test</span>
        <ul class="nested">
          <li>java -> framework and test related java codes </li>
                <ul class="nested">
                    <li><span class="caret">framework -> </span></li>
                    <li><span class="caret">test -> </span></li>
                </ul>
          <li>resources -> like feature file framework properties file </li>
        </ul>
      </li>
    </ul>
  </li>
</ul>