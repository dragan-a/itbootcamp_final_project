package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    private final String newCity = "Madrid";
    private final String edit = " - edited";
    private final String editedCityName = newCity + edit;

    @Test
    public void citiesPageTest() {
        login();

        //Verify that page URL shows /admin/cities route
        Assert.assertEquals(driver.getCurrentUrl(), adminCitiesPage.getAdminCitiesRoute());

        //Verify that "Logout" button is visible
        Assert.assertTrue(true, String.valueOf(homePage.getLogoutButton().isDisplayed()));
        homePage.logout();
    }

    @Test
    public void createCity() {
        login();
        adminCitiesPage.addingNewCity(newCity);
        adminCitiesPage.waitingForSavedSuccessfullyMessageBox();

        //Verify that "Saved successfully" message appears
        Assert.assertTrue(adminCitiesPage.getSavedSuccessfullyMessage().getText().contains("Saved successfully"));
        homePage.logout();
    }

    @Test
    public void editCity() {
        login();
        adminCitiesPage.editCity(newCity, edit);

        //Verify that edited city name is "Madrid - edited"
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), editedCityName);

        //Verify that "Saved successfully" message appears
        Assert.assertTrue(adminCitiesPage.getSavedSuccessfullyMessage().getText().contains("Saved successfully"));
        homePage.logout();
    }

    @Test
    public void searchCity() {
        login();
        adminCitiesPage.searchCity(editedCityName);

        //Verify that city from search is in first "Name" column
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), editedCityName);
        homePage.logout();
    }

    @Test
    public void deleteCity() {
        login();
        adminCitiesPage.searchCity(editedCityName);
        adminCitiesPage.waitingForOneColumnToAppear();

        //Verify that city from search is in first "Name" column
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), editedCityName);

        adminCitiesPage.deleteCity();
        adminCitiesPage.waitingForWarningDialogue();
        adminCitiesPage.finalCityDelete();
        adminCitiesPage.waitingForPopUpDialogue();

        //Verify that message contains text ""Deleted successfully"
        Assert.assertTrue(adminCitiesPage.getDeletedSuccessfullyMessage().getText().contains("Deleted successfully"));
    }

    public void login() {
        homePage.visitLoginPage();
        String validPassword = "12345";
        String validEmail = "admin@admin.com";
        loginPage.enterCredentials(validEmail, validPassword);
        homePage.visitCitiesPage();
    }
}
