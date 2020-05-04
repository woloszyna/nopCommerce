package Pages.Store;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResults extends BasicOperations {

    public WebElement prodSelectors = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]"));
    public WebElement searchResults = driver.findElement(By.className("search-results"));
    public WebElement oneProduct = driver.findElement(By.className("item-box"));
    public WebElement prodDetails = driver.findElement(By.className("details"));
    public String prodTitle = driver.findElement(By.className("product-title")).getText();
    public WebElement addToCart = driver.findElement(By.className("product-box-add-to-cart-button"));

    //Focuses on an element to display it in the screenshot
    public void focusOnProducts() {

        Actions actions = new Actions(driver);
        actions.moveToElement(prodDetails);
        actions.perform();
    }

}
