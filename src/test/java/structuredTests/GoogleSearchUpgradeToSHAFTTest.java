package structuredTests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleSearchUpgradeToSHAFTTest {
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
        SHAFT.GUI.WebDriver shaftDriver = new SHAFT.GUI.WebDriver();
        WebDriver driver = shaftDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        By search_Input = By.name("q");
        driver.findElement(search_Input).sendKeys("selenium webdriver", Keys.RETURN);
        By firstSearchResult_Label = By.tagName("h3");
        shaftDriver.element().assertThat(firstSearchResult_Label).text().contains("WebDriver");
        driver.findElement(firstSearchResult_Label).click();
        By pageTitle_Label = By.tagName("h1");
        shaftDriver.element().assertThat(pageTitle_Label).text().isEqualTo("WebDriver");
        driver.quit();
    }
}
