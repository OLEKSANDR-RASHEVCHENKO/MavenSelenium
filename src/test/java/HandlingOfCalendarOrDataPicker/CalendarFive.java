package HandlingOfCalendarOrDataPicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarFive {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/");
        driver.findElement(By.name("bdaytime")).sendKeys("14051999");
        driver.findElement(By.name("bdaytime")).sendKeys(Keys.TAB);
        driver.findElement(By.name("bdaytime")).sendKeys("1050");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }
}
