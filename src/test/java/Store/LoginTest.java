package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.LoginPage;
import Pages.Store.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class LoginTest extends BasicOperations {

    BasicOperations BasicOperations = new BasicOperations();

    @BeforeMethod
    public void openChromeFrontend() {
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
    public void loginIncorrectDetails(){

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.loginIncorrectDetails();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement loginError = driver.findElement(By.className("message-error"));
        String errorMsg = driver.findElement(By.className("message-error")).getText();


        Assert.assertTrue(loginError.isDisplayed());
        Assert.assertEquals(errorMsg, "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Test
    public void loginCorrectDetails() {

        RegisterPage RegisterPage = new RegisterPage();
        RegisterPage.loginCorrectDetails();

        WebElement logout = driver.findElement(By.className("ico-logout"));
        Assert.assertTrue(logout.isDisplayed());

    }

    @AfterTest
    public void Close() {

        BasicOperations.Close();

    }

}

