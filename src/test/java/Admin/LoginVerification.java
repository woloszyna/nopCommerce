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

    @Test
    public void fieldValidation() {

        LoginPage LoginPage = new LoginPage();

        Assert.assertEquals(LoginPage.emailType,"email");
        Assert.assertEquals(LoginPage.passwordType,"password");

    }

    @Test
    public void IncorrectLogin() {

        LoginPage LoginPage = new LoginPage();
        LoginPage.AdminLoginIncorrect();

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Login was unsuccessful"));
    }

    @Test
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

        BasicOperations.takeScreenshot();
        BasicOperations.Close();

    }
}
