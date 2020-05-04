package Pages.Store;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterResult extends BasicOperations {

    public WebElement result = driver.findElement(By.className("result"));
    public String resultText = driver.findElement(By.className("result")).getText();
}
