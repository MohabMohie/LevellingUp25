package fluentPOM.google;

import fluentPOM.selenium.WebDriverDocs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Results {
    WebDriver driver;
    By firstSearchResult_Label = By.tagName("h3");

    public Results(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstSearchResultText() {
        return driver.findElement(firstSearchResult_Label).getText();
    }

    public WebDriverDocs clickFirstSearchResult() {
        driver.findElement(firstSearchResult_Label).click();
        return new WebDriverDocs(driver);
    }

    public void assertFirstSearchResultText(String webDriver) {
        Assert.assertEquals(getFirstSearchResultText(), "WebDriver");
    }
}
