package structuredTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTest {
    /** open chrome browser, navigate to google.com, search for "selenium webdriver". **/
    /**
     * relative xpath
     * //tagName[@attibute='value']
     * //*[@attibute='value']
     * //tagName
     * //tagName[@attibute='value'][@attibute2='value2']
     * //tagName[@attibute3]
     */
    @Test
    public void searchForSelenium() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        By searchBox_Input = By.id("APjFqb");
        driver.findElement(searchBox_Input).sendKeys("Selenium WebDriver" + Keys.RETURN);

        driver.quit();
    }
}
