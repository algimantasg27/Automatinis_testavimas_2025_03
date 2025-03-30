package TracalorieApp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://practice.expandtesting.com/tracalorie/?classId=672fd27a-83d7-44cc-9e33-1abb45b3e5b8&assignmentId=545ad04a-04d6-4696-9b35-b9e565281828&submissionId=3a1d23f6-3a9d-d173-cabe-db5b60774ca2");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
