package com.singtel.automation.test.businessfunctions;

import com.singtel.automation.framework.engine.SeleniumHelper;
import com.singtel.automation.framework.report.ReportStepHelper;
import com.singtel.automation.framework.utils.GenericHelper;
import com.singtel.automation.framework.utils.PropertyReader;
import com.singtel.automation.test.locators.HomePageOR;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class HomePage {
    SeleniumHelper selHelper = new SeleniumHelper();
    GenericHelper genFunctions = new GenericHelper();


    public void openURL() {
        try {
            selHelper.openURL(PropertyReader.getTestBedProperties("url"));
                if (selHelper.verifyTitle("TodoMVC")) {
                    ReportStepHelper.PASS("VU.js ToDoMVC page is displayed");
                }else{
                    ReportStepHelper.FAIL("Home page of Northstar application is not displayed:Authenticator is displayed.Please re-execute.");
                }
        } catch (Exception e) {
        }
    }

    public void addItemInToDoList(String text) {
        try {
            selHelper.type(HomePageOR.TO_DO_INPUT_BOX,text+ Keys.ENTER);
            if (selHelper.isDisplayed(By.xpath("//label[text()='"+text+"']"))) {
                ReportStepHelper.PASS("Item: "+text+" is added in the To Do List.");
            }else{
                ReportStepHelper.FAIL("Item: "+text+" is not added in the To Do List.");
            }
        } catch (Exception e) {
        }
    }
}