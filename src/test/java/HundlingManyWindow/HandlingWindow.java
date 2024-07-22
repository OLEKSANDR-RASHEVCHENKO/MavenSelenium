package HundlingManyWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingWindow {
    static WebDriver driver = null;
    static Set<String> allChildWindow;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.xpath("//*[@id='ta1']")).sendKeys("Alex");
        String parentWindow=driver.getWindowHandle();

        driver.findElement(By.linkText("Open a popup window")).click();// first child windwo
        driver.findElement(By.linkText("Blogger")).click();// second child window
        allChildWindow = driver.getWindowHandles();
        switchToRequiredWindow("New Window");
        String textOnChildWindow=driver.findElement(By.xpath("//*[@class='example']")).getText();
        System.out.println(textOnChildWindow);

        switchToRequiredWindow("Blogger.com – Чтобы создать свой собственный блог, потребуется лишь несколько минут.");
        driver.findElement(By.xpath("//*[@class='sign-in ga-header-sign-in']")).click();

        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//*[@title='search']")).sendKeys("ALEX");

    }
    public static void switchToRequiredWindow(String Title){
        Iterator<String> itr = allChildWindow.iterator();
        while (itr.hasNext()){
            String window = itr.next();
            driver.switchTo().window(window);
            if (driver.getTitle().equals(Title)){
                break;
            }
        }
    }
}
