package com.singtel.automation.test.testcases.cucumber;

import courgette.api.*;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads =1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        rerunAttempts = 1,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTitle = "Test Automation Execution Report",
        reportTargetDir = "testreport/cucumber/latest",
        environmentInfo = "browser=Chrome",

        plugin = { CourgettePlugin.EXTENT_REPORTS },
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features/",
                glue = "com/singtel/automation/test/stepdef",
                tags = "@Test",
                publish=false
        ))
public class TestRunner extends TestNGCourgette {
}

