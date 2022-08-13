package com.singtel.automation.test.testcases.testng;

import com.singtel.automation.framework.engine.SeleniumHelper;
import com.singtel.automation.framework.exception.SingtelException;
import com.singtel.automation.framework.report.ReportManagerHelper;
import com.singtel.automation.framework.report.ReportTestHelper;
import com.singtel.automation.test.businessfunctions.HomePage;
import com.singtel.automation.framework.utils.GenericHelper;
import com.singtel.automation.framework.utils.PropertyReader;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class BaseTest {

    /**
     * Properties
     */
    String framework = PropertyReader.getTestBedProperties("framework");
    /**
     * Test Data
     */
    public HashMap<String, String> testData = new HashMap<>();
    /**
     *Business Functions
     */
    public HomePage homePage = new HomePage();
    /**
     * Others
      */
    public GenericHelper genFunctions = new GenericHelper();


    @BeforeSuite
    public void createReport() {
        if (framework.equalsIgnoreCase("testng")) {
            try {
                ReportManagerHelper.createExtentReports();
            } catch (SingtelException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeMethod
    public void startTest(Method caller) {
        if (framework.equalsIgnoreCase("testng")) {
            ReportTestHelper.startTest(caller.getName(), "");
        }
    }

    @AfterMethod
    public void closeTest(Method caller) throws SingtelException {
        if (framework.equalsIgnoreCase("testng")) {
            SeleniumHelper selHelper = new SeleniumHelper();
            //selHelper.quitBrowser();
        }
    }

    @AfterSuite
    public void closeDrvierAndBrowser() throws SingtelException {
        if (framework.equalsIgnoreCase("testng")) {
            ReportManagerHelper.closeReport();
            //genFunc.killChromeInstances();
        }
    }
}
