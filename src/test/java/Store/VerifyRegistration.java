package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.LoginPage;
import Pages.Store.RegisterPage;
import Pages.Store.RegisterResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    BasicOperations BasicOperations = new BasicOperations();

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

    @Test
    public void CannotCreateMissingDetails() {

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.RegisterIncorrect();

        WebElement fNameMissing = driver.findElement(By.className("field-validation-error"));
        String fNameError = driver.findElement(By.className("field-validation-error")).getText();

        Assert.assertTrue(fNameMissing.isDisplayed());
        Assert.assertEquals(fNameError,"First name is required.");

    }

    @AfterMethod
    public void Close() {

        BasicOperations.Close();

    }

}
