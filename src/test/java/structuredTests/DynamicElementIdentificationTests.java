package structuredTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicElementIdentificationTests {
    WebDriver driver;

    @Test
    public void testMethod() {
        String contactPersonName = readContactPersonName("Ernst Handel");
        Assert.assertEquals(contactPersonName, "Roland Mendel");
    }

    @Test
    public void testMethodIslandTrading() {
        String contactPersonName = readContactPersonName("Island Trading");
        Assert.assertEquals(contactPersonName, "Helen Bennett");
    }

    private String readContactPersonName(String companyName) {
        By contactPerson_Label = By.xpath("//td[text()='" + companyName + "']/following-sibling::td[1]");
        return driver.findElement(contactPerson_Label).getText();
    }

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
