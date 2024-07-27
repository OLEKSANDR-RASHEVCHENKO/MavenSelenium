package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropBy {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page3.html");
        WebElement leftSlider = driver.findElement(By.xpath("//*[@aria-labelledby='price-min-label']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(leftSlider,100,0).perform();
    }
}
