import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://market.yandex.ru/");

        //captcha check
        if (driver.getTitle().equals("Ой!")) {
            driver.findElement(By.xpath("//div[@class='CheckboxCaptcha-Anchor']")).click();
        }

        driver.findElement(By.xpath("//div[@data-zone-name='category-link'][3]/div")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные и сушильные машины']")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        List <WebElement> checkboxes = driver.findElements(By.xpath("//input[contains(@name, 'Производитель')]/following-sibling::div/span"));

        if (checkboxes.size() == 12) System.out.println("OK");
        else System.out.println("NOT OK");

        for (WebElement checkbox : checkboxes) checkbox.click();

    }
}
