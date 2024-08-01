package TakeScreenshoot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshootOfAlertOrWithURL {
    public static void main(String[] args) throws IOException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.id("alert1")).click();

        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferImage = robot.createScreenCapture(rectangle);
        String destination = System.getProperty("user.dir")+"//Screenshoot//robot.png";
        ImageIO.write(bufferImage,"png",new File(destination));

        driver.quit();
    }
}
