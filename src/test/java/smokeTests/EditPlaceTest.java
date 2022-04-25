package smokeTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.SearchResultPage;
import static org.testng.Assert.assertEquals;

public class EditPlaceTest extends BaseTest {
    private String placeName = "hostel city center";
    private String placeSelected = "Motel Hanovi";
    private String requiredInfoPaths [] = {"name", "zip_code", "house_number"};
    private String requiredInfoData [] = {"Hanovi", "7230", "15"};
    private String message = "Vaše izmjene su zabilježene";

    SearchResultPage searchResultPage;
    EditPage editPage;

    @Test(priority = 0)
    public void clickAccommodation(){
        searchResultPage = homePage.clickAccommodation();
        assertEquals(searchResultPage.checkPlaceName(), placeName, "Names do not match");
    }
    @Test(priority = 1)
    public void clickOnPlace(){
        editPage = searchResultPage.clickPlaceOnList();
        assertEquals(editPage.checkPlaceName(), placeSelected, "Names do not match");
    }
    @Test(priority = 2)
    public void clickSuggestChange() {
        editPage.clickSuggestChange();
    }
    @Test(priority = 3)
    public void enterRequiredData(){
        for (int i = 0; i < requiredInfoData.length; i++){
            editPage.editRequiredInfo(requiredInfoData[i], requiredInfoPaths[i]);
        }
    }
    @Test(priority = 4)
    public void suggestPlaceChange(){
        editPage.clickConfirmSuggestChange();
        assertEquals(editPage.checkIfSuggestionAccepted(), message, "Changes are not complete");
    }
}
