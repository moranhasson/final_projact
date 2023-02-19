package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SelectionPage;
import utils.WebDriverSingleton;

import java.nio.file.Paths;
import java.time.Duration;

public class BuyMeTest extends BaseTest {


    @Test
    public void registrationTest() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickOnLoginLink();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".text-link.theme"))).get(0).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[placeholder]"))).get(0).sendKeys("מורן");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[placeholder]"))).get(1).sendKeys("voicesound2007@gmail.com");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[placeholder]"))).get(2).sendKeys("Aa123456");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[placeholder]"))).get(3).sendKeys("Aa123456");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("svg circle"))).get(0).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[type=submit]"))).get(0).click();
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-error"))).getText();
        Assert.assertEquals(error, "דוא\"ל זה כבר קיים במערכת.");
    }

    @Test
    public void noMatchesFound() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("voicesound2007@gmail.com", "Orizivshir1");
        SelectionPage selectionPage = new SelectionPage(driver, wait);
        selectionPage.selectSum();
        selectionPage.selectRegion();
        selectionPage.selectCategory();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='איזו מתנה תרצו לחפש?']"))).sendKeys("פרחים");
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[value='17573218']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1199"))).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        Assert.assertEquals(WebDriverSingleton.getDriver().findElement(By.cssSelector("h1")).getText(), "לא נמצאו תוצאות חיפוש ל\"רוז פרחים\" במרכז בסכום עד 99 ש\"ח בקטגוריה מתנות למזל דלי");
    }




    @Test
    public void continueToSelectGift() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("voicesound2007@gmail.com", "Orizivshir1");
        SelectionPage selectionPage = new SelectionPage(driver, wait);
        selectionPage.selectSum();
        selectionPage.selectRegion();
        selectionPage.selectCategory();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1199"))).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".bm-subtitle-1"))).get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='הכנס סכום']"))).sendKeys("50");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[type=submit]"))).get(0).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"))).sendKeys("zohar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='לאיזה אירוע?']"))).click();
        Thread.sleep(Duration.ofSeconds(5).toMillis());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='10']"))).get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-parsley-group='voucher-greeting']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-parsley-group='voucher-greeting']"))).sendKeys("mazal tov");
        WebDriverSingleton.getDriver().findElement(By.cssSelector("input[name=logo]")).sendKeys(Paths.get(System.getProperty("user.dir")) + "\\src\\test\\resources\\zohar.jpeg");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=submit]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[gtm='עכשיו']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[gtm='method-sms']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='נייד מקבל/ת המתנה']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='נייד מקבל/ת המתנה']"))).sendKeys("0543130633");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[gtm='עכשיו']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='שם שולח המתנה']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='שם שולח המתנה']"))).sendKeys("moran");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='מספר נייד']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='מספר נייד']"))).sendKeys("0543130633");
        Thread.sleep(Duration.ofSeconds(5).toMillis());

    }
}
