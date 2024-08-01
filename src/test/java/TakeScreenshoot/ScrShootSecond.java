package TakeScreenshoot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScrShootSecond {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./Screenshoot/omayo.png");
//        FileUtils.copyFile(srcFile,destinationFile);
        FileHandler.copy(srcFile,destinationFile);


        driver.quit();

    }
}
