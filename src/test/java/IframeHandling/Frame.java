package IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://docs.oracle.com/javase/8/docs/api/");
        driver.switchTo().frame("classFrame");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Description")).click();


    }
}
