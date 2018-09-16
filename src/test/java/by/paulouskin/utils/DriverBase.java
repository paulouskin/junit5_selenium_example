package by.paulouskin.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool =
            Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeAll
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<DriverFactory>(){
            @Override
            protected DriverFactory initialValue() {
                DriverFactory webDriverThread = new DriverFactory();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    @AfterEach
    public void clearCookies() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterAll
    public static void closeDriverObjects() {
        webDriverThreadPool.forEach(DriverFactory::quitDriver);
    }
}
