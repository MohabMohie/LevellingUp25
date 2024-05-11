package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdvancedElementIdentificationTests {
    WebDriver driver;

    @Test
    public void testMethod() {
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        By contactPerson_Label = By.xpath("//td[text()='Ernst Handel']/following-sibling::td[1]");
        //tr[contains(., 'Ernst Handel')]/td[2]
        String contactPersonName = driver.findElement(contactPerson_Label).getText();
        Assert.assertEquals(contactPersonName, "Roland Mendel");
    }

    @Test(enabled = false)
    public void relativeLocators() {
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        By contactPerson_Label = RelativeLocator.with(By.tagName("td"))
                .below(By.xpath("//th[text()='Contact']"))
                .toRightOf(By.xpath("//td[text()='Ernst Handel']"));
        String contactPersonName = driver.findElement(contactPerson_Label).getText();
        Assert.assertEquals(contactPersonName, "Roland Mendel");
    }

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
