package by.paulouskin.selenium;

import by.paulouskin.utils.DriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest extends DriverBase{
    static WebDriver wd;

    @Test
    public void RunChromeBrowser() {
        wd = DriverBase.getDriver();
        wd.get("http://www.google.com");
    }
}
