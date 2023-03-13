package org.ornikar.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.utilities.BaseClass;

import static org.ornikar.stepDefinitions.BaseSteps.jAttendsSecondes;

public class GarantiePage extends BaseClass {

    @FindBy(xpath = "//h2[text()='Découvrez les garanties indispensables de votre assurance auto']")
    @CacheLookup
    private WebElement textGarantieIndisp;
    @FindBy(xpath = "//h3[text()='Défense Pénale et Recours']")
    @CacheLookup
    private WebElement textGarantieDefense;
    @FindBy(xpath = "//h3[text()='Responsabilité Civile']")
    @CacheLookup
    private WebElement textGarantieRC;
    @FindBy(xpath = "//h3[text()='Protection du Conducteur']/ancestor::div[@class='Heading_2m3Vdu']")
    @CacheLookup
    private WebElement textGarantiePC;

    public GarantiePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void assertGaranties() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", textGarantieIndisp);
        jAttendsSecondes(2);
        WaitUntilElementVisible(textGarantieRC);
        textGarantieRC.isDisplayed();
        WaitUntilElementVisible(textGarantieDefense);
        textGarantieDefense.isDisplayed();
        WaitUntilElementVisible(textGarantiePC);
        textGarantiePC.isDisplayed();

    }
}
