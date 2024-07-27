package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page3.html");
        WebElement link1 = driver.findElement(By.linkText("compendiumdev"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).moveToElement(link1).click().keyUp(Keys.CONTROL).build().perform();
    }
}
