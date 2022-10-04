package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void loginPageUrlTest (){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        homePage.visitsLoginPage();
        String actualResult = driver.getCurrentUrl();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
