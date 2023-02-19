package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverSingleton;

import java.nio.file.Paths;
import java.time.Duration;

import static utils.XmlReader.getElementValueFromXML;

public abstract class BaseTest  implements ITestListener {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        wait = new WebDriverWait(WebDriverSingleton.getDriver(), Duration.ofSeconds(20));
        WebDriverSingleton.getDriver().navigate().to(getElementValueFromXML(Paths.get(System.getProperty("user.dir")) + "\\src\\test\\resources\\data.xml", "baseurl"));
        WebDriverSingleton.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverSingleton.getDriver().quit();

    }
}
