package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{
//Test #1: Set locale to ES
//assert:
//•	Postaviti jezik na ES
//•	Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

    //Verify that
    @Test
    public void languageChangeToSpanish(){
        homePage.languageChangeToSpanish();
        String expectedResult = "de aterrizaje";
        String actualResult = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        //(driver.page_source).encode('utf-8')
        //String tmp = elem.getText();
        //String utfString = new String(tmp.getBytes(Charset.forName("utf-8")));
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void languageChangeToEnglish(){
        homePage.languageChangeToEnglish();
        String expectedResult = "Landing";
        String actualResult = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void languageChangeToFrance(){
        homePage.languageChangeToFrance();
        String expectedResult = "Page d'atterrissage";
        String actualResult = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
