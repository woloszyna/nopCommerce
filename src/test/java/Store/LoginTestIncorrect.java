package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.LoginPage;
import Pages.Store.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LoginTestIncorrect extends BasicOperations {

    @BeforeMethod
    public void OpenChromeFrontend() {
        System.setProperty("webdriver.chrome.driver", "WebDrivers/chromedriverv80");
        //System.setProperty("webdriver.chrome.driver", "WebDrivers/Winchromedriverv81.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void RegisterIncorrect() {

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.RegisterIncorrect();

    }

    @BeforeMethod
    public void openLoginPage() {

        LandingPage LandingPage = new LandingPage();
        LandingPage.loginIcon.click();

    }

    /*
   WORK HERE

    @Test
    public void loginIncorrectDet() {

        LoginPage LoginPage = new LoginPage();
        RegisterPage RegisterPage = new RegisterPage();

        LoginPage.email.sendKeys(RegisterPage.emailaddress);
        LoginPage.password.sendKeys(RegisterPage.uniqueString+"");
        LoginPage.loginBtn.click();

    }

     */

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
