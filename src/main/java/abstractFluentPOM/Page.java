package abstractFluentPOM;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
