package org.ornikar.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.pageObjects.AssurancePage;
import org.ornikar.utilities.PropertiesReader;
import org.ornikar.utilities.SeleniumUtils;

public class GeneralSteps {

    private static final WebDriver driver = Hooks.driver;
    private static WebDriverWait wait;
    private final Hooks hooks = new Hooks();
    private AssurancePage assurancePage;

    public GeneralSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @When("Je clique sur l element {string}")
    public void i_click_on_the_element_(String locator) throws Exception {
        locator = PropertiesReader.getValue(locator);
        System.out.println();
        System.out.println("CLICKING ON THE ELEMENT : " + locator);
        WebElement element = SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(locator));

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @When("Je remplis le champ {string} avec le texte {string}")
    public void i_fill_the_field_with(String locator, String string2) throws Exception {
        locator = PropertiesReader.getValue(locator);
        System.out.println();
        System.out.println("FILLING THE FIELD " + locator + " WITH THE TEXT " + string2);
        WebElement element = SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(locator));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(string2);
    }

    @Given("Je me débarasse des cookies et chatbot")
    public void jeMeDébarasseDesCookiesEtChatbot() {
        assurancePage = new AssurancePage(driver, wait);
        assurancePage.eliminateCookiesAndChatbot();
    }

    @When("Je vais sur le frame {string}")
    public void i_switch_to_frame(String string) throws Exception {
        string = PropertiesReader.getValue(string);
        System.out.println();
        System.out.println("SWITCHING TO FRAME " + string);
        WebElement element = SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(string));
        driver.switchTo().frame(element);
    }

    @When("Je clique sur l element {string} en JS")
    public void clickJS(String locator) throws Exception {
        locator = PropertiesReader.getValue(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(locator));
        js.executeScript("arguments[0].click();", element);
    }

    @When("Je quitte le frame")
    public void i_exit_the_frame() {
        System.out.println();
        System.out.println("EXITING THE FRAME");
        driver.switchTo().parentFrame();
    }
}
