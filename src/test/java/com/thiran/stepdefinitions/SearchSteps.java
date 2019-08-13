package com.thiran.stepdefinitions;

import com.thiran.pageobjects.SearchPage;
import com.thiran.utilities.DriverFactory;
import com.thiran.utilities.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps extends DriverFactory{
    TestContext testContext  = TestContext.getInstance();
    SearchPage searchPage = PageFactory.initElements(DriverFactory.driver, SearchPage.class);
    final static Logger log = Logger.getLogger(SearchSteps.class);

    @When("^user looks for the article title in \"([^\"]*)\"$")
    public void userLooksForTheArticleTitleIn(String searchEngine) {
        if ("google".equals(searchEngine.toLowerCase())) {
            driver.get(testContext.readproperty("googleURL"));
        } else if ("bing".equals(searchEngine.toLowerCase())) {
            driver.get(testContext.readproperty("bingURL"));
        } else {
            driver.get(testContext.readproperty("googleURL"));
        }
        searchPage.search(searchEngine);
    }

    @Then("^user (should|should not) see valid articles from different sources in \"([^\"]*)\"$")
    public void userSeeValidArticlesFromDifferentSources(String mode, String searchEngine) {
        log.info("Checking Validity of the news article...");
        if(mode.equalsIgnoreCase("should")) {
            assertThat("The News article does not seem to be Valid",searchPage.isNewsValid(searchEngine), Matchers.is(true));
        } else {
            assertThat("The News article seem to be Valid",searchPage.isNewsValid(searchEngine), Matchers.is(false));
        }
    }
}
