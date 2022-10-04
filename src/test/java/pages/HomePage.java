package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private By homeButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By signupButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("//*[@id=\"list-item-663\"]/div[2]");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By languageButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");


    public HomePage(){
    }

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getSignupButton() {
        return driver.findElement(signupButton);
    }

    public WebElement getAdminButton() {
        return driver.findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return driver.findElement(citiesButton);
    }

    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }

    public WebElement getLanguageButton() {
        return driver.findElement(languageButton);
    }

    public WebElement getProfileButton() {
        return driver.findElement(profileButton);
    }

    public WebElement getHomeButton() {
        return driver.findElement(homeButton);
    }
    public void visitsLoginPage(){
        getLoginButton().click();
    }
}