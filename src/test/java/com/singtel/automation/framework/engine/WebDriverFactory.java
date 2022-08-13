package com.singtel.automation.framework.engine;

import com.singtel.automation.framework.exception.SingtelException;
import com.singtel.automation.framework.log.LogHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.singtel.automation.framework.utils.PropertyReader;

public class WebDriverFactory
{
    public static WebDriver driver;
    static LogHelper logger = new LogHelper();

    public static WebDriver getDriver() throws SingtelException
    {
        String browser = null;
        try {
            browser = System.getProperty("browser");
            if (browser == null) {
                browser = PropertyReader.getTestBedProperties("browserName");
            }
            switch (browser.toLowerCase().trim()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    /*options.setHeadless(true);*/
                    driver = new ChromeDriver(options);
                    break;
                case "ie":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                case "firefox":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                case "edge":
                    logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver.");
                    break;
                default:
                    driver= WebDriverManager.chromedriver().create();
            }
            driver.manage().window().maximize();
        }
        catch(Exception e)
        {
            logger.fatal("Unable to create "+browser.toUpperCase()+" Wedriver. "+e.getMessage());
            throw new SingtelException("Unable to create "+browser.toUpperCase()+" Wedriver. "+e.getMessage());
        }
        logger.info(browser.toUpperCase()+" Wedriver created.");
        return driver;
    }

    public static WebDriver returnDriverInstance()
    {
        return driver;
    }
}
