package by.paulouskin.etsycucumber.stepdefs;

import cucumber.api.java.Before;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        System.out.println("Starting our Cucumber tests");
    }
}
