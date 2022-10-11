package tests;

import com.github.javafaker.Address;
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
    /*Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
•	    baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
•	    beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem za ucitavanje stranice i
        kreiraju svi pagevi potrebni za testiranje
•	    aftterClass - gde se gasi stranica
•	    beforeMethod - gde se pre svakog testa ucitava baseUrl stranica
*/
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SignUpPage signupPage;
    protected AdminCitiesPage adminCitiesPage;
    protected ProfilePage profilePage;
    protected FakerPage fakerPage;


    @BeforeClass
    public void beforeClass (){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));      // da li mi trebaju oba?
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(25));

        driver.get("https://vue-demo.daniel-avellaneda.com");
        driverWait.until(ExpectedConditions.urlContains("https://vue-demo.daniel-avellaneda.com/"));

        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver,driverWait);
        signupPage = new SignUpPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        fakerPage = new FakerPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod (){
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @AfterClass
    public void afterClass (){
        driver.quit();
    }
}
