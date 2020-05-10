package Pages.Admin;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicOperations {

    public String adminLogin = "admin@yourstore.com";
    public String adminPassword = "admin";
    public String wrongPassword = "wrongpassword";

    //Elements
    public WebElement loginField = driver.findElement(By.id("Email"));
    public WebElement passwordField = driver.findElement(By.id("Password"));
    public WebElement loginBtn = driver.findElement(By.className("login-button"));


    //Attributes
    public String emailType = driver.findElement(By.id("Email")).getAttribute("type");
    public String passwordType = driver.findElement(By.id("Password")).getAttribute("type");

    public void AdminLoginCorrect(){

        loginField.clear();
        loginField.sendKeys(adminLogin);
        passwordField.clear();
        passwordField.sendKeys(adminPassword);
        loginBtn.click();

    }

    public void AdminLoginIncorrect(){

        loginField.clear();
        loginField.sendKeys(adminLogin);
        passwordField.clear();
        passwordField.sendKeys(wrongPassword);
        loginBtn.click();

    }

}
