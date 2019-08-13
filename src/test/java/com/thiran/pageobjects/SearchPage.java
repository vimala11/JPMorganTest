package com.thiran.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Common {
    @FindBy(css = "input[title='Search']")
    private WebElement googleSearchField;

    @FindBy(css = "input[class='b_searchbox']")
    private WebElement bingSearchField;

    @FindBy(css = "#search .srg .r")
    private List<WebElement> googleSearchResultList;

    @FindBy(css = "ol[id='b_results'] h2")
    private List<WebElement> bingSearchResultList;


    public boolean isNewsValid(String searchEngine) {
        List<WebElement> searchResultList = new ArrayList<>();
        if(searchEngine.equalsIgnoreCase("google")) {
            searchResultList = googleSearchResultList;
        }
        else if(searchEngine.equalsIgnoreCase("bing")) {
            searchResultList = bingSearchResultList;
        }
        waitForVisibilityOfElements(searchResultList);
        List<String> sourceList = getOtherSources(searchResultList);
        /* At the least 1 source other than guardian, proves the news has appeared in other news sources and hence considered valid */
        if (sourceList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private List<String> getOtherSources(List<WebElement> searchResultList) {
        List<String> resultSourceList = new ArrayList();
        for (WebElement googleSearchResult : searchResultList) {
            String sourceLink = googleSearchResult.findElement(By.cssSelector("a")).getAttribute("href");
            
            /* Results from other than theguardian.com are considered, to confirm that the news is not fake */ 
            if(!sourceLink.contains("theguardian.com")){
                resultSourceList.add(sourceLink);
            }
        }
        return resultSourceList;
    }

    public void search(String searchEngine) {
        WebElement searchField;
        if(searchEngine.equalsIgnoreCase("google")) {
            searchField = googleSearchField;
        } else if (searchEngine.equalsIgnoreCase("bing")){
            searchField = bingSearchField;
        }else {
            searchField = googleSearchField;
        }
        waitForVisibilityOfElement(searchField);
        searchField.click();
        searchField.sendKeys(getTestContext().get("newsArticleToSearch"));
        searchField.submit();
    }
}
