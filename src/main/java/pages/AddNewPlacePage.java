package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import static utils.Utils.waitPresent;

public class AddNewPlacePage {
    WebDriver driver;
    private By createNewPlaceTitle = By.xpath("//div//div//h4");
    private By categoryButton = By.xpath("//div//div//button[@class='ember-view btn btn-small']");
    private By selectCategory = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/select");
    private By selectSubcategory = By.xpath("/html/body/div[4]/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/select");
    private By createNewPlaceButton = By.xpath("//button[@class = 'btn btn-success']");
    private By message = By.xpath("//div//div[@class='alert alert-error']");

    public AddNewPlacePage(WebDriver driver){
        this.driver = driver;
    }

    public String checkCreateNewPlaceTitle(){
        waitPresent(createNewPlaceTitle, driver);
        return driver.findElement(createNewPlaceTitle).getText();
    }
    public void enterRequiredInfo(String data, String path){
        String elementPath = "//form//div//input[@id='poi_%s']";
        elementPath = String.format(elementPath, path);
        waitPresent(By.xpath(elementPath), driver);
        driver.findElement(By.xpath(elementPath)).sendKeys(data);
    }
    public void clickCategory(){
        waitPresent(categoryButton, driver);
        driver.findElement(categoryButton).click();
    }
    public void chooseCategory(String category){
        waitPresent(selectCategory, driver);
        Select select = new Select(driver.findElement(selectCategory));
        select.selectByVisibleText(category);
    }
    public void chooseSubcategory(String category){
        waitPresent(selectSubcategory, driver);
        Select select = new Select(driver.findElement(selectSubcategory));
        select.selectByVisibleText(category);
    }
    public void clickCreate() {
        WebElement element = driver.findElement(createNewPlaceButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public String checkIfNewPlaceCreated(){
        waitPresent(message, driver);
        return driver.findElement(message).getText();
    }
}
