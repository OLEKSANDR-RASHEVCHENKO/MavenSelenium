package IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/frame");
        driver.switchTo().frame("firstFr");
        driver.findElement(By.name("fname")).sendKeys("Alex");
        driver.findElement(By.name("lname")).sendKeys("Alex");
        WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
        driver.switchTo().frame(childFrame);
        driver.findElement(By.name("email")).sendKeys("Alex@ffdf.com");

    }
}
