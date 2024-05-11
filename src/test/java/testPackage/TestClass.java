package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;

    @Test
    public void testMethod() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        driver.manage().window().maximize();
        String title;
        title = "dummy";
        title = driver.getTitle();
        driver.quit();
    }
}
