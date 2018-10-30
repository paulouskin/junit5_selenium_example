package by.paulouskin.etsycucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class EtsyComPageObject extends BasePageObject{

    private static final String SEARCH_BUTTON_WRAPPER = "button.homepage-search-button";
    private final String SHOP_LOCATION_SEARCH_BUTTON = "button.shop-location-submit";
    private final String SHOP_LOCATION_TEXT_FIELD = "#shop-location-input";
    private final String TERMS_AND_CONDITIONS_WRAPPER = "div.alert";
    private final String ACCEPT_POLICY_BUTTON = "button.btn-outline-black";
    private final String SEARCH_FIELD = "#search-query";
    private  String FILTER_FOR_CATEGORY_LINK = "//h5[text()='%s']/../..//a[contains(.,'%s')]"; //Check

    public EtsyComPageObject(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("http://www.etsy.com/uk");
    }

    public void acceptTermsAndConditions() {
        findElementWithWait(By.cssSelector(TERMS_AND_CONDITIONS_WRAPPER));
        findElementWithWait(By.cssSelector(ACCEPT_POLICY_BUTTON)).click();
    }

    public void searchForItem(String query) {
        enterSearchQuery(query);
        getSearchButton().click();
    }

    private WebElement getSearchButton() {
        return findElementWithWait(By.cssSelector(SEARCH_BUTTON_WRAPPER));
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

    public void applyFilterFromCategory(String category, String filter) {
        WebElement filter_link = checkFilterForCategorySection(filter,category);
        filter_link.click();
    }

    private WebElement checkFilterForCategorySection(String filter, String category) {
        String xpath = String.format(FILTER_FOR_CATEGORY_LINK, category, filter);
        return new WebDriverWait(webDriver,10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
        );
    }

    public List<String> getAppliedFilterTagsForSearchResults() {
        return findElementsWithWait(By.cssSelector(".tag")).stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    public void selectShopLocation(String location) {
        enterLocationToShopLocationField(location);
        //selectFirstItemInShopLocationSuggestionsList();
        clickShopLocationSearchButton();
    }

    private void clickShopLocationSearchButton() {
        findElementWithWait(By.cssSelector(SHOP_LOCATION_SEARCH_BUTTON)).click();
    }

    private void enterLocationToShopLocationField(String location) {
        WebElement shopLocationText = findElementWithWait(By.cssSelector(SHOP_LOCATION_TEXT_FIELD));
        shopLocationText.clear();
        shopLocationText.sendKeys(location);
    }
}
