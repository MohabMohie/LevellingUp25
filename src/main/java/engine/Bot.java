package engine;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.atomic.AtomicReference;

public class Bot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public Bot(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step
    public void click(By locator) {
        wait.until(d -> {
            driver.findElement(locator).click();
            return true;
        });
    }

    @Step
    public String getText(By locator) {
        AtomicReference<String> text = new AtomicReference<>("");
        wait.until(d -> {
            text.set(driver.findElement(locator).getText());
            return true;
        });
        return text.get();
    }

    /**
     * Type something into an input field. WebDriver doesn't normally clear these
     * before typing, so this method does that first. It also sends a return key
     * to move the focus out of the element.
     */
    @Step
    public void type(By locator, String text) {
        wait.until(d -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text + "\n");
            return true;
        });
    }
}
