package by.paulouskin.etsycucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageObject {

    protected WebDriver webDriver;

    protected final int MAX_WAIT_TIME = 60;

    public BasePageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebElement findElementWithWait(By locator) {
        return new WebDriverWait(webDriver, MAX_WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElementsWithWait(By locator) {
        return new WebDriverWait(webDriver, MAX_WAIT_TIME).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
