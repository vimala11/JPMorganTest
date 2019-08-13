package com.thiran.pageobjects;


import com.thiran.stepdefinitions.GuardianPageSteps;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Author Vimala P.
 */


public class GuardianNewsPage extends Common{

    @FindBy(css =".index-page[data-link-name] .l-row--cols-3 li .fc-item__headline")
    private List<WebElement> topNewsTitles;

    final static Logger log = Logger.getLogger(GuardianNewsPage.class);

    public void saveTitleOfNews(int newsArticleNumber) {
        getTestContext().put("newsArticleToSearch", topNewsTitles.get(newsArticleNumber-1).getText());

    }
}
