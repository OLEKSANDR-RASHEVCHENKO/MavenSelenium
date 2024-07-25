package HandlingBootstrapDropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hdfcbank.com/");
        WebElement productTypesDropDown = driver.findElement(By.xpath("//div[@class='drp1']//a"));
        productTypesDropDown.click();
        driver.findElement(By.xpath("//li[text()='Account']")).click();
    }
}
