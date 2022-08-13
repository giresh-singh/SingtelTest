package com.singtel.automation.test.stepdef;

import com.singtel.automation.test.constant.Constant;

import com.singtel.automation.test.cucumbercontext.Context;
import com.singtel.automation.test.cucumbercontext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;


public class ToDoMVCSteps extends BaseStep {

    public ToDoMVCSteps(TestContext testContext) {
        super(testContext);
    }


    /**
     * HOME PAGE
     */
    @Given("^user opens homepage.$")
    public void openURL() {
        homePage.openURL();
    }


    @When("^add the Item: \"([^\"]*)\" in To Do list.$")
    public void addItemInToDoList(String text) {
        homePage.addItemInToDoList(text);
    }

}
