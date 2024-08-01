package StatitcAndDynamicTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        List<WebElement> headings = driver.findElements(By.xpath("//*[@id='table1']//th"));

        System.out.println(headings.size());

//        for (int i=0;i<headings.size();i++){
//            System.out.println(headings.get(i).getText());
//        }
        for (WebElement heading:headings){
            System.out.println(heading.getText()); // print heading
        }

        List<WebElement> datas = driver.findElements(By.xpath("//*[@id='table1']//tbody/tr//td"));// locator of all data

//        for (int i = 0;i<12;i++){
//            System.out.println(datas.get(i).getText());  // print of all data
//        }
        for (WebElement data:datas){
            System.out.println(data.getText());//foreach print of all data
        }


        driver.quit();
    }
}
