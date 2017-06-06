import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginEd {

    WebDriver driver;
    Wait<WebDriver> wait;

    public LoginEd(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    public String loginTest() throws InterruptedException {

        driver.findElement(By.cssSelector("#header-II > section > nav > div > a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#inputName")));
        driver.findElement(By.cssSelector("#inputName")).clear();
        driver.findElement(By.cssSelector("#inputName")).sendKeys("akschoudhary18@gmail.com");
        driver.findElement(By.cssSelector("#pwd1")).clear();
        driver.findElement(By.cssSelector("#pwd1")).sendKeys("Amtanwar008");
        driver.findElement(By.xpath("//*[@id=\"signinForm\"]/div[4]/button")).click();

        String user = driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/a/span")).getText();
        return user;
    }

    public CookiesEd cookies() {
        return new CookiesEd(driver);
    }

}
