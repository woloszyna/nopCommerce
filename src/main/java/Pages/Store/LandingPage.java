package Pages.Store;

import Basis.BasicOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage  extends BasicOperations {

    public String NoProduct = "I do not Exist";
    public String Nikon = "Nikon D5500 DSLR";

    public WebElement searchBar = driver.findElement(By.className("search-box-text"));
    public WebElement regIcon = driver.findElement(By.className("ico-register"));

    public void SearchError() {

        searchBar.clear();
        searchBar.sendKeys(NoProduct);
        searchBar.submit();

    }

    public void SearchFunctionality() {

        searchBar.clear();
        searchBar.sendKeys(Nikon);
        searchBar.submit();
    }

}
