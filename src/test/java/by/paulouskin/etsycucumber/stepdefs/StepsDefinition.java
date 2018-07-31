package by.paulouskin.etsycucumber.stepdefs;

import by.paulouskin.etsycucumber.pageobjects.EtsyComPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class StepsDefinition {

    WebDriver webDriver = new ChromeDriver();
    private EtsyComPageObject etsyPage;

    @Given("^I am on the main page$")
    public void goToMainPage() {
        etsyPage = new EtsyComPageObject(webDriver);
    }


    @When("^I accept terms and conditions$")
    public void i_accept_terms_and_conditons() {
        etsyPage.acceptTermsAndConditions();
    }

    @When("^I search for \"(.*?)\" items$")
    public void search_for_items(String query) {
        etsyPage.searchForItem(query);
    }

    @Then("^I see search results table$")
    public void isSearchResultsTableVisible() {
        assertThat("Search results is visible",
                etsyPage.isSearchResultsVisible());
    }

    @Then("^I get search results for \"(.*?)\" items$")
    public void i_get_results_page_for_search_query(String items) {
        assertThat(etsyPage.getTitle(),
                stringContainsInOrder(Arrays.asList(items.split(" "))));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
