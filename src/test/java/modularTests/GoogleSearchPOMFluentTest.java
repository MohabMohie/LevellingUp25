package modularTests;

import fluentPOM.google.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class GoogleSearchPOMFluentTest {
    WebDriver driver;

    @Test
    public void checkFirstSearchResultText() {
        String firstSearchResultText = new Search(driver).navigate()
                .search("selenium webdriver")
                .getFirstSearchResultText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
//        new Search(driver).navigate()
//                .search("selenium webdriver")
//                .assertFirstSearchResultText("WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
//        searchPage.navigate();
//        searchPage.search("selenium webdriver");
//        resultsPage.clickFirstSearchResult();
//        String pageTitleText = docsPage.getTitle();
//        Assert.assertEquals(pageTitleText, "WebDriver");

        String pageTitleText = new Search(driver).navigate()
                .search("selenium webdriver")
                .clickFirstSearchResult()
                .getTitle();
        Assert.assertEquals(pageTitleText, "WebDriver");
    }

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
