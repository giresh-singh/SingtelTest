package com.singtel.automation.test.testcases.cucumber;

import com.singtel.automation.framework.utils.FileUtils;
import com.singtel.automation.framework.utils.GenericHelper;
import courgette.api.*;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        @AfterClass
        public void copyFIle()
        {
                FileUtils.copyCourgetteReportsInHistory();
        }

 }

