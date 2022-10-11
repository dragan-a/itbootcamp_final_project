package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginPageUrlTest (){
        homePage.visitLoginPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    //Test #2: Checks input types
    //assert:
    //•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    @Test
    public void inputTypesTest(){
        homePage.visitLoginPage();
        String expectedResult1 = "email";
        String actualResult1 = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "password";
        String actualResult2 = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);
    }
    //Test #3: Displays errors when user does not exist
    //Podaci: random email i password koristeći faker libarary
    //asssert:
    //•	Verifikovati da greska sadrzi poruku User does not exists
    //•	Verifikovati da se u url-u stranice javlja /login ruta
    @Test
    public void userDoesNotExistTest(){
        homePage.visitLoginPage();
        Faker faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + faker.name().lastName().toLowerCase() + "@testmail.com";
        String password = faker.name().username();
        loginPage.enterCredentials(email, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {          //driverWait
            throw new RuntimeException(e);
        }
        String expectedResult1 = "User does not exists";
        String actualResult1 = driver.findElement(By.tagName("li")).getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        //Verify that page URL shows /login route
        checkUrlLoginRoute();
    }
    //Test #4: Displays errors when password is wrong
    //Podaci: email: admin@admin.com i proizvoljan password
    //
    //asssert:
    //•	Verifikovati da greska sadrzi poruku Wrong password
    //•	Verifikovati da se u url-u stranice javlja /login ruta
    @Test
    public void loginWithInvalidPasswordTest(){
        Faker faker = new Faker();
        homePage.visitLoginPage();
        String email = "admin@admin.com";
        String password = faker.name().username();
        loginPage.enterCredentials(email, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);          //driverWait
        }
        String expectedResult1 = "Wrong password";
        String actualResult1 = driver.findElement(By.tagName("li")).getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        //Verify that page URL shows /login route
        checkUrlLoginRoute();
    }
    //Test #5: Login
    //Podaci:
    //•	email: admin@admin.com
    //•	password: 12345
    //asssert:
    //•	Verifikovati da se u url-u stranice javlja /home ruta
    @Test
    public void loginWithValidCredentialsTest(){
        homePage.visitLoginPage();
        String email = "admin@admin.com";
        String password = "12345";
        loginPage.enterCredentials(email, password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    //Test #6: Logout
    //assert:
    //•	Verifikovati da je dugme logout vidljivo na stranici
    //•	Verifikovati da se u url-u stranice javlja /login ruta    nakon klika na logout?
    //•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u
    // stranice javlja /login ruta (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)
    @Test (dependsOnMethods = {"loginWithValidCredentialsTest"})
    public void logoutButtonVisibilityTest(){
        boolean expectedResult1 = true;
        boolean actualResult1 = homePage.getLogoutButton().isDisplayed();
        Assert.assertTrue(expectedResult1, String.valueOf(actualResult1));

        homePage.logout();
        checkUrlLoginRoute();

        //•	Verifikovati da se nakon pokušaja otvaranja /home rute, u url-u
        // stranice javlja /login ruta (otvoriti sa driver.get home page i proveriti da li vas redirektuje na login)
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    public void checkUrlLoginRoute(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
