import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webserver.chrome.driver", "D://QA_Auto/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");

    }
}
