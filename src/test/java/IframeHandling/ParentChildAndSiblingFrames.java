package IframeHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildAndSiblingFrames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //switch to top Frame
        driver.switchTo().frame("frame-top");
        //switch to parent child left frame
        driver.switchTo().frame("frame-left");
        String leftFrame = driver.findElement(By.xpath("//body")).getText();
        System.out.println(leftFrame);

        //switch back to top Frame
        driver.switchTo().parentFrame();

        //switch to child middle Frame

        driver.switchTo().frame("frame-middle");
        String middleFrame = driver.findElement(By.id("content")).getText();
        System.out.println(middleFrame);

        //switch to Page
        driver.switchTo().defaultContent();

        // switch to second Top Frame
        driver.switchTo().frame("frame-bottom");
        String button = driver.findElement(By.xpath("//body")).getText();
        System.out.println(button);
        driver.quit();

    }
}
