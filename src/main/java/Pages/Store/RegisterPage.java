package Pages.Store;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;

public class RegisterPage extends BasicOperations {

    //Details
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public long uniqueString = timestamp.getTime();
    public String emailaddress = uniqueString+"@email.com";

    //Your Personal Details Form
    public WebElement genM = driver.findElement(By.id("gender-male"));
    public WebElement genW = driver.findElement(By.id("gender-female"));
    public WebElement fName = driver.findElement(By.id("FirstName"));
    public WebElement lName = driver.findElement(By.id("LastName"));
    public WebElement DOBD = driver.findElement(By.name("DateOfBirthDay"));
    public WebElement DOBM = driver.findElement(By.name("DateOfBirthMonth"));
    public WebElement DOBY = driver.findElement(By.name("DateOfBirthYear"));
    public WebElement email = driver.findElement(By.id("Email"));
    public WebElement loginIcon = driver.findElement(By.className("ico-login"));

    //Company Details Form
    public WebElement coName = driver.findElement(By.id("Company"));

    //Options Form
    public WebElement newsletter = driver.findElement(By.id("Newsletter"));

    //Yor Password Form
    public WebElement password = driver.findElement(By.id("Password"));
    public WebElement confPassword = driver.findElement(By.id("ConfirmPassword"));

    //Register button
    public WebElement regBtn = driver.findElement(By.id("register-button"));

    public void openRegPage() {

        LandingPage LandingPage = new LandingPage();
        LandingPage.regIcon.click();

    }

    public void RegisterMale() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genM.click();
        fName.sendKeys("First"+uniqueString);
        lName.sendKeys("Last"+uniqueString);
        DOBD.sendKeys("20");
        DOBM.sendKeys("January");
        DOBY.sendKeys("2000");
        email.sendKeys(emailaddress);

        coName.sendKeys("Company "+uniqueString);

        newsletter.click();
        newsletter.click();

        password.sendKeys(uniqueString+"");
        confPassword.sendKeys(uniqueString+"");

        regBtn.click();
    }

    public void RegisterFemale() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genW.click();
        fName.sendKeys("First"+uniqueString);
        lName.sendKeys("Last"+uniqueString);
        DOBD.sendKeys("20");
        DOBM.sendKeys("January");
        DOBY.sendKeys("2000");
        email.sendKeys(emailaddress);

        coName.sendKeys("Company "+uniqueString);
        newsletter.click();
        newsletter.click();

        password.sendKeys(uniqueString+"");
        confPassword.sendKeys(uniqueString+"");

        regBtn.click();
    }

    public void RegisterIncorrect() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genM.click();
        lName.sendKeys("Last"+uniqueString);
        DOBD.sendKeys("20");
        DOBM.sendKeys("January");
        DOBY.sendKeys("2000");
        email.sendKeys(emailaddress);

        coName.sendKeys("Company "+uniqueString);
        newsletter.click();
        newsletter.click();

        password.sendKeys(uniqueString+"");
        confPassword.sendKeys(uniqueString+"");

        regBtn.click();
    }

    public void loginIncorrectDetails() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genM.click();
        lName.sendKeys("Last"+uniqueString);
        DOBD.sendKeys("20");
        DOBM.sendKeys("January");
        DOBY.sendKeys("2000");
        email.sendKeys(emailaddress);

        coName.sendKeys("Company "+uniqueString);
        newsletter.click();
        newsletter.click();

        password.sendKeys(uniqueString+"");
        confPassword.sendKeys(uniqueString+"");

        regBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginIcon.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement email = driver.findElement(By.className("email"));
        WebElement password = driver.findElement(By.className("password"));
        String passwordType = driver.findElement(By.className("password")).getAttribute("Type");
        WebElement loginBtn = driver.findElement(By.className("login-button"));

        email.sendKeys(emailaddress);
        password.sendKeys(uniqueString+"");
        loginBtn.click();

    }

    public void loginCorrectDetails() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        genW.click();
        fName.sendKeys("First"+uniqueString);
        lName.sendKeys("Last"+uniqueString);
        DOBD.sendKeys("20");
        DOBM.sendKeys("January");
        DOBY.sendKeys("2000");
        email.sendKeys(emailaddress);

        coName.sendKeys("Company "+uniqueString);
        newsletter.click();
        newsletter.click();

        password.sendKeys(uniqueString+"");
        confPassword.sendKeys(uniqueString+"");

        regBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logout = driver.findElement(By.className("ico-logout"));
        logout.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement loginIcon =  driver.findElement(By.className("ico-login"));
        loginIcon.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement email = driver.findElement(By.className("email"));
        WebElement password = driver.findElement(By.className("password"));
        WebElement loginBtn = driver.findElement(By.className("login-button"));

        email.sendKeys(emailaddress);
        password.sendKeys(uniqueString+"");
        loginBtn.click();

    }

}
