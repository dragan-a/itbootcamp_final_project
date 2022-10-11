package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {

    @Test
    public void accessingHomePageWhenLoggedOut() {
        driver.get(homePage.getHomeRoute());
        //Verify that URL shows /login route
        checkIfLoginRouteShows();
    }

    @Test
    public void accessingProfileWhenLoggedOut() {
        driver.get(homePage.getProfileRoute());
        //Verify that URL shows /login route
        checkIfLoginRouteShows();
    }

    @Test
    public void accessingAdminCitiesWhenLoggedOut() {
        driver.get(adminCitiesPage.getAdminCitiesRoute());
        //Verify that URL shows /login route
        checkIfLoginRouteShows();
    }

    @Test
    public void accessingAdminUsersWhenLoggedOutTest() {
        driver.get(adminCitiesPage.getAdminUsersRoute());
        //Verify that URL shows /login route
        checkIfLoginRouteShows();
    }

    public void checkIfLoginRouteShows() {
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLoginRoute());
    }
}
