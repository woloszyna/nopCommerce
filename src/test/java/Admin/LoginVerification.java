package Admin;

import Basis.BasicOperations;
import Pages.Admin.LandingPage;
import Pages.Admin.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LoginVerification extends BasicOperations {

    BasicOperations BasicOperations = new BasicOperations();

    @BeforeMethod
    public void StoreChrome() {

        BasicOperations.OpenChromeAdmin();

    }

    @Test (priority = 0)
    public void IncorrectLogin() {

        LoginPage LoginPage = new LoginPage();

        LoginPage.AdminLoginIncorrect();

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Login was unsuccessful"));
    }

    @Test (priority = 1)
    public void CorrectLogin() {

        LoginPage LoginPage = new LoginPage();

        LoginPage.AdminLoginCorrect();

        LandingPage LandingPage = new LandingPage();

        Assert.assertTrue(LandingPage.AccInfo.isDisplayed());
        Assert.assertTrue(LandingPage.LogoutBtn.isDisplayed());
        Assert.assertEquals(LandingPage.Operator, "John Smith");
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
