package by.paulouskin.etsycucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EtsyComPageObject extends BasePageObject{

    private final String TERMS_AND_CONDITIONS_WRAPPER = "div.alert";
    private final String SEARCH_FIELD = "#search-query";

    public EtsyComPageObject(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("http://www.etsy.com");
    }

    public void acceptTermsAndConditions() {
        findElementWithWait(By.cssSelector(TERMS_AND_CONDITIONS_WRAPPER))
                .findElement(By.cssSelector("button.btn-outline-black")).click();
    }

    public void searchForItem(String query) {
        enterSearchQuery(query);
        getSearchButton().click();
    }

    private WebElement getSearchButton() {
        return findElementWithWait(By.cssSelector("div.search-button-wrapper button"));
    }

    private void enterSearchQuery(String query) {
        WebElement searchField = findElementWithWait(By.cssSelector(SEARCH_FIELD));
        searchField.clear();
        searchField.sendKeys(query);
    }

    public String getTitle() {
        return webDriver.getTitle().toLowerCase();
    }

    public boolean isSearchResultsVisible() {
        return findElementWithWait(By.cssSelector("div.search-listings-group")).isDisplayed();
    }
}
