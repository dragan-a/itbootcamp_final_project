package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    private By homeButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By signupButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By languageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");
    private By spanishButton = By.id("list-item-75");
    private By englishButton = By.id("list-item-73");
    private By franceButton = By.id("list-item-77");
    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

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

    public WebElement getSpanishButton() {
        return driver.findElement(spanishButton);
    }

    public WebElement getEnglishButton() {
        return driver.findElement(englishButton);
    }

    public WebElement getFranceButton() {
        return driver.findElement(franceButton);
    }

    public WebElement getProfileButton() {
        return driver.findElement(profileButton);
    }

    public WebElement getHomeButton() {
        return driver.findElement(homeButton);
    }

    public void visitLoginPage(){
        getLoginButton().click();
    }

    public void visitSignUpPage(){
        getSignupButton().click();
    }

    public void visitProfilePage() {
        getProfileButton().click();
    }

    public void logout(){
        getLogoutButton().click();
    }

    public void visitHomePage(){
        getHomeButton().click();
    }

    public void visitCitiesPage (){
        getAdminButton().click();
        driverWait.withTimeout(Duration.ofSeconds(5));
        getCitiesButton().click();
    }

    public void languageChangeToSpanish(){
        getLanguageButton().click();
        getSpanishButton().click();
    }

    public void languageChangeToEnglish(){
        getLanguageButton().click();
        getEnglishButton().click();
    }

    public void languageChangeToFrance(){
        getLanguageButton().click();
        getFranceButton().click();
    }
}
