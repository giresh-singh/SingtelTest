package com.singtel.automation.test.stepdef;

import com.singtel.automation.test.cucumbercontext.ScenarioContext;
import com.singtel.automation.test.cucumbercontext.TestContext;
import com.singtel.automation.test.testcases.testng.BaseTest;

public class BaseStep extends BaseTest {
    private ScenarioContext scenarioContext;
    public BaseStep(TestContext testContext)
    {
        scenarioContext = testContext.getScenarioContext();
    }
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


}
