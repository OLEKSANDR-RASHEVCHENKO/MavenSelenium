package HandlingJavaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertiNFORMATION {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.xpath("//*[@id='alert1']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String textOfAletr = alert.getText();
        System.out.println(textOfAletr);
//        alert.accept();
        alert.dismiss();
        driver.findElement((By.xpath("//*[@id='ta1']"))).sendKeys("Alex");
    }
}
