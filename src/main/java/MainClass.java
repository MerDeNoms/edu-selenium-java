import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Selenium Webdriver");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();


        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testmail");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("testpass");
        driver.findElement(By.xpath("//button[@name='login']")).submit();


//        driver.quit();

    }
}
