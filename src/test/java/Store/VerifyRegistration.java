package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.RegisterPage;
import Pages.Store.RegisterResult;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class VerifyRegistration extends BasicOperations {

    @BeforeMethod
    public void OpenChromeFrontend() {
        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv80");
        //System.setProperty("webdriver.chrome.driver", "WebDrivers/Winchromedriverv81.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openRegPage() {

        LandingPage LandingPage = new LandingPage();
        LandingPage.regIcon.click();

    }

    @Test
    public void CanCreateCorrectDetailsM() {

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.RegisterMale();

        RegisterResult RegisterResult = new RegisterResult();
        Assert.assertTrue(RegisterResult.result.isDisplayed());
        Assert.assertEquals(RegisterResult.resultText, "Your registration completed");

    }

    @Test
    public void CanCreateCorrectDetailsW() {

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.RegisterFemale();

        RegisterResult RegisterResult = new RegisterResult();
        Assert.assertTrue(RegisterResult.result.isDisplayed());
        Assert.assertEquals(RegisterResult.resultText, "Your registration completed");

    }

    @AfterMethod
    public void Close() {

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
        driver.quit();

    }

}
