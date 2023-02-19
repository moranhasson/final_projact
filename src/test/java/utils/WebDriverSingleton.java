package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Paths;

import static utils.XmlReader.getElementValueFromXML;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
           String browser = getElementValueFromXML(Paths.get(System.getProperty("user.dir")) + "\\src\\test\\resources\\data.xml", "browser");
            switch (browser) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> throw new RuntimeException("unknown browser " + browser);
            }
        }
        return driver;
    }
}