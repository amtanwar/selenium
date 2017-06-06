import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOut {


    WebDriver driver;

    public SignOut(WebDriver driver) {
        this.driver = driver;
    }

    public String signout() {
        driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/ul[2]/li[1]/ul/li[5]/a")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a")).getText();
        return text;
    }
}
