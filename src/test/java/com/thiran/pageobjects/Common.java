package com.thiran.pageobjects;

import com.thiran.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author Vimala P.
 */
public class Common extends DriverFactory {
    private static Map<String, String> testContext = new HashMap<>();

    public Map<String, String> getTestContext() {
        return testContext;
    }

    public WebDriverWait getWait() {
        // Configurable wait time in seconds - usually 20 seconds increased it noticing delay in loading pages
        WebDriverWait wait = new WebDriverWait(driver, 40);
        return wait;
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> elements) {
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
