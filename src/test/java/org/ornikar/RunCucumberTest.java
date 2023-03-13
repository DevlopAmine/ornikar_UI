package org.ornikar;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/org/ornikar/features",
        glue = "org.ornikar.stepDefinitions",
        plugin = {
                "pretty",
                "html:target/report.html",
        },
        tags = ""
)
public class RunCucumberTest {
}


