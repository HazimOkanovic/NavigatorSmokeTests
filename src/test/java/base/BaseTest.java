package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {
    WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.navigator.ba/#/categories");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void driverQuit(){
        driver.quit();
   }
}
