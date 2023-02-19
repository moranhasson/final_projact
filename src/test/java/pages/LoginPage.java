package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".notSigned"))).click();
    }

    public void login(String email, String password) throws InterruptedException {
        clickOnLoginLink();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        WebDriverSingleton.getDriver().findElements(By.cssSelector("[placeholder]")).get(0).sendKeys(email);
        WebDriverSingleton.getDriver().findElements(By.cssSelector("[placeholder]")).get(1).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[type=submit]"))).get(0).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
    }
}
