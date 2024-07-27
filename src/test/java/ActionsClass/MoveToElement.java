package ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page3.html");
        Actions actions = new Actions(driver);
        WebElement menü=driver.findElement(By.id("blogsmenu"));
        actions.moveToElement(menü).perform();
        WebElement subMenü = driver.findElement(By.linkText("SeleniumByArun"));
        actions.moveToElement(subMenü).click().build().perform();

    }
}
