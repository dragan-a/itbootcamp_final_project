package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.audits.model.FederatedAuthRequestIssueDetails;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{
    private By newItem = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By inputField = By.id("name");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By searchField = By.id("search");
    private By editIcon = By.xpath("//*[@id=\"edit\"]/span/i");
    private By editItemField = By.id("name");
    private By editedCityName = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");
    private By deleteBtn = By.id("delete");
    private By deleteBtnFromWarning = By.xpath("//*[@id=\"app\"]/div[7]/div/div/div[2]/button[2]/span");

    public AdminCitiesPage(){
    }

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getNewItem() {
        return driver.findElement(newItem);
    }

    public WebElement getInputField() {
        return driver.findElement(inputField);
    }

    public WebElement getSaveBtn() {
        return driver.findElement(saveBtn);
    }

    public WebElement getSearchField() {
        return driver.findElement(searchField);
    }

    public WebElement getEditIcon(){
        return driver.findElement(editIcon);
    }

    public WebElement getEditItemField() {
        return driver.findElement(editItemField);
    }

    public WebElement getEditedCityName() {
        return driver.findElement(editedCityName);
    }

    public WebElement getDeleteBtn() {
        return driver.findElement(deleteBtn);
    }

    public WebElement getDeleteBtnFromWarning() {
        return driver.findElement(deleteBtnFromWarning);
    }

    public void addingNewCity(String city){
        getNewItem().click();
        getInputField().sendKeys(city);
        getSaveBtn().click();
    }

    public void editCity(String city, String edit){
        getSearchField().sendKeys(city);
        getEditIcon().click();
        getEditItemField().sendKeys(edit);
        getSaveBtn().click();
    }
}
