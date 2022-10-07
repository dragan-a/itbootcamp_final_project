package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{
    //est #1: Forbids visits to home url if not authenticated
    //assert:
    //•	Ucitati /home stranu kada korisnik nije ulogovan
    //•	Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void accessingHomeWhenLoggedOutTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }
    //Test #2: Forbids visits to profile url if not authenticated
    //assert:
    //•	Ucitati /profile stranu
    //•	Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void accessingProfileWhenLoggedOutTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }
    //Test #3: Forbids visits to admin cities url if not authenticated
    //assert:
    //•	Ucitati /admin/cities stranu
    //•	Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void accessingAdminCitiesWhenLoggedOutTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    //Test #4: Forbids visits to admin users url if not authenticated
    //assert:
    //•	Ucitati /admin/users stranu
    //•	Verifikovati da se u url-u stranice javlja ruta /login
    @Test
    public void accessingAdminUsersWhenLoggedOutTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }
}
