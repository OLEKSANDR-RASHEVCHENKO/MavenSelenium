package TakeScreenshoot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShootFirstOprouch {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./Screenshots/omayo.png");
        FileUtils.copyFile(srcFile,destinationFile);
        driver.quit();
    }
}
