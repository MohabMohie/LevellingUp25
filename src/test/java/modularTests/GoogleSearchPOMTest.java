package modularTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.google.Results;
import pom.google.Search;
import pom.selenium.WebDriverDocs;

import java.time.Duration;


public class GoogleSearchPOMTest {
    WebDriver driver;

    Search searchPage;
    Results resultsPage;
    WebDriverDocs docsPage;

    @Test
    public void checkFirstSearchResultText() {
        searchPage.navigate();
        searchPage.search("selenium webdriver");
        String firstSearchResultText = resultsPage.getFirstSearchResultText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
        searchPage.navigate();
        searchPage.search("selenium webdriver");
        resultsPage.clickFirstSearchResult();
        String pageTitleText = docsPage.getTitle();
        Assert.assertEquals(pageTitleText, "WebDriver");
    }

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        searchPage = new Search(driver);
        resultsPage = new Results(driver);
        docsPage = new WebDriverDocs(driver);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
