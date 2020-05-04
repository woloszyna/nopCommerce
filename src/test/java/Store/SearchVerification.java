package Store;

import Basis.BasicOperations;
import Pages.Store.LandingPage;
import Pages.Store.SearchResults;
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

    @Test
    public void SearchError() {

        LandingPage LandingPage = new LandingPage();

        LandingPage.SearchError();
        String error = driver.getPageSource();
        Assert.assertTrue(error.contains("No products were found that matched your criteria."));

    }

    @Test
    public void SearchFunctionality() {

        LandingPage LandingPage = new LandingPage();

        LandingPage.SearchFunctionality();

        SearchResults SearchResults = new SearchResults();

        SearchResults.focusOnProducts();

        Assert.assertTrue(SearchResults.prodSelectors.isDisplayed());
        Assert.assertTrue(SearchResults.searchResults.isDisplayed());
        Assert.assertTrue(SearchResults.oneProduct.isDisplayed());
        Assert.assertTrue(SearchResults.prodDetails.isDisplayed());
        Assert.assertEquals(SearchResults.prodTitle, LandingPage.Nikon);

    }

    @AfterTest
    public void Close() {

        {
            try {
                Thread.sleep(120);
                Robot r = new Robot();

                Date date = new Date();
                long timestamp = date.getTime();

                // It saves screenshot to desired path
                String path = "ScreenShots/screenshot"+timestamp+".jpg";

                // Used to get ScreenSize and capture image
                Rectangle capture =
                        new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage Image = r.createScreenCapture(capture);
                ImageIO.write(Image, "jpg", new File(path));
            }
            catch (AWTException | IOException | InterruptedException ex) {
                System.out.println(ex);
            }

        }
        System.out.println("Screenshot saved");

        driver.quit();

    }

}
