package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static hu.unideb.inf.AbstractStepDefs.homePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingStepDefs {

    @Given("the item {string} is selected")
    public void selectItem(String item) {
        homePage.selectItem(item);
    }

    @Then("the price should read {string}")
    public void thePriceShouldRead(String total) {
        assertEquals(total, homePage.getTotal());
    }

    @Then("the message should read {string}")
    public void theMessageShouldRead(String message) {
        assertEquals(message, homePage.getAddedItemMessage());
    }
}
