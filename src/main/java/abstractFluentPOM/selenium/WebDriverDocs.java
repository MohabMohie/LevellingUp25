package abstractFluentPOM.selenium;

import abstractFluentPOM.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverDocs extends Page {
    By pageTitle_Label = By.tagName("h1");

    public WebDriverDocs(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle_Label).getText();
    }
}
