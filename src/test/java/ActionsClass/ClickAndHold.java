package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions = new Actions(driver);
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norway = driver.findElement(By.id("box101"));
        //actions.clickAndHold(oslo).moveToElement(norway).release().build().perform();//1 solution
        actions.dragAndDrop(oslo,norway).perform();//2 solution
    }
}
