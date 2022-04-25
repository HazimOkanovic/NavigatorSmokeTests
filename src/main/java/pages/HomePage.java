package pages;

import org.openqa.selenium.*;
import static utils.Utils.waitPresent;

public class HomePage {
    WebDriver driver;
    private By searchBox = By.xpath("//div//div//span//input[@class='ember-view ember-text-field tt-query']");
    private By addButton = By.xpath("//ul//li[@title='Kreiraj objekat']");
    private By accommodationButton = By.xpath("//div//ul//li[@class='accommodation']");
    private By sportButton = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[9]/a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void enterText(String text){
        waitPresent(searchBox, driver);
        driver.findElement(searchBox).sendKeys(text);
    }
    public SearchResultPage clickAccommodation(){
        waitPresent(accommodationButton, driver);
        driver.findElement(accommodationButton).click();
        return new SearchResultPage(driver);
    }
    public SearchResultPage clickSport(){
        WebElement element = driver.findElement(sportButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return new SearchResultPage(driver);
    }
    public AddNewPlacePage clickAddNewPlace(){
        waitPresent(addButton, driver);
        driver.findElement(addButton).click();
        return new AddNewPlacePage(driver);
    }
    public SearchResultPage hitEnter(){
        waitPresent(searchBox, driver);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
