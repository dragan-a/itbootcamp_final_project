package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private final By userDoesNotExistsMessage = By.tagName("li");
    private final By userDoesNotExistsMessageBox = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    private final By wrongPasswordMessage = By.tagName("li");
    private final By getWrongPasswordMessageBox = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }

    public WebElement getUserDoesNotExistsMessage() {
        return driver.findElement(userDoesNotExistsMessage);
    }

    public WebElement getUserDoesNotExistsMessageBox() {
        return driver.findElement(userDoesNotExistsMessageBox);
    }

    public WebElement getWrongPasswordMessage() {
        return driver.findElement(wrongPasswordMessage);
    }

    public WebElement getGetWrongPasswordMessageBox() {
        return driver.findElement(getWrongPasswordMessageBox);
    }

    public String getLoginRoute() {
        String loginRoute = "https://vue-demo.daniel-avellaneda.com/login";
        return loginRoute;
    }

    public void waitingForUserDoesNotExistsMessageBox() {
        driverWait.until(ExpectedConditions.visibilityOf(getUserDoesNotExistsMessageBox()));
    }

    public void waitingForWrongPasswordMessageBox() {
        driverWait.until(ExpectedConditions.visibilityOf(getGetWrongPasswordMessageBox()));
    }

    public void enterCredentials(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }
}
