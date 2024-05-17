package pom.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    WebDriver driver;
    By firstSearchResult_Label = By.tagName("h3");

    public Results(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstSearchResultText() {
        return driver.findElement(firstSearchResult_Label).getText();
    }

    public void clickFirstSearchResult() {
        driver.findElement(firstSearchResult_Label).click();
    }
}
