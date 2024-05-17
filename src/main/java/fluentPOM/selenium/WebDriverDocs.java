package fluentPOM.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverDocs {
    WebDriver driver;

    By pageTitle_Label = By.tagName("h1");

    public WebDriverDocs(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(pageTitle_Label).getText();
    }
}
