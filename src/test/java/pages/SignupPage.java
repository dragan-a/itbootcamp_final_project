package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signMeUpBtn = By.xpath(
            "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");

    public SignupPage(){
    }

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}
