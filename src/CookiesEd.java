import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.Set;

public class CookiesEd {

    WebDriver driver;

    public CookiesEd(WebDriver driver) {
        this.driver = driver;
    }

    public boolean cookiesCheck() {
        Cookie name = new Cookie("Edureka", "1234567");
        driver.manage().addCookie(name);
        Cookie cookies= driver.manage().getCookieNamed("Edureka");
        if(cookies != null) {
            return true;
        }
        return false;
    }

    public boolean deleteCookie() {
        driver.manage().deleteCookieNamed("Edureka");
        Cookie cookieList = driver.manage().getCookieNamed("Edureka");

        if(cookieList == null) {
            return true;
        }
        return false;
    }

    public Profile profile() {
        return new Profile(driver);
    }
}
