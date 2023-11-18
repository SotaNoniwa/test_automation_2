package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static hu.unideb.inf.AbstractStepDefs.homePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingStepDefs {

    @Given("the {string} is added to the cart")
    public void itemIsAddedToTheCart(String item) {
        homePage.addItemToCart(item);
    }

    @Then("the price should read {string}")
    public void thePriceShouldRead(String total) {
        assertEquals(total, homePage.getTotal());
    }
}
