package smokeTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddNewPlacePage;
import pages.SearchResultPage;
import static org.testng.Assert.assertEquals;

public class CreateNewPlaceAndSearchTest extends BaseTest {
    private String createNewPlaceTitle = "Kreiraj objekat";
    private String requiredInfoPaths [] = {"name", "city_name", "zip_code", "place_id", "house_number"};
    private String requiredInfoData [] = {"Utopija", "Zenica", "7200", "Fra Grge Martica", "15"};
    private String successMessage = "Objekat Utopija je uspješno kreiran.";
    private String placeName = "Utopija";

    AddNewPlacePage addNewPlacePage;
    SearchResultPage searchResultPage;

    @Test (priority = 0)
    public void clickAddNewPlace(){
        addNewPlacePage = homePage.clickAddNewPlace();
        assertEquals(addNewPlacePage.checkCreateNewPlaceTitle(), createNewPlaceTitle, "The title is not the same");
    }
    @Test (priority = 1)
    public void enterRequiredData() {
        for (int i = 0; i < requiredInfoData.length; i++) {
            addNewPlacePage.enterRequiredInfo(requiredInfoData[i], requiredInfoPaths[i]);
        }
    }
    @Test(priority = 2)
    public void clickCategory(){
            addNewPlacePage.clickCategory();
        }
    @Test(priority = 3)
    public void chooseCategory() {
        addNewPlacePage.chooseCategory("Hrana");
    }
    @Test(priority = 4)
    public void chooseSubcategory() {
        addNewPlacePage.chooseSubcategory("Brza hrana");
    }
    @Test (priority = 5)
    public void createNewPlace(){
        addNewPlacePage.clickCreate();
        assertEquals(addNewPlacePage.checkIfNewPlaceCreated(), successMessage, "The place is not created");
    }
    @Test (priority = 6)
    public void enterText(){

    }
    @Test(priority = 7)
    public void searchPlace(){
        homePage.enterText(placeName);
        searchResultPage = homePage.hitEnter();
        assertEquals(searchResultPage.getPlaceName(), placeName, "The names do not match");
    }
}
