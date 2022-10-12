package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

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
        adminCitiesPage.addingNewCity(adminCitiesPage.getNewCity());
        adminCitiesPage.waitingForSavedSuccessfullyMessageBox();

        //Verify that "Saved successfully" message appears
        Assert.assertTrue(adminCitiesPage.getSavedSuccessfullyMessage().getText().contains("Saved successfully"));
        homePage.logout();
    }

    @Test
    public void editCity() {
        login();
        adminCitiesPage.editCity(adminCitiesPage.getNewCity(), adminCitiesPage.getEdit());

        //Verify that edited city name is "Madrid - edited"
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), adminCitiesPage.getEditedNewCityName());

        //Verify that "Saved successfully" message appears
        Assert.assertTrue(adminCitiesPage.getSavedSuccessfullyMessage().getText().contains("Saved successfully"));
        homePage.logout();
    }

    @Test
    public void searchCity() {
        login();
        adminCitiesPage.searchCity(adminCitiesPage.getEditedNewCityName());

        //Verify that city from search is in first "Name" column
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), adminCitiesPage.getEditedNewCityName());
        homePage.logout();
    }

    @Test
    public void deleteCity() {
        login();
        adminCitiesPage.searchCity(adminCitiesPage.getEditedNewCityName());
        adminCitiesPage.waitingForOneColumnToAppear();

        //Verify that city from search is in first "Name" column
        Assert.assertEquals(adminCitiesPage.getEditedCityName().getText(), adminCitiesPage.getEditedNewCityName());

        adminCitiesPage.deleteCity();
        adminCitiesPage.waitingForWarningDialogue();
        adminCitiesPage.finalCityDelete();
        adminCitiesPage.waitingForPopUpDialogue();

        //Verify that message contains text ""Deleted successfully"
        Assert.assertTrue(adminCitiesPage.getDeletedSuccessfullyMessage().getText().contains("Deleted successfully"));
    }

    public void login() {
        homePage.visitLoginPage();
        loginPage.enterCredentials(adminCitiesPage.getValidEmail(), adminCitiesPage.getValidPassword());
        homePage.visitCitiesPage();
    }
}
