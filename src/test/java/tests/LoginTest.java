package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final String validEmail = "admin@admin.com";
    private final String validPassword = "12345";
    //Invalid credentials are provided by Faker Library

    //Verify that URL shows /login route
    @Test
    public void checkLoginPageUrl() {
        homePage.visitLoginPage();
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginRoute());
    }

    @Test
    public void checkInputTypes() {
        homePage.visitLoginPage();

        //Verify that email field has attribute value "email"
        Assert.assertEquals(loginPage.getEmailField().getAttribute("type"), "email");

        //Verify that password field has attribute value "password"
        Assert.assertEquals(loginPage.getPasswordField().getAttribute("type"), "password");
    }

    //Data: invalid email and password
    @Test
    public void userDoesNotExist() {
        login(fakerPage.getFakeEmailForLogin(), fakerPage.getFakePassword());
        loginPage.waitingForUserDoesNotExistsMessageBox();

        //Verify that "User does not exists" message appears
        Assert.assertEquals(loginPage.getUserDoesNotExistsMessage().getText(), "User does not exists");

        //Verify that page URL shows /login route
        checkLoginRoute();
    }

    //Data: valid email and invalid password
    @Test
    public void loginWithInvalidPassword() {
        login(validEmail, fakerPage.getFakePassword());
        loginPage.waitingForWrongPasswordMessageBox();

        //Verify that "Wrong password" message appears
        Assert.assertEquals(loginPage.getWrongPasswordMessage().getText(), "Wrong password");

        //Verify that page URL shows /login route
        checkLoginRoute();
    }

    @Test
    public void loginWithValidCredentials() {
        login(validEmail, validPassword);
        homePage.waitingForHomeRouteToAppear();

        //Verify that page URL shows /home route
        Assert.assertEquals(driver.getCurrentUrl(), homePage.getHomeRoute());
        homePage.logout();
    }

    @Test
    public void logoutTest() {
        login(validEmail, validPassword);
        //Verify that "Logout" button is visible
        Assert.assertTrue(true, String.valueOf(homePage.getLogoutButton().isDisplayed()));

        //Verify that /login route appears after logging out
        homePage.logout();
        checkLoginRoute();

        //Verify that user is redirected to Login Page when tries to go to Home Page
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginRoute());
    }

    //This was used several times so I made a method
    public void checkLoginRoute() {
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginRoute());
    }

    public void login(String email, String password) {
        homePage.visitLoginPage();
        loginPage.enterCredentials(email, password);
    }
}
