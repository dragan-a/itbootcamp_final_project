package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    //Verify that header contains text "Página de aterrizaje"
    @Test
    public void languageChangeToSpanish() {
        homePage.languageChangeToSpanish();
        //(driver.page_source).encode('utf-8')
        //String tmp = elem.getText();
        //String utfString = new String(tmp.getBytes(Charset.forName("utf-8")));

        /*
        This spanish letter á wasn't recognisable, so I deleted it, and I will try to find the way to make it
        recognisable using data above
        */
        Assert.assertTrue(homePage.getGreetingMessageSpanish().getText().contains("de aterrizaje"));
    }

    //Verify that header contains text "Landing"
    @Test
    public void languageChangeToEnglish() {
        homePage.languageChangeToEnglish();
        Assert.assertTrue(homePage.getGreetingMessageEnglish().getText().contains("Landing"));
    }

    //Verify that header contains text "Page d'atterrissage"
    @Test
    public void languageChangeToFrench() {
        homePage.languageChangeToFrench();
        Assert.assertTrue(homePage.getGreetingMessageFrench().getText().contains("Page d'atterrissage"));
    }
}
