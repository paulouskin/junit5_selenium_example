package by.paulouskin.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {
    static RemoteWebDriver wd;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\");
        ChromeOptions opts = new ChromeOptions();
        try {
            wd = new RemoteWebDriver(
                    new URL("http://192.168.0.16:4444/wd/hub"), opts);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RunChromeBrowser() {
        wd.get("http://www.google.com");
    }

    @AfterAll
    public static void tearDown() {
        wd.close();
    }
}
