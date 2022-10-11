package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SignUpPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected ProfilePage profilePage;
    protected FakerPage fakerPage;
    private final String baseURL = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));

        driver.get(baseURL);
        driverWait.until(ExpectedConditions.urlMatches(baseURL));

        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        signupPage = new SignUpPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        fakerPage = new FakerPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
