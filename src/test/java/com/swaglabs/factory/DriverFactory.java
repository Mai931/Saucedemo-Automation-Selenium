package com.swaglabs.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    WebDriver driver;
    Exception BrowserNotFoundException=new Exception("browser not found");
    public WebDriver getDriver(String browser) throws Exception {

        browser = browser.toLowerCase().trim();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                Map<String,Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service",false);
                prefs.put("profile.password_manager_enabled",false);
                options.setExperimentalOption("prefs",prefs);
                options.addArguments("--incognito");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw BrowserNotFoundException;
        }
        return driver;
    }
}
