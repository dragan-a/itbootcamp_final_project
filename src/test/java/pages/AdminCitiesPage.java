package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {
    private final By newItem = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private final By inputField = By.id("name");
    private final By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private final By searchField = By.id("search");
    private final By editIcon = By.xpath("//*[@id=\"edit\"]/span/i");
    private final By editItemField = By.id("name");
    private final By editedCityName = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");
    private final By deleteBtn = By.id("delete");
    private final By deleteBtnFromWarning = By.xpath("//*[@id='app']/div[5]/div/div/div[2]/button[2]");
    private final By savedSuccessfullyMessage = By.xpath(
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
    private final By savedSuccessfullyMessageBox = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div");

    private final By deletedSuccessfullyMessage = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private final By oneColumn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]");

    private final By warningDialogue = By.xpath("//*[@id=\"app\"]/div[5]/div");

    private final By popUpDialogue = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private final String validEmail = "admin@admin.com";
    private final String validPassword = "12345";
    private final String newCity = "Madrid";
    private final String edit = " - edited";
    private final String editedNewCityName = newCity + edit;

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

    public WebElement getEditIcon() {
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

    public WebElement getOneColumn() {
        return driver.findElement(oneColumn);
    }

    public WebElement getWarningDialogue() {
        return driver.findElement(warningDialogue);
    }

    public WebElement getPopUpDialogue() {
        return driver.findElement(popUpDialogue);
    }

    public WebElement getDeletedSuccessfullyMessage() {
        return driver.findElement(deletedSuccessfullyMessage);
    }

    public String getValidEmail() {
        return validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public String getNewCity() {
        return newCity;
    }

    public String getEdit() {
        return edit;
    }

    public String getEditedNewCityName() {
        return editedNewCityName;
    }

    public void waitingForSavedSuccessfullyMessageBox() {
        driverWait.until(ExpectedConditions.visibilityOf(getSavedSuccessfullyMessageBox()));
    }

    public void waitingForOneColumnToAppear() {
        driverWait.until(ExpectedConditions.visibilityOf(getOneColumn()));
    }

    public void waitingForWarningDialogue() {
        driverWait.until(ExpectedConditions.visibilityOf(getWarningDialogue()));
    }

    public void waitingForPopUpDialogue() {
        driverWait.until(ExpectedConditions.visibilityOf(getPopUpDialogue()));
    }

    public String getAdminCitiesRoute() {
        String adminCitiesRoute = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        return adminCitiesRoute;
    }

    public String getAdminUsersRoute() {
        String adminUsersRoute = "https://vue-demo.daniel-avellaneda.com/admin/users";
        return adminUsersRoute;
    }

    public WebElement getSavedSuccessfullyMessage() {
        return driver.findElement(savedSuccessfullyMessage);
    }

    public WebElement getSavedSuccessfullyMessageBox() {
        return driver.findElement(savedSuccessfullyMessageBox);
    }

    public void addingNewCity(String city) {
        getNewItem().click();
        getInputField().sendKeys(city);
        getSaveBtn().click();
    }

    public void editCity(String city, String edit) {
        getSearchField().sendKeys(city);
        getEditIcon().click();
        getEditItemField().sendKeys(edit);
        getSaveBtn().click();
    }

    public void searchCity(String city) {
        getSearchField().sendKeys(city);
    }

    public void deleteCity() {
        getDeleteBtn().click();
    }

    public void finalCityDelete() {
        getDeleteBtnFromWarning().click();
    }
}
