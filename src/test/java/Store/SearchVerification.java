package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.SearchResults;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class SearchVerification extends BasicOperations {

    BasicOperations BasicOperations = new BasicOperations();


    @BeforeMethod
    public void OpenChromeFrontend() {

        BasicOperations.OpenChromeFrontend();

    }

    @Test (priority = 1)
    public void SearchError() {

        LandingPage LandingPage = new LandingPage();

        LandingPage.SearchError();
        String error = driver.getPageSource();
        Assert.assertTrue(error.contains("No products were found that matched your criteria."));

    }

    @Test  (priority = 2)
    public void SearchFunctionality() {

        LandingPage LandingPage = new LandingPage();
        LandingPage.SearchFunctionality();

        SearchResults SearchResults = new SearchResults();
        SearchResults.focusOnProducts();

        String prodTitle = SearchResults.prodTitle;
        String Nikon = LandingPage.Nikon;

        Assert.assertTrue(SearchResults.prodSelectors.isDisplayed());
        Assert.assertTrue(SearchResults.searchResults.isDisplayed());
        Assert.assertTrue(SearchResults.oneProduct.isDisplayed());
        Assert.assertTrue(SearchResults.prodDetails.isDisplayed());
        Assert.assertEquals(prodTitle, Nikon);

    }

    @AfterTest
    public void Close() {

      BasicOperations.Close();
    }

}
