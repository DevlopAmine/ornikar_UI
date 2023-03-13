package org.ornikar.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ornikar.pageObjects.AssurancePage;
import org.ornikar.pageObjects.ConnexionPage;
import org.ornikar.pageObjects.GarantiePage;
import org.ornikar.utilities.PropertiesReader;

import static org.ornikar.stepDefinitions.BaseSteps.jAttendsSecondes;

public class AssuranceAutoSteps {

    private final WebDriver driver = Hooks.driver;
    private final WebDriverWait wait;

    private AssurancePage assurancePage;
    private ConnexionPage connexionPage;

    public AssuranceAutoSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }


    @Given("Je suis sur la page assurance-auto")
    public void jeSuisSurLaPageAssuranceAuto() {
        assurancePage = new AssurancePage(driver, wait);
        assurancePage.verifyAssuranceTxtAndPresenceOfBtn();
    }

    @When("Je verifie la presence des 3 bonnes raisons")
    public void jeVerifieLaPresenceDesBonnesRaisons() throws InterruptedException {
        assurancePage = new AssurancePage(driver, wait);
        assurancePage.verify3BonnesRaisons();
    }

    @When("Je verifie la presence des garanties indispensables")
    public void jeVerifieLaPresenceDesGarantiesIndispensables() throws InterruptedException {
        GarantiePage garantiePage = new GarantiePage(driver, wait);
        garantiePage.assertGaranties();
    }

    @And("Je verifie la presence du modal Je me connecte à")
    public void jeVerifieLaPresenceDuModalJeMeConnecteÀ() throws Exception {
        connexionPage = new ConnexionPage(driver, wait);
        connexionPage.apparitionModal(driver);
    }

    @And("Je saisis les identifiants {word},{word} et je soumets")
    public void jeSaisisLesIdentifiantsEtJeSoumets(String email, String pwd) {
        connexionPage = new ConnexionPage(driver, wait);
        connexionPage.saisiDesIdentifsEtEnvoi(email, pwd);

    }

    @When("Je me positionne sur l element {string}")
    public void jeMePositionneSurLElement(String locator) throws Exception {
        assurancePage = new AssurancePage(driver, wait);
        assurancePage.hover(locator);
        jAttendsSecondes(2);


    }
}
