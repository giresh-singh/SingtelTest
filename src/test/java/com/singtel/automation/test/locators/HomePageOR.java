package com.singtel.automation.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class HomePageOR {

    /**
     * HOME PAGE
     */
    public static final By TO_DO_INPUT_BOX= By.className("new-todo");
    public static final By TO_DO_FILTER_Completed= By.linkText("Completed");
    public static final By TO_DO_FILTER_Active= By.linkText("Active");
    public static final By TO_DO_FILTER_All= By.linkText("All");
}
