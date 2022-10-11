package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends BaseTest{
    //Test #1: Edits profile
    //Podaci: random podaci korišćenjem faker library-ja
    //assert:
    //•	Verifikovati da je prikazana poruka Profile saved successfuly
    //•	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme

    @Test
    public void editingProfileTest(){
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitProfilePage();

        Faker faker = new Faker();
        String name = faker.name().fullName();
        String phone = String.valueOf(faker.phoneNumber());
        String city = faker.address().city();
        String country = faker.address().country();
        String twitter = "https://" + faker.internet().domainName();
        String gitHub = "https://" + faker.name().firstName() + faker.internet().domainName();

        profilePage.changeData(name, phone, city, country, twitter, gitHub);

        String expectedResultForMessage = "Profile saved successfuly";
        String actualResultForMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText();
        Assert.assertTrue(actualResultForMessage.contains(expectedResultForMessage));

        String expectedResultForName = name;
        String actualResultForName = profilePage.getNameField().getAttribute("value");
        Assert.assertEquals(actualResultForName, expectedResultForName);

        String expectedResultForPhone = phone;
        String actualResultForPhone = profilePage.getPhoneField().getAttribute("value");
        Assert.assertEquals(actualResultForPhone, expectedResultForPhone);

        String expectedResultForCity = city;
        String actualResultForCity = profilePage.getCityField().getAttribute("value");
        Assert.assertEquals(actualResultForPhone, expectedResultForPhone);

        String expectedResultForCountry = country;
        String actualResultForCountry = profilePage.getCountryField().getAttribute("value");
        Assert.assertEquals(actualResultForPhone, expectedResultForPhone);

        String expectedResultForTwitter = twitter;
        String actualResultForTwitter = profilePage.getTwitterField().getAttribute("value");
        Assert.assertEquals(actualResultForPhone, expectedResultForPhone);

        String expectedResultForGitHub = gitHub;
        String actualResultForGitHub = profilePage.getGitHubField().getAttribute("value");
        Assert.assertEquals(actualResultForPhone, expectedResultForPhone);

        homePage.logout();
    }
}
