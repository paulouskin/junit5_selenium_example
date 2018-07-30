package by.paulouskin.etsycucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsDefinition {

    WebDriver webDriver = new ChromeDriver();

    @Given("^I go to \"(.*)\" page$")
    public void i_go_to_Etsy_com_page(String page) {
        webDriver.get("http://www.etsy.com");
    }


    @When("^I accept terms and conditions$")
    public void i_accept_terms_and_conditons() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I search for \"(.*)\" items$")
    public void search_for_items(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get results page for \"(.*)\" items$")
    public void i_get_results_page_for_search_query(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
