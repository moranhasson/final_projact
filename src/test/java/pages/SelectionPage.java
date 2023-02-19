package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectionPage extends BasePage {
    public SelectionPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectSum() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[alt='סכום']"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='1']"))).get(1).click();
    }

    public void selectRegion() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[alt='אזור']"))).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='11']"))).get(1).click();
    }

    public void selectCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[alt='קטגוריה']"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='358']"))).get(1).click();
    }
}
