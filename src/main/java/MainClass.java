import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kuzmin_ad\\QA_Auto\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");
        selectOption("1");
        System.out.println("Selected option is: " + driver.findElement(By.xpath("//option[@selected='selected']")).getText());
        selectOption("2");
        System.out.println("Selected option is: " + driver.findElement(By.xpath("//option[@selected='selected']")).getText());

    }

    public static void selectOption (String option) {
        String optionXpath = String.format("//option[@value='%s']", option);
        driver.findElement(By.xpath("//select[@id='dropdown']")).click();
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
