package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    private final By nameField = By.id("name");
    private final By phoneField = By.id("phone");
    private final By cityField = By.id("city");
    private final By countryField = By.id("country");
    private final By twitterField = By.id("urlTwitter");
    private final By gitHubField = By.id("urlGitHub");
    private final By saveBtn = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private final By profileSavedSuccessfullyMessage = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");
    private final String validEmail = "admin@admin.com";
    private final String validPassword = "12345";

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNameField() {
        return driver.findElement(nameField);
    }

    public WebElement getPhoneField() {
        return driver.findElement(phoneField);
    }

    public WebElement getCityField() {
        return driver.findElement(cityField);
    }

    public WebElement getCountryField() {
        return driver.findElement(countryField);
    }

    public WebElement getTwitterField() {
        return driver.findElement(twitterField);
    }

    public WebElement getGitHubField() {
        return driver.findElement(gitHubField);
    }

    public WebElement getSaveBtn() {
        return driver.findElement(saveBtn);
    }

    public WebElement getProfileSavedSuccessfullyMessage() {
        return driver.findElement(profileSavedSuccessfullyMessage);
    }

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void editData(String name, String phone, String city, String country, String twitter, String gitHub) {
        getNameField().click();
        getNameField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getNameField().sendKeys(name);
        getPhoneField().click();
        getPhoneField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhoneField().sendKeys(phone);
        getCityField().click();
        getCityField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCityField().sendKeys(city);
        getCountryField().click();
        getCountryField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountryField().sendKeys(country);
        getTwitterField().click();
        getTwitterField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitterField().sendKeys(twitter);
        getGitHubField().click();
        getGitHubField().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHubField().sendKeys(gitHub);
        getSaveBtn().click();
    }
}
