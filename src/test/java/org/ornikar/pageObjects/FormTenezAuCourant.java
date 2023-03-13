package org.ornikar.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.utilities.BaseClass;

public class FormTenezAuCourant extends BaseClass {


    @FindBy(xpath = "//span[text()='Oui tenez-moi au courant']/ancestor::div[@aria-hidden='true']")
    @CacheLookup
    private WebElement btnTenezMoiAuCourant;


    public FormTenezAuCourant(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

}
