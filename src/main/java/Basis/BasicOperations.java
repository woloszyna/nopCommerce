package Basis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.security.Timestamp;
import java.util.Date;
import javax.imageio.ImageIO;

public class BasicOperations {

    public static WebDriver driver;

    public void OpenChromeFrontend() {
        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv80");
        //System.setProperty("webdriver.chrome.driver", "WebDrivers/Winchromedriverv81.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    public void OpenFirefoxFrontend() {
        System.setProperty("webdriver.firefox.driver", "WebDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    public void OpenChromeAdmin() {
        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv81");
        //System.setProperty("webdriver.chrome.driver", "WebDrivers/Winchromedriverv81.exe");
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/admin/");
        driver.manage().window().maximize();
    }

    public void OpenFirefoxAdmin() {
        System.setProperty("webdriver.firefox.driver", "WebDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://admin-demo.nopcommerce.com/admin/");
        driver.manage().window().maximize();
    }

    public void takeScreenshot(){
        {
            try {
                Thread.sleep(120);
                Robot r = new Robot();

                Date date = new Date();
                long timestamp = date.getTime();

                // It saves screenshot to desired path
                String path = "ScreenShots/screenshot"+timestamp+".jpg";

                // Used to get ScreenSize and capture image
                Rectangle capture =
                        new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage Image = r.createScreenCapture(capture);
                ImageIO.write(Image, "jpg", new File(path));
            }
            catch (AWTException | IOException | InterruptedException ex) {
                System.out.println(ex);
            }

        }
        System.out.println("Screenshot saved");
    }

    public void Close() {

        driver.close();
    }

}
