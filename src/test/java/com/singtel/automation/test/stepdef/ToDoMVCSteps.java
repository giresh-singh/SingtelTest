package com.singtel.automation.test.stepdef;

import com.singtel.automation.test.cucumbercontext.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ToDoMVCSteps extends BaseStep {

    public ToDoMVCSteps(TestContext testContext) {
        super(testContext);
    }


    /**
     * HOME PAGE
     */
    @Given("^Open the given URL in a Browser.$")
    public void openTheGivenURLInABrowser() {
        homePage.openURL();
    }

    @When("^add the Item: \"([^\"]*)\" in To Do list.$")
    public void addItemInToDoList(String text) {
        homePage.addItemInToDoList(text);
    }


    @When("^add the TODO \"([^\"]*)\" to the list.$")
    public void addTheTODOItemToTheList(String ItemName) {
        homePage.addItemInToDoList(ItemName);
    }

    @Then("mark the added \"([^\"]*)\" complete.$")
    public void markTheAddedItemComplete(String ItemName) {
        homePage.markActiveItemAsCompleted(ItemName);
    }

    @Then("^mark the completed \"([^\"]*)\" as active.$")
    public void markTheCompletedAsActive(String ItemName) {
        homePage.markCompletedItemAsActive(ItemName);
    }

    @Then("^Delete \"([^\"]*)\" from to do list.$")
    public void deleteFromToDoList(String Item) {
        homePage.deleteItemFromToDoList(Item);
    }

    @When("^add multiple items to the TODO \"([^\"]*)\" to the list.$")
    public void addMultipleItemsToTheTODOToTheList(String Item) {
        String[]  lstItems = Item.split("<>");
        for(String item : lstItems){
            homePage.addItemInToDoList(item.trim());
        }
    }

    @Then("^Count added items in to do list.$")
    public void countAddedItemsInToDoList() {
        homePage.verifyAllTODOListCount(6);
    }

    @Then("^Count Completed and Active in to do list.$")
    public void countCompletedAndActiveInToDoList() {
        homePage.applyCompletedFilter();
        homePage.verifyCompletedCount(1);
        homePage.applyActiveFilter();
        homePage.verifyActiveCount(5);
        homePage.applyAllFilter();
    }

}
