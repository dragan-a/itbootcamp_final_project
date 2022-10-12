package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    //Verify that page URL shows /signup route
    @Test
    public void checkSignUpPageUrl() {
        homePage.visitSignUpPage();
        checkSignUpRoute();
    }

    @Test
    public void checkInputTypes() {
        homePage.visitSignUpPage();

        //Verify that email field has attribute value "email"
        Assert.assertEquals(signupPage.getEmailField().getAttribute("type"), "email");

        //Verify that password field has attribute value "password"
        Assert.assertEquals(signupPage.getPasswordField().getAttribute("type"), "password");

        //Verify that confirm password field has attribute value "password"
        Assert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), "password");
    }

    @Test
    public void emailAlreadyExists() {
        homePage.visitSignUpPage();
        signupPage.enterCredentials(signupPage.getValidName(), signupPage.getValidEmail(),
                signupPage.getValidPassword(), signupPage.getValidConfirmPassword());
        signupPage.waitingForEmailAlreadyExistsMessageBox();

        //Verify that "E-mail already exists" message appears
        Assert.assertEquals(signupPage.getGetEmailAlreadyExistsMessage().getText(), "E-mail already exists");

        //Verify that page URL shows /signup route
        checkSignUpRoute();
    }

    @Test
    public void signUpWithValidCredentials() {
        signUp(fakerPage.getFakeName(), fakerPage.getFakeEmailForSignup(), fakerPage.getFakePassword(),
                fakerPage.getFakePassword());
        //signupPage.waitingForVerifyYourAccountMessageBox();
        //This wait won't work, so I had to put Thread.sleep even if it is for 1 sec
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Verify that "IMPORTANT: Verify your account" message appears
        Assert.assertEquals(signupPage.getVerifyYourAccountMessage().getText(), "IMPORTANT: Verify your account");
    }

    public void checkSignUpRoute() {
        Assert.assertEquals(driver.getCurrentUrl(), signupPage.getSignUpRoute());
    }

    public void signUp(String name, String email, String password, String confirmPassword) {
        homePage.visitSignUpPage();
        signupPage.enterCredentials(name, email, password, confirmPassword);
    }
}
