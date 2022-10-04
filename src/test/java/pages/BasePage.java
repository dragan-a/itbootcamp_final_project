package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected SignupPage signupPage;
    protected LoginPage loginPage;

    public BasePage (){
    }
    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
