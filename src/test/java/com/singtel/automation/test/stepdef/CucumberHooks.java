package com.singtel.automation.test.stepdef;

import com.singtel.automation.framework.engine.SeleniumHelper;
import com.singtel.automation.framework.reader.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks
{
    public static Scenario eachScenario;

    @Before
    public void setupHooks(Scenario scenario)
    {
        System.out.println(scenario.getName());
        CucumberHooks.eachScenario = scenario;
    }

   @AfterStep
    public void after(Scenario scenario) {
        if (PropertyReader.getTestBedProperties("takeAllSnapshots").equalsIgnoreCase("yes")) {
            TakesScreenshot screenshot = (TakesScreenshot) SeleniumHelper.getWebDriver();
            scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
        } else {
            if (scenario.isFailed()) {
                TakesScreenshot screenshot = (TakesScreenshot) SeleniumHelper.getWebDriver();
                scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
            }
        }
    }
    @After
    public void cleanUp()
    {
        SeleniumHelper.getWebDriver().quit();
    }
}
