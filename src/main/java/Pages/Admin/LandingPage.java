package Pages.Admin;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasicOperations {

    public WebElement AccInfo = driver.findElement(By.className("account-info"));
    public WebElement LogoutBtn = driver.findElement(By.linkText("Logout"));
    public String Operator = driver.findElement(By.className("account-info")).getText();

}
