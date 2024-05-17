package modularTests;

import abstractFluentPOM.google.Search;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoogleSearchPOMAbstractFluentTest extends TestCase {

    @Test
    public void checkFirstSearchResultText() {
        String firstSearchResultText = new Search(driver).navigate().search("selenium webdriver")
                .getFirstSearchResultText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
        String pageTitleText = new Search(driver).navigate().search("selenium webdriver")
                .clickFirstSearchResult()
                .getTitle();
        Assert.assertEquals(pageTitleText, "WebDriver");
    }
}
