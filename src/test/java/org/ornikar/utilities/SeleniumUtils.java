package org.ornikar.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    private SeleniumUtils() {

    }

    public static WebElement waitAndFindElement(WebDriver driver, By locator) throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        return waitAndFindElement(driver, locator, propertiesReader.getTimeout().intValue());
    }

    public static WebElement waitAndFindElement(WebDriver driver, By locator, int timeout) {
        WebDriverWait w = new WebDriverWait(driver, timeout);
        w.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        try {
            w.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
            element = driver.findElement(locator);
            w.until(ExpectedConditions.elementToBeClickable(element));
        }
        return element;
    }

    public static WebElement waitAndFindElement(WebDriver driver, WebElement element) throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        WebDriverWait w = new WebDriverWait(driver, propertiesReader.getTimeout());
        //w.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            w.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
            w.until(ExpectedConditions.elementToBeClickable(element));
        }
        return element;
    }

    public static By getLocatorByString(String locatorString) {
        String locatorType = locatorString.substring(0, locatorString.indexOf('='));
        locatorString = locatorString.substring(locatorString.indexOf('=') + 1);
        switch (locatorType) {
            case "xpath":
                return By.xpath(locatorString);
            case "css":
                return By.cssSelector(locatorString);
            case "id":
                return By.id(locatorString);
            case "link":
            case "text":
            case "linkText":
                return By.linkText(locatorString);
            case "name":
                return By.name(locatorString);
            case "tag_name":
                return By.tagName(locatorString);
            case "class":
                return By.className(locatorString);
        }
        return null;
    }
}
