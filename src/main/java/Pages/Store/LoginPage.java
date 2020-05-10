package Pages.Store;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicOperations {

    public WebElement email = driver.findElement(By.className("email"));
    public WebElement password = driver.findElement(By.className("password"));
    public WebElement loginBtn = driver.findElement(By.className("login-button"));
    public String passwordType = driver.findElement(By.className("password")).getAttribute("type");


    public void openLoginPage() {

        LandingPage LandingPage = new LandingPage();
        LandingPage.loginIcon.click();
    }




}
