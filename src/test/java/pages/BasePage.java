package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
}
