package structuredTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {
    /**
     * open chrome
     * navigate to google home
     * search for "selenium webdriver"
     * check that text for the first search result is "WebDriver"
     * open the first search result
     * check that page header is "WebDriver"
     * make it run on firefox
     */
    @Test
    public void testGoogleSearch() {
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        By search_Input = By.name("q");
        driver.findElement(search_Input).sendKeys("selenium webdriver", Keys.RETURN);

        By firstSearchResult_Label = By.tagName("h3");

        Wait<WebDriver> wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait = new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(30))
//                        .pollingEvery(Duration.ofMillis(200))
//                        .ignoring(NotFoundException.class)
//                        .ignoring(AssertionError.class)
//                        .ignoring(StaleElementReferenceException.class)
//                        .ignoring(ElementNotInteractableException.class);
//        wait.until(d -> driver.findElement(firstSearchResult_Label).isDisplayed());
        wait.until(d -> {
            String firstSearchResultText = driver.findElement(firstSearchResult_Label).getText();
            Assert.assertEquals(firstSearchResultText, "WebDriver");
            return true;
        });

        driver.findElement(firstSearchResult_Label).click();
        By pageTitle_Label = By.tagName("h1");
        String pageTitleText = driver.findElement(pageTitle_Label).getText();
        Assert.assertEquals(pageTitleText, "WebDriver");

        driver.quit();
    }
}
