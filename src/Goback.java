import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Goback {

    WebDriver driver;

    public Goback(WebDriver driver) {
        this.driver = driver;
    }

    public String goBack() {
        driver.navigate().back();
        String url = driver.getCurrentUrl();
        return url;
    }

    public SignOut signout() {
        return new SignOut(driver);
    }
}
