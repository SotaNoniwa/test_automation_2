package hu.unideb.inf;

import io.cucumber.java.en.Then;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs{

    @Then("the {string} email message is shown")
    public void theEmailErrorMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getEmailErrorMessage());
    }

    @Then("the {string} password message is shown")
    public void thePasswordErrorMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getPasswordErrorMessage());
    }

    @Then("the {string} login message is shown")
    public void theLoginErrorMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getLoginErrorMessage());
    }

    @Then("the user is directed to {string}")
    public void theUserIsDirectedToPageUrl(String pageUrl) {
        assertEquals(pageUrl, homePage.getPageUrl());
    }
}
