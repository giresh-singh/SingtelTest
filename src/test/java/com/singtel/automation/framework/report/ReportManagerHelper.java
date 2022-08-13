package com.singtel.automation.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.singtel.automation.framework.engine.WebDriverFactory;
import com.singtel.automation.framework.exception.SingtelException;
import com.singtel.automation.framework.utils.DateHelper;
import com.singtel.automation.framework.utils.PropertyReader;

public class ReportManagerHelper extends WebDriverFactory
{
    public static final ExtentReports extentReports = new ExtentReports();
    static DateHelper fmtDate=new DateHelper();
    public synchronized static ExtentReports createExtentReports() throws SingtelException
    {
        try {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testreport/" + PropertyReader.getTestBedProperties("framework") + "/ExtentReport_" + fmtDate.getUniqueString() + ".html");
            reporter.config().setReportName("Automation Report");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Browser", PropertyReader.getTestBedProperties("browserName").toUpperCase());
            extentReports.setSystemInfo("Application URL", PropertyReader.getTestBedProperties("url"));
        } catch(Exception e) {
            throw new SingtelException(e.getMessage());
        }
        return extentReports;
    }

    public static void closeReport() throws SingtelException
    {
        try{
            extentReports.flush();
        }
        catch(Exception e)
        {
            throw new SingtelException(e.getMessage());
        }
    }
}
