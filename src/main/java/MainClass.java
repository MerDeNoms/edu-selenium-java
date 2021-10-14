import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.google.ru/imghp?hl=ru");

        driver.findElement(By.xpath("//div[@aria-label='Поиск по картинке']")).click();
        driver.findElement(By.xpath("//a[text()='Загрузить изображение']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\kuzmin_ad\\QA_Auto\\Screenshot.png");

    }
}
