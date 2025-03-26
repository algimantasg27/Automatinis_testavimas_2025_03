package SimpleCalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.get("https://testpages.herokuapp.com/styled/calculator");
//        driver.get("https://automationtesting.co.uk/loadertwo.html");
        driver.get("https://automationtesting.co.uk/actions.html");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
