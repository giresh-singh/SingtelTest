# Singtel Automation Framework - Selenium & Java 
<p>Purpose of this README is to provide helps on below items</p>
<b><u>Github details</u></b><br>
    Repository URL - https://github.com/giresh-singh/SingtelTest
        <br>Click on Code button and choose option to download framework</br>
<br><b><u>IDE and Env used</u></b><br> 
    IntelliJ IDEA 2021.2.1 (Community Edition)</br>
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
            <tr><td> Verify adding a todo to the list</td>
            <tr><td> Verify marking the item in the list complete</td></tr>
            <tr><td> Verify Completed item marked Active</td></tr>
            <tr><td> Verify delete item from to do list</td></tr>
            <tr><td> Verify multiple items adding a todo to the list</td></tr>
            <tr><td> Verify Completed and Active counts from todo to list</td></tr>
        </table>
<br/><b><u>Framework Architecture</u></b><br></br>
<br/><b><u>Framework high pont</u></b><br></br>