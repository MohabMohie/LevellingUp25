package structuredTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * open firefox
 * navigate to google home
 * search for "selenium webdriver"
 * check that text for the first search result is "WebDriver"
 * open the first search result
 * check that page header is "WebDriver"
 */
public class GoogleSearchStructuredBrowserContextTest {
    WebDriver driver;
    BrowsingContext browsingContext;

    //    By firstSearchResult_Label = By.tagName("h3");
    Locator firstSearchResult = Locator.xpath("//*[@name='q']");

    @Test
    public void checkFirstSearchResultText() {
//        String firstSearchResultText = driver.findElement(firstSearchResult_Label).getText();
        String firstSearchResultText = browsingContext.locateElement(firstSearchResult).getText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
        browsingContext.locateElement(firstSearchResult).click();
//        By pageTitle_Label = By.tagName("h1");
//        String pageTitleText = driver.findElement(pageTitle_Label).getText();

        Locator pageTile = Locator.xpath("//h1");
        String pageTitleText = browsingContext.locateElement(pageTile).getText();

        Assert.assertEquals(pageTitleText, "WebDriver");
    }

    @BeforeSuite
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        options.setImplicitWaitTimeout(Duration.ofSeconds(60));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void before() {
        browsingContext = new BrowsingContext(driver, WindowType.TAB);

//        driver.get("https://www.google.com");
        browsingContext.navigate("https://www.google.com");

//        By search_Input = By.name("q");
//        driver.findElement(search_Input).sendKeys("selenium webdriver", Keys.RETURN);

        browsingContext.locateElement(firstSearchResult).sendKeys("selenium webdriver", Keys.RETURN);
    }

    @AfterMethod
    public void after() {
        browsingContext.close();
    }
}
