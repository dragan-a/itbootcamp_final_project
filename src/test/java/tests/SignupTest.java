package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest{
    @Test
    public void signupPageUrlTest (){
        visitSignupPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    //Test #2: Checks input types
    //assert:
    //•	Verifikovati da polje za unos emaila za atribut type ima vrednost email
    //•	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
    //•	Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
    @Test
    public void inputTypesTest() {
        visitSignupPage();
        String expectedResult1 = "email";
        String actualResult1 = signupPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "password";
        String actualResult2 = signupPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

        String expectedResult3 = "password";
        String actualResult3 = signupPage.getConfirmPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult3, expectedResult3);
    }
    //Test #3: Displays errors when user already exists
    //assert:
    //•	Verifikovati da greska sadrzi poruku E-mail already exists
    //•	Verifikovati da se u url-u stranice javlja /signup ruta
    @Test
    public void userAlreadyExistsTest(){
        visitSignupPage();
        String name = "Test test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signupPage.enterCredentials(name, email, password, confirmPassword);

        String expectedResult1 = "E-mail already exists";
        String actualResult1 = driver.findElement(By.tagName("li")).getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);

    }
    //Test #4: Signup
    //Podaci:
    //•	name: Ime i prezime polaznika
    //•	email template: ime.prezime@itbootcamp.rs
    //•	password: 12346
    //•	confirm password: 123456
    //assert:
    //•	Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account

    @Test
    public void signupWithValidCredentialsTest(){
        visitSignupPage();
        Faker faker = new Faker();
        //da bi ime bilo isto i u mailu
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String name = firstName + lastName;
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@itbootcamp.rs";
        /*String name = "Dragana Trifkovic";
        String email = "dragana.trifkovic@itbootcamp.rs";*/
        String password = "12346";
        String confirmPassword = "12346";
        signupPage.enterCredentials(name, email, password, confirmPassword);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedResult = "IMPORTANT: Verify your account";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    public void visitSignupPage(){
        homePage.visitSignupPage();
    }
}