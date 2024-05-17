package abstractPOM.google;

import abstractPOM.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Search extends Page {
    By search_Input = By.name("q");

    public Search(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.navigate().to("http://google.com");
    }

    public void search(String text) {
        driver.findElement(search_Input).sendKeys(text, Keys.RETURN);
    }
}
