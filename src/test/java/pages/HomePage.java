package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final By homeButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");
    private final By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private final By signupButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");
    private final By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private final By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private final By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private final By languageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");
    private final By spanishButton = By.id("list-item-75");
    private final By greetingMessageSpanish = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private final By englishButton = By.id("list-item-73");
    private final By greetingMessageEnglish = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private final By frenchButton = By.id("list-item-77");
    private final By greetingMessageFrench = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    private final By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

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

    public WebElement getFrenchButton() {
        return driver.findElement(frenchButton);
    }

    public WebElement getProfileButton() {
        return driver.findElement(profileButton);
    }

    public WebElement getGreetingMessageSpanish() {
        return driver.findElement(greetingMessageSpanish);
    }

    public WebElement getGreetingMessageEnglish() {
        return driver.findElement(greetingMessageEnglish);
    }

    public WebElement getGreetingMessageFrench() {
        return driver.findElement(greetingMessageFrench);
    }

    public String getHomeRoute() {
        String homeRoute = "https://vue-demo.daniel-avellaneda.com/home";
        return homeRoute;
    }
    public String getProfileRoute(){
        String profileRoute = "https://vue-demo.daniel-avellaneda.com/profile";
        return profileRoute;
    }

    public void visitLoginPage() {
        getLoginButton().click();
    }

    public void visitSignUpPage() {
        getSignupButton().click();
    }

    public void visitProfilePage() {
        getProfileButton().click();
    }

    public void logout() {
        getLogoutButton().click();
    }


    public void visitCitiesPage() {
        getAdminButton().click();
        driverWait.withTimeout(Duration.ofSeconds(5));
        getCitiesButton().click();
    }

    public void languageChangeToSpanish() {
        getLanguageButton().click();
        getSpanishButton().click();
    }

    public void languageChangeToEnglish() {
        getLanguageButton().click();
        getEnglishButton().click();
    }

    public void languageChangeToFrench() {
        getLanguageButton().click();
        getFrenchButton().click();
    }

    public void waitingForHomeRouteToAppear() {
        driverWait.until(ExpectedConditions.urlMatches(getHomeRoute()));
    }
}
