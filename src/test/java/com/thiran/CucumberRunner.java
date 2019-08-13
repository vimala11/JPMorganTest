package com.thiran;

import com.thiran.utilities.Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Author Vimala P.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
                 format ={"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
                 features ="src/test/resources/features/newsValidation.feature",
                 glue = {"com.thiran.utilities",
                         "com.thiran.stepdefinitions"})

public class CucumberRunner extends Setup {

}









