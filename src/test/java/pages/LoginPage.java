package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");


    public LoginPage(){
    }

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
}
