package IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        //switch to iframe
        driver.switchTo().frame("@id='mce_0_ifr");

        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Alex");
    }
}
