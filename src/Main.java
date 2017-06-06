import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class Main {

    private static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:/selenium-java-2.35.0/chromedriver_win32_2.2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.edureka.co");
    }

    @Test
    public void testEdx() throws Exception {
        
        //Login
        
        LoginEd le = new LoginEd(driver);
        assertEquals(le.loginTest(), "AMIT");
        
        //cookies (manipulation)
        CookiesEd ce = le.cookies();
        assertTrue(ce.cookiesCheck());
        assertTrue(ce.deleteCookie());
        
        //Updating the profile
        Profile pe = ce.profile();
        assertEquals(pe.profileUpdate(), "A sample for updating profile.");
        
        //check the history
        Goback gb = pe.history();
        assertEquals(gb.goBack(),"https://www.edureka.co/");
        
        //Sign-out
        SignOut so = gb.signout();
        assertEquals(so.signout(),"SIGN IN");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
