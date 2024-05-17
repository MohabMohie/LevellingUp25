package modularTests;

import abstractPOM.google.Results;
import abstractPOM.google.Search;
import abstractPOM.selenium.WebDriverDocs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleSearchPOMAbstractTest extends TestCase {
    Search searchPage;
    Results resultsPage;
    WebDriverDocs docsPage;

    @Test
    public void checkFirstSearchResultText() {
        String firstSearchResultText = resultsPage.getFirstSearchResultText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
        resultsPage.clickFirstSearchResult();
        String pageTitleText = docsPage.getTitle();
        Assert.assertEquals(pageTitleText, "WebDriver");
    }

    @BeforeMethod
    public void navigateAndSearch() {
        searchPage = new Search(driver);
        resultsPage = new Results(driver);
        docsPage = new WebDriverDocs(driver);

        searchPage.navigate();
        searchPage.search("selenium webdriver");
    }
}
