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
    public void uiValidationEmail() {

        LoginPage LoginPage = new LoginPage();
        Assert.assertEquals(LoginPage.loginFieldColor, "rgba(255, 255, 255, 1)");
        Assert.assertEquals(LoginPage.loginFieldWidth,"360px");
        Assert.assertEquals(LoginPage.loginFieldHeight,"40px");
        Assert.assertEquals(LoginPage.loginFieldFont,"14px");
        Assert.assertEquals(LoginPage.emailType,"email");

    }

    @Test
    public void uiValidationPassword() {

        LoginPage LoginPage = new LoginPage();
        Assert.assertEquals(LoginPage.passwordFieldColor, "rgba(255, 255, 255, 1)");
        Assert.assertEquals(LoginPage.passwordFieldWidth,"360px");
        Assert.assertEquals(LoginPage.passwordFieldHeight,"40px");
        Assert.assertEquals(LoginPage.passwordFieldFont,"14px");
        Assert.assertEquals(LoginPage.passwordType,"password");
    }

    @Test
    public void uiValidationLoginButton() {

        LoginPage LoginPage = new LoginPage();
        Assert.assertEquals(LoginPage.loginBtnColor,"rgba(74, 178, 241, 1)");
        Assert.assertEquals(LoginPage.loginBtnWidth,"140px");
        Assert.assertEquals(LoginPage.loginBtnHeight,"37px");
        Assert.assertEquals(LoginPage.loginBtnFont,"15px");

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
