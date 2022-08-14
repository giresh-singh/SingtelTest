package com.singtel.automation.framework.engine;

import com.singtel.automation.framework.exception.SingtelException;
import com.singtel.automation.framework.log.LogHelper;
import com.singtel.automation.framework.utils.GenericHelper;
import com.singtel.automation.framework.reader.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class SeleniumHelper extends WebDriverFactory {
    static int MAX_TIME_WEB_ELEMENT = Integer.parseInt(PropertyReader.getTestBedProperties("maxTimeOutWebElement"));
    GenericHelper genFunctions = new GenericHelper();
    LogHelper logger = new LogHelper();

    public static WebDriver getWebDriver() {
        return driver;
    }

    public void openURL(String url) throws SingtelException {
        try {
            driver = WebDriverFactory.getDriver();
            driver.get(url);
            logger.info("URL opened: " + url);
        } catch (Exception e) {
            logger.fatal("Unable to open URL:" + url + "</br>" + e.getMessage());
            throw new SingtelException("Unable to open URL:" + url + "</br>" + e.getMessage());
        }
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    public void navigateToNewURL(String url) throws SingtelException {
        try {
            driver = WebDriverFactory.getDriver();
            driver.get(url);
            logger.info("Navigated to URL: " + url);
        } catch (Exception e) {
            logger.fatal("Unable to navigated to URL: " + url + "</br>" + e.getMessage());
            throw new SingtelException("Unable to navigated to URL: " + url + "</br>" + e.getMessage());
        }
    }

    public By by(String locatorType, String locatorValue) throws SingtelException {
        By by = null;
        try {
            switch (locatorType.toLowerCase()) {
                case "xpath":
                    by = By.xpath(locatorValue);
                    break;
                case "id":
                    by = By.id(locatorValue);
                    break;
                case "name":
                    by = By.name(locatorValue);
                    break;
                case "tag":
                    by = By.tagName(locatorValue);
                    break;
            }
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
        return by;
    }

    public WebElement findElement(By by) throws SingtelException {
        WebElement eleToAction = null;
        boolean flag = false;
        try {
            eleToAction = driver.findElement(by);
            if (eleToAction.getLocation().getX() < 0 && eleToAction.getLocation().getY() < 0) {
                throw new NoSuchElementException();
            }
        } catch (Exception NoSuchElementException) {
            System.out.println("Exception in Finding Element for by: "+by.toString());
            for (int i = 0; i <= MAX_TIME_WEB_ELEMENT; i++) {
                if (driver.findElements(by).size() > 0) {
                    for (WebElement ele : driver.findElements(by)) {
                        if (ele.getLocation().getX() > 0 && ele.getLocation().getY() > 0) {
                            eleToAction = ele;
                            flag = true;
                            break;
                        }
                    }
                } else {
                    genFunctions.wait(1);
                }
                i++;
                if (flag) {
                    logger.info("Element identified in Console: " + by.toString());
                    break;
                }
            }
        }
        return eleToAction;
    }

    public List<WebElement> findElementCollection(By by) throws SingtelException {
        List<WebElement> eleCollection;
        try {
            eleCollection = driver.findElements(by);
        } catch (Exception e) {
            logger.fatal(("Unable to identify element " + by.toString() + e.getMessage()));
            throw new SingtelException("Unable to identify element " + by + " " + e.getMessage());
        }
        return eleCollection;
    }

    public List<WebElement> findChildElementCollection(WebElement ele, By by) throws SingtelException {
        List<WebElement> eleCollection;
        try {
            eleCollection = ele.findElements(by);
        } catch (Exception e) {
            logger.fatal(("Unable to identify child element " + by.toString() + e.getMessage()));
            throw new SingtelException("Unable to identify child element " + by + " " + e.getMessage());
        }
        return eleCollection;
    }

    public WebElement findElementByIndex(By by, int index) throws SingtelException {
        WebElement ele;
        try {
            genFunctions.initialTimeWait();
            ele = findElementCollection(by).get(index);
        } catch (Exception e) {
            logger.fatal(("Unable to identify element " + by.toString() + " for index: " + index + " " + e.getMessage()));
            throw new SingtelException("Unable to identify element " + by + " for index: " + index + " " + e.getMessage());
        }
        logger.info("Identify element: " + by.toString() + " for index: " + index);
        return ele;
    }

    public void click(String locatorType, String locatorValue) throws SingtelException {
        try {
            By by = by(locatorType, locatorValue);
            click(by);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void click(By by) throws SingtelException {
        try {
            WebElement ele = findElement(by);
            click(ele);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void clickCheckbox(By by) throws SingtelException {
        try {
            WebElement ele = findElement(by);
            click(ele);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void click(WebElement ele) throws SingtelException {
        try {
            ele.click();
            logger.info("Element " + ele + " is clicked.");
        } catch (Exception e) {
            logger.fatal("Unable to click Element " + ele.toString());
            System.out.println("Unable to click Element " + ele.toString()+" Using Javascript Executor.");
            clickUsingJavaScriptOnWebElement(ele);
        }
    }

    public void doubleClick(By by) throws SingtelException {
        try {
            WebElement ele = findElement(by);
            doubleClick(ele);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void doubleClick(WebElement ele) throws SingtelException {
        try {
            Actions action = new Actions(driver);
            action.doubleClick(ele).build().perform();
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void moveAndClick(By by) throws SingtelException {
        WebElement ele;
        try {
            ele = findElement(by);
            moveAndClick(ele);
        } catch (Exception e) {
            logger.fatal("Unable to move and click element: " + by.toString() + " " + e.getMessage());
            throw new SingtelException("Unable to move and click element: " + by + " " + e.getMessage());
        }
    }
    public void moveAndClick(WebElement ele) throws SingtelException {
        try {
            waitTillElementIsClickable(ele);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
            click(ele);
            logger.info("Moved and clicked on element: " + ele.toString());
        } catch (Exception e) {
            logger.fatal("Unable to move and click element: " + ele.toString() + " " + e.getMessage());
            throw new SingtelException("Unable to move and click element: " + ele + " " + e.getMessage());
        }
    }
    public void type(By by, String text) throws SingtelException {
        try {
            type(findElement(by), text);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void type(WebElement ele, String text) throws SingtelException {
        try {
            ele.sendKeys(text);
        } catch (Exception e) {
            throw new SingtelException("Unable to type on element: " + ele.toString() + " " + e.getMessage());
        }
    }

    public void clearAndType(By by, String text) throws SingtelException {
        WebElement ele = null;
        try {
            ele = findElement(by);
            click(ele);
            String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
            ele.sendKeys(del);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='';", ele);
            ele.sendKeys(text);
            logger.info("Able to clear and type on WebElement: " + ele);
        } catch (Exception e) {
            logger.fatal("Unable to clear and type on WebElement: " + ele);
            throw new SingtelException("Unable to clear and type on WebElement: " + ele);
        }
    }

    public String getText(By by) throws SingtelException {
        WebElement ele;
        try {
            ele = findElement(by);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
        return getText(ele);
    }

    public String getText(WebElement ele) throws SingtelException {
        try {
            return ele.getText();
        } catch (Exception e) {
            throw new SingtelException("Unable to get text for Element: " + ele.toString() + " " + e.getMessage());
        }
    }

    public boolean verifyTitle(String title) throws SingtelException {
        boolean flag = false;
        try {
            genFunctions.wait(1);

            if (driver.getTitle().toLowerCase().contains(title.toLowerCase())) {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }



    public boolean isDisplayed(By by) throws SingtelException {
        boolean flag = false;
        try {
            genFunctions.wait(2);
            List<WebElement> eleCollection = findElementCollection(by);
            if (eleCollection.size() > 0) {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public FluentWait<WebDriver> dynamicWait(int timeOut) {
        FluentWait<WebDriver> fluentWait;

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
        return fluentWait;
    }

    public void waitTillElementIsNotDisplayed(By by, int timeOut) {
        dynamicWait(timeOut).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitTillElementIsClickable(WebElement ele) {
        dynamicWait(MAX_TIME_WEB_ELEMENT).until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitTillElementIsDisplayed(By by) {
        dynamicWait(MAX_TIME_WEB_ELEMENT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void activeIFrame() {
        int iterationCounter = 1;

        while (iterationCounter <= 5) {
            try {
                WebElement webGadget = findElement(By.cssSelector("div[id*='PegaWebGadget'][tabindex='0']"));
                String iFrameID = webGadget.getAttribute("pegagadget") + "Ifr";
                waitTillIActiveFrameIsDisplayedAndSwitch(iFrameID);
                return;
            } catch (NoSuchElementException e) {
                ++iterationCounter;
            }
        }
    }


    public void waitTillIFrameIsDisplayedAndSwitch(String frameName) {
        driver.switchTo().defaultContent();
        genFunctions.initialTimeWait();
        dynamicWait(MAX_TIME_WEB_ELEMENT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    public void waitTillIActiveFrameIsDisplayedAndSwitch(String frameId) {
        driver.switchTo().defaultContent();
        dynamicWait(10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
    }


    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchToNewWindow(String homeWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!(windowHandle.equalsIgnoreCase(homeWindow))) {
                System.out.println(windowHandle);
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void scrollToElement(By by) throws SingtelException {
        WebElement ele;
        try {
            ele = findElement(by);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", ele);
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void quitBrowser() throws SingtelException {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            throw new SingtelException(e.getMessage());
        }
    }

    public void clickUsingJavaScriptOnWebElement(By by) {
        WebElement ele = findElement(by);
        clickUsingJavaScriptOnWebElement(ele);
    }

    public void clickUsingJavaScriptOnWebElement(WebElement ele) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", ele);
        genFunctions.initialTimeWait();
    }

    public String getAttribute(By by){
        WebElement ele = findElement(by);
        return ele.getAttribute("class");
    }
}
