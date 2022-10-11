package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By signMeUpBtn = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private final By getEmailAlreadyExistsMessage = By.tagName("li");
    private final By emailAlreadyExistsBox = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div");
    private final By verifyYourAccountMessageBox = By.xpath("//*[@id=\"app\"]/div[4]/div");
    private final By verifyYourAccountMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return driver.findElement(nameField);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return driver.findElement(confirmPasswordField);
    }

    public WebElement getSignMeUpBtn() {
        return driver.findElement(signMeUpBtn);
    }

    public WebElement getVerifyYourAccountMessageBox() {
        return driver.findElement(verifyYourAccountMessageBox);
    }

    public WebElement getVerifyYourAccountMessage() {
        return driver.findElement(verifyYourAccountMessage);
    }

    public WebElement getGetEmailAlreadyExistsMessage() {
        return driver.findElement(getEmailAlreadyExistsMessage);
    }

    public WebElement getEmailAlreadyExistsBox() {
        return driver.findElement(emailAlreadyExistsBox);
    }

    public String getSignUpRoute() {
        String signUpRoute = "https://vue-demo.daniel-avellaneda.com/signup";
        return signUpRoute;
    }

    public void waitingForVerifyYourAccountMessageBox() {
        driverWait.until(ExpectedConditions.visibilityOf(getVerifyYourAccountMessageBox()));
    }

    public void waitingForEmailAlreadyExistsMessageBox() {
        driverWait.until(ExpectedConditions.visibilityOf(getEmailAlreadyExistsBox()));
    }

    public void enterCredentials(String name, String email, String password, String confirmPassword) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
        getSignMeUpBtn().click();
    }
}
