package org.ornikar.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.utilities.PropertiesReader;
import org.ornikar.utilities.SeleniumUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseSteps {

    public static final String CHECKING_THAT_THE_FIELD = "CHECKING THAT THE FIELD ";
    private static final WebDriver driver = Hooks.driver;
    private final Hooks hooks = new Hooks();
    private final WebDriverWait wait;
    private final PropertiesReader propertiesReader;

    public BaseSteps() throws Exception {

        propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @When("J attends {int} secondes")
    public static void jAttendsSecondes(int waitTime) throws InterruptedException {
        System.out.println("WAITING " + waitTime + " SECONDS");
        Thread.sleep(waitTime * 1000L);
    }

    @Then("Le champ {string} a le texte {string}")
    public static void i_check_that_the_field_has_the_text(String locator, String arg1) throws Exception {
        locator = PropertiesReader.getValue(locator);
        System.out.println();
        System.out.println(CHECKING_THAT_THE_FIELD + locator + " HAS THE TEXT " + arg1);
        assertEquals(arg1, SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(locator)).getText());

    }

    @Then("L element {string} est clickable")
    public void lElementEstClickable(String element) throws Exception {
        element = PropertiesReader.getValue(element);
        System.out.println("CHECKING THAT THE ELEMENT " + element + " IS CLICKABLE");
        assertTrue("The element " + element + " is not clickable", isClickable(element));
    }

    @Then("L element {string} est present")
    public void the_element_is_present(String locator) throws Exception {
        locator = PropertiesReader.getValue(locator);
        System.out.println();
        System.out.println("CHECKING THE PRESENCE OF THE ELEMENT " + locator);
        boolean isPresent;
        try {
            SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(locator));
            isPresent = true;
        } catch (WebDriverException e) {
            isPresent = false;
        }
        assertTrue("The element " + locator + " is not present on the current page", isPresent);
    }

    private boolean isClickable(String element) {
        boolean isClickable;
        try {
            isClickable = SeleniumUtils.waitAndFindElement(driver, SeleniumUtils.getLocatorByString(element)).isEnabled();
        } catch (Exception e) {
            isClickable = false;
        }
        return isClickable;
    }
}
