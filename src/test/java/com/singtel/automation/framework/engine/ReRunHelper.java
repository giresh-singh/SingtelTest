package com.singtel.automation.framework.engine;

import com.singtel.automation.framework.utils.PropertyReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunHelper implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount =Integer.parseInt(PropertyReader.getTestBedProperties("reRunOnFailureCount"));

    public boolean retry(ITestResult result)
    {
        if(retryCount < maxRetryCount)
        {
            retryCount++;
            return true;
        }
        return false;
    }

}
