package com.thiran.stepdefinitions;



import com.thiran.pageobjects.GuardianNewsPage;
import com.thiran.utilities.DriverFactory;
import com.thiran.utilities.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class GuardianPageSteps {
    final static Logger log = Logger.getLogger(GuardianPageSteps.class);
    TestContext testContext  = TestContext.getInstance();
    private String url = testContext.readproperty("url") ;

    GuardianNewsPage newsPage = PageFactory.initElements(DriverFactory.driver, GuardianNewsPage.class);

    @Given("^user opens the guardian page$")
    public void userOpensTheGuardianPage() {
        log.info("Opening Guardian News Page");
        DriverFactory.driver.get(url);
    }

    @And("^saves the title of news article displayed in position \"([^\"]*)\"$")
    public void savesTheTitleOfNewsArticleDisplayedInPosition(int newsArticleNumber) {
        newsPage.saveTitleOfNews(newsArticleNumber);
    }

}
