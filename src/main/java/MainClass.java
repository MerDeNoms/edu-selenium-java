import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webserver.chrome.driver", "D://QA_Auto/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        driver.get("https://github.com");
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        if (button.getText().equals("Sign up for GitHub")) {
            System.out.println("Success");
        } else System.out.println("Fail");
//        button.submit();

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//button[@name='login']")).submit();

//        driver.quit();

    }
}
