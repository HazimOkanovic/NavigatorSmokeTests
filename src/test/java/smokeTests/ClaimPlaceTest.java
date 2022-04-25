package smokeTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EditPage;
import pages.SearchResultPage;
import static org.testng.Assert.assertEquals;

public class ClaimPlaceTest extends BaseTest {
    private String placeName = "Krka";
    private String requiredInfoPaths [] = {"name", "email", "phone"};
    private String requiredInfoData [] = {"Hazim OK", "hazimokan@gmail.com", "062061063"};
    private String claimAccepted = "Vaši podaci su primljeni. Uskoro ćemo Vas kontaktirati";

    SearchResultPage searchResultPage;
    EditPage editPage;

    @Test (priority = 0)
    public void navigateToSportSection(){
        searchResultPage = homePage.clickSport();
        assertEquals(searchResultPage.checkSportName(), placeName, "Place names do not match");
    }
    @Test (priority = 1)
    public void clickOnPlace(){
        editPage = searchResultPage.clickSportOnList();
        assertEquals(editPage.checkPlaceName(), placeName, "Names do not match");
    }
    @Test(priority = 2)
    public void enterRequiredInfo() {
        editPage.clickClaim();
        for (int i = 0; i < requiredInfoData.length; i++) {
            editPage.enterRequiredInfoForClaim(requiredInfoPaths[i], requiredInfoData[i]);
        }
    }
    @Test(priority = 3)
    public void checkIsClaimAccepted(){
        editPage.clickSend();
        assertEquals(editPage.checkIfClaimAccepted(), claimAccepted, "Claim is not accepted");
    }
}
