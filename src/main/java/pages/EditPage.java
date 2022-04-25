package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static utils.Utils.waitPresent;

public class EditPage {
    WebDriver driver;
    private By sendButton = By.xpath("//form//div//input[@class='btn btn-success']");
    private By suggestChangeButton = By.xpath("//button[contains(@class, 'btn btn-success')]");
    private By claimButton = By.xpath("//div//div//button[@class='btn btn-claim']");
    private By placeName = By.xpath("//div//div[@class='name']");
    private By successMessage = By.xpath("//div//div[@class='alert alert-error']");

    public EditPage(WebDriver driver){
        this.driver = driver;
    }

    public String checkPlaceName(){
        waitPresent(placeName, driver);
        return driver.findElement(placeName).getText();
    }
    public void editRequiredInfo(String data, String path){
        String elementPath = "//form//div//input[@id='poi_%s']";
        elementPath = String.format(elementPath, path);
        waitPresent(By.xpath(elementPath), driver);
        driver.findElement(By.xpath(elementPath)).sendKeys(data);
    }
    public void enterRequiredInfoForClaim(String path, String requiredInfo){
        String elementPath = "//form//div//input[@name='%s']";
        elementPath = String.format(elementPath, path);
        waitPresent(By.xpath(elementPath), driver);
        driver.findElement(By.xpath(elementPath)).sendKeys(requiredInfo);
    }
    public void clickSuggestChange() {
        waitPresent(suggestChangeButton, driver);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(suggestChangeButton));
    }
    public void clickConfirmSuggestChange() {
        WebElement element = driver.findElement(suggestChangeButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public String checkIfSuggestionAccepted(){
        waitPresent(successMessage, driver);
        return driver.findElement(successMessage).getText();
    }
    public String checkIfClaimAccepted(){
        waitPresent(successMessage, driver);
        return driver.findElement(successMessage).getText();
    }
    public void clickClaim(){
        waitPresent(claimButton, driver);
        driver.findElement(claimButton).click();
    }
    public void clickSend(){
        waitPresent(sendButton, driver);
        driver.findElement(sendButton).click();
    }
}
