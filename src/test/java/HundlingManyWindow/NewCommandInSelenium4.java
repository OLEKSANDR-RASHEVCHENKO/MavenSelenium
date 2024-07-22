package HundlingManyWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewCommandInSelenium4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.xpath("//*[@id='ta1']")).sendKeys("Alex");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.linkText("Blog")).click();
    }
}
