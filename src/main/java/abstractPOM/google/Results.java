package abstractPOM.google;

import abstractPOM.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results extends Page {
    By firstSearchResult_Label = By.tagName("h3");

    public Results(WebDriver driver) {
        super(driver);
    }

    public String getFirstSearchResultText() {
        return driver.findElement(firstSearchResult_Label).getText();
    }

    public void clickFirstSearchResult() {
        driver.findElement(firstSearchResult_Label).click();
    }
}
