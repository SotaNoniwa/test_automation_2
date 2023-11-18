package hu.unideb.inf;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs{

    @Then("the {string} message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getMessage());
    }

    @Then("the user is directed to {string}")
    public void theUserIsDirectedToPageUrl(String pageUrl) {
        assertEquals(pageUrl, homePage.getPageUrl());
    }
}
