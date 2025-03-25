package JUnit_praktinis;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class JUnit_praktinis_Test {

    WebDriver driver;

    @BeforeEach
    void beforeEachTest() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @AfterEach
    void AfterEach() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Login tikrinimas")
    void testLogin() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
    }

    @Test
    void testWrongPassword() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        WebElement title = driver.findElement(By.cssSelector(".error-message-container h3"));
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedMessage, title.getText());
    }

    @Test
    void testLockedOutUser() {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("locked_out_user");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement title = driver.findElement(By.cssSelector(".error-message-container h3"));
        String expectedMessage = "this user has been locked out";
        assertTrue(title.getText().contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void testFileLogins(String username, String password
    ) {

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);

        driver.findElement(By.id("login-button")).click();

    }

    @Test
    void testTimeout() {

        assertTimeout(ofSeconds(2), () -> {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys("performance_glitch_user");

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();
        });
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    void testTimeoutParameterized(String USER_NAME, String PASSWORD) {

        assertTimeout(ofSeconds(2), () -> {
            WebElement inputUsername = driver.findElement(By.id("user-name"));
            inputUsername.sendKeys(USER_NAME);

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys(PASSWORD);

            driver.findElement(By.id("login-button")).click();
        });
    }

}
