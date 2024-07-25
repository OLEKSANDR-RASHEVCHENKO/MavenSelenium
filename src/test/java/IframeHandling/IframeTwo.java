package IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTwo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blogpendingtasks.blogspot.com/p/switchtoframeusingwebelement.html");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='arunmotoori']"));

        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();

    }
}
