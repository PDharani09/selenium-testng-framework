package com.dharani.base;

import com.dharani.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/** Opens a fresh browser before each test and closes it after. */
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        boolean headless = ConfigReader.headless();
        if ("edge".equalsIgnoreCase(ConfigReader.browser())) {
            EdgeOptions options = new EdgeOptions();
            if (headless) options.addArguments("--headless=new");
            driver = new EdgeDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            if (headless) options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(ConfigReader.BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
