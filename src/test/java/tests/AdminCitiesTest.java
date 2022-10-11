package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {
    //Test #1: Visits the admin cities page and list cities
    //Podaci:
    //•	admin email: admin@admin.com
    //•	admin password: 12345
    //assert:
    //•	Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //•	Verifikovati postojanje logut dugmeta

    //getNameField().sendKeys(Keys.CONTROL + "a" + Keys.DELETE)
    @Test
    public void citiesPageTest() {
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitCitiesPage();
        String expectedResult1 = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResult1 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult1, expectedResult1);

        boolean expectedResult2 = true;
        boolean actualResult2 = homePage.getLogoutButton().isDisplayed();
        Assert.assertTrue(expectedResult2, String.valueOf(actualResult2));
        homePage.logout();
    }
    //Test #2: Create new city
    //Podaci: random grad korisćenjem faker library-ja
    //assert:
    //•	Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 1)
    public void createCityTest() {
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitCitiesPage();
        String newCity = "Boston";
        adminCitiesPage.addingNewCity(newCity);

        String expectedResult = "Saved successfully";
        String actualResult = driver.findElement(By.xpath(
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"))).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        homePage.logout();
    }

    //Test #3: Edit city
    //Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited (primer: Beograd – Beograd edited)
    //assert:
    //•	Verifikovati da poruka sadrzi tekst Saved successfully
    @Test(priority = 2)
    public void editCityTest() {
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitCitiesPage();
        String myCity = "Boston";
        String edit = " - edited";
        adminCitiesPage.editCity(myCity, edit);
        String expectedResult1 = myCity + edit;
        String actualResult1 = adminCitiesPage.getEditedCityName().getText();
        Assert.assertEquals(actualResult1, expectedResult1);

        String expectedResult2 = "Saved successfully";
        String actualResult2 = driver.findElement(By.xpath(
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"))).getText();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
        homePage.logout();
    }

    //Test #4: Search city
    //Podaci: editovani grad iz testa #3
    //assert:
    //•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    @Test(priority = 3)
    public void searchCityTest() {
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitCitiesPage();
        String myCity = "Boston - edited";
        adminCitiesPage.getSearchField().sendKeys(myCity);
        String expectedResult = myCity;
        String actualResult = adminCitiesPage.getEditedCityName().getText();
        Assert.assertEquals(actualResult, expectedResult);
        homePage.logout();
    }
    //Test #5: Delete city
    //Podaci: editovani grad iz testa #3
    //assert:
    //•	U polje za pretragu uneti staro ime grada
    //•	Sacekati da broj redova u tabeli bude 1
    //•	Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    //•	Kliknuti na dugme Delete iz prvog reda
    //•	Sacekati da se dijalog za brisanje pojavi
    //•	Kliknuti na dugme Delete iz dijaloga
    //•	Sacekati da popu za prikaz poruke bude vidljiv
    //•	Verifikovati da poruka sadrzi tekst Deleted successfully

    @Test(priority = 4)
    public void deleteCityTest() {
        homePage.visitLoginPage();
        loginPage.enterCredentials("admin@admin.com", "12345");
        homePage.visitCitiesPage();
        String myCity = "Boston - edited";
        adminCitiesPage.getSearchField().sendKeys(myCity);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]")));
        String expectedResult = myCity;
        String actualResult = adminCitiesPage.getEditedCityName().getText();
        Assert.assertEquals(actualResult, expectedResult);
        adminCitiesPage.deleteCity();

        //waiting for warning dialogue
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[5]/div")));
        adminCitiesPage.finalCityDelete();

        //waiting for pop-up
        driverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        String expectedResult2 = "Deleted successfully";
        String actualResult2 = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }
}
