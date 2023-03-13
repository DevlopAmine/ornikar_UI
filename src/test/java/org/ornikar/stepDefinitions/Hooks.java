package org.ornikar.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.ornikar.utilities.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    private final Logger log = LoggerFactory.getLogger(Hooks.class);


    @Before
    public void openBrowser() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/org/ornikar/config/chromedriver.exe");

        driver = new ChromeDriver();
        PropertiesReader propertiesReader = new PropertiesReader();
        driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(PropertiesReader.getValue("url"));
    }

    @After
    public void embedScreenshot(Scenario scenario) {

        if ((scenario.getStatus() == Status.FAILED)) {
            try {
                //conversion du driver en objet TakesScreenShot pour pouvoir effectuer une capture d'ecran
                TakesScreenshot ts = ((TakesScreenshot) driver);
                //recuperation de la date du jour au format "yyyy_MM_dd__hh_mm_ss" et stockage dans la variable timestamp
                String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                //recuperation du nom du scenario et stockage dans la variable featureName
                String featureName = scenario.getName();
                //Description de la source et du type du fichier screenshot qui sera enregistre
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Enregistre le screenshot dans le chemin voulu
                File f = new File("target/screenshots/" + timestamp + "_" + featureName + ".png");
                f.getParentFile().mkdirs();
                FileHandler.copy(source, f);

                System.out.println("Screenshot saved : " + f.getPath());
            } catch (Exception e) {

                System.out.println("Screenshot failed : " + e.getMessage());

            }
        }
        System.out.println("quiting driver ");
        driver.quit();
    }

}