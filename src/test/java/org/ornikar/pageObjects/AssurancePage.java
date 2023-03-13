package org.ornikar.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.utilities.BaseClass;
import org.ornikar.utilities.PropertiesReader;
import org.ornikar.utilities.SeleniumUtils;

import static org.ornikar.stepDefinitions.BaseSteps.jAttendsSecondes;

public class AssurancePage extends BaseClass {

    @FindBy(xpath = "//h1[text()='L’assurance auto']")
    @CacheLookup
    private WebElement textAssuranceAuto;
    @FindBy(xpath = "//h2[text()='3 bonnes raisons d’assurer votre voiture chez Ornikar']")
    @CacheLookup
    private WebElement text3bonnesRaisons;
    @FindBy(xpath = "//span[text()=\"Oui tenez-moi au courant\"]/ancestor::div[@aria-hidden=\"true\"]")
    @CacheLookup
    private WebElement btnTenezMoiAuCourant;
    @FindBy(xpath = "//h3[text()='Efficace']")
    @CacheLookup
    private WebElement textEfficace;
    @FindBy(xpath = "//h3[text()='Facile']")
    @CacheLookup
    private WebElement textFacile;
    @FindBy(xpath = "//h3[text()='A l’écoute']")
    @CacheLookup
    private WebElement textEcoute;

    @FindBy(xpath = "//span[text()='Continuer sans accepter']/ancestor::div[@role=\"button\"]")
    @CacheLookup
    private WebElement btnCookies;
    @FindBy(css = "span.cc-1rzf.cc-yx2c")
    @CacheLookup
    private WebElement btnCloseChatbot;



    public AssurancePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public void verifyAssuranceTxtAndPresenceOfBtn() {
        WaitUntilElementVisible(textAssuranceAuto);
        textAssuranceAuto.isDisplayed();
        WaitUntilElementVisible(btnTenezMoiAuCourant);
        btnTenezMoiAuCourant.isDisplayed();
    }

    public void verify3BonnesRaisons() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", text3bonnesRaisons);
        jAttendsSecondes(2);
        WaitUntilElementVisible(textEfficace);
        textEfficace.isDisplayed();
        WaitUntilElementVisible(textFacile);
        textFacile.isDisplayed();
        WaitUntilElementVisible(textEcoute);
        textEcoute.isDisplayed();
    }

    public void eliminateCookiesAndChatbot() {
        WaitUntilElementVisible(btnCookies);
        btnCookies.click();
//        WaitUntilElementVisible(btnCloseChatbot);
//        btnCloseChatbot.click();
    }

    public void hover(String locator) throws Exception {
        locator = PropertiesReader.getValue(locator);
        System.out.println();
        System.out.println("POSITIONING ON THE ELEMENT : " + locator);
        WebElement element = SeleniumUtils.waitAndFindElement(getDriver(), SeleniumUtils.getLocatorByString(locator));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        System.out.println("Done Mouse hover on 'Permis de conduire'");

    }

}
