import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile {


    WebDriver driver;

    public Profile(WebDriver driver) {
        this.driver = driver;
    }

    public String profileUpdate() {
        driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"profile_description\"]")).sendKeys("A sample for updating profile.");
        driver.findElement(By.xpath("//*[@id=\"update_user_profile_btn\"]")).click();
        driver.navigate().refresh();
        String message = driver.findElement(By.xpath("//*[@id=\"profile_description\"]")).getText();
        return message;
    }

    public Goback history() {
        return new Goback(driver);
    }
}
