package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.Utils.waitPresent;

public class SearchResultPage {
    WebDriver driver;
    private By placeNameResult = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[1]/a/div/div[1]/div[1]");
    private By accommodationOnList = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[4]/a/div/div[1]/div[1]");
    private By sportOnList = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[1]/a/div/div[1]/div[1]");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPlaceName(){
        waitPresent(placeNameResult, driver);
        return driver.findElement(placeNameResult).getText();
    }
    public String checkPlaceName(){
        waitPresent(accommodationOnList, driver);
        return driver.findElement(accommodationOnList).getText();
    }
    public String checkSportName(){
        waitPresent(sportOnList, driver);
        return driver.findElement(sportOnList).getText();
    }
    public EditPage clickPlaceOnList() {
        waitPresent(accommodationOnList, driver);
        driver.findElement(accommodationOnList).click();
        return new EditPage(driver);
    }
    public EditPage clickSportOnList() {
        waitPresent(sportOnList, driver);
        driver.findElement(sportOnList).click();
        return new EditPage(driver);
    }
}
