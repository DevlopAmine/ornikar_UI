package org.ornikar.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.utilities.BaseClass;

public class ConnexionPage extends BaseClass {

    @FindBy(css = "input[id=\"insurance-form-radio-button-education\"]")
    @CacheLookup
    private WebElement textMeConnecter;
    @FindBy(css = "input[name=\"email\"]")
    @CacheLookup
    private WebElement inputEmail;
    @FindBy(css = "input[name=\"password\"]")
    @CacheLookup
    private WebElement inputPwd;
    @FindBy(css = "button[type=\"submit\"]")
    @CacheLookup
    private WebElement btnSubmit;

    public ConnexionPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void apparitionModal(WebDriver driver) throws Exception {
        //waitAndFindElement(driver,textMeConnecter);
        textMeConnecter.isDisplayed();
    }

    public void saisiDesIdentifsEtEnvoi(String email, String pwd) {
        inputEmail.sendKeys(email);
        inputPwd.sendKeys(pwd);
        btnSubmit.click();
    }

}
