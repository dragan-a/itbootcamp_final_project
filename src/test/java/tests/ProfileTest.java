package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    //Data provided by Faker library
    @Test
    public void editingProfile() {
        login();
        profilePage.editData(fakerPage.getFakeName(), fakerPage.getFakePhone(), fakerPage.getFakeCity(),
                fakerPage.getFakeCountry(), fakerPage.getFakeTwitter(), fakerPage.getFakeGitHub());

        //Verify that "Profile saved successfuly" message appears
        //There is a mistake in original message, one l is missing - low priority, low severity
        Assert.assertTrue(profilePage.getProfileSavedSuccessfullyMessage().getText().contains("Profile saved successfuly"));

        //Verify that "Name" field has provided name from Faker library as its attribute value
        Assert.assertEquals(profilePage.getNameField().getAttribute("value"), fakerPage.getFakeName());

        //Verify that "Phone" field has provided phone number from Faker library as its attribute value
        Assert.assertEquals(profilePage.getPhoneField().getAttribute("value"), fakerPage.getFakePhone());

        //Verify that "City" field has provided city from Faker library as its attribute value
        /*
        Was hard to use faker here for the city because user has to pick from menu. Select didn't work here.
        City field always picks "Bucaramanga" as city no matter what faker did, so I hardcoded it
        */
        Assert.assertEquals(profilePage.getCityField().getAttribute("value"), "Bucaramanga");

        //Verify that "Country" field has provided country from Faker library as its attribute value
        Assert.assertEquals(profilePage.getCountryField().getAttribute("value"), fakerPage.getFakeCountry());

        //Verify that "Twitter" field has provided Twitter from Faker library as its attribute value
        Assert.assertEquals(profilePage.getTwitterField().getAttribute("value"), fakerPage.getFakeTwitter().toLowerCase());

        //Verify that "GitHub" field has provided GitHub from Faker library as its attribute value
        Assert.assertEquals(profilePage.getGitHubField().getAttribute("value"), fakerPage.getFakeGitHub().toLowerCase());

        homePage.logout();
    }

    private void login() {
        homePage.visitLoginPage();
        loginPage.enterCredentials(profilePage.getValidEmail(), profilePage.getValidPassword());
        homePage.visitProfilePage();
    }
}
